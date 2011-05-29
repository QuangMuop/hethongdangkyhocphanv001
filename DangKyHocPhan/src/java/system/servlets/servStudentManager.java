/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.bo.clsBOAccount;
import system.bo.clsBOCourse;
import system.bo.clsBOStudent;
import system.dto.clsCourse;
import system.dto.clsStudent;

/**
 *
 * @author Ultimate
 */
@WebServlet(name="servStudentManager", urlPatterns={"/servStudentManager"})
public class servStudentManager extends HttpServlet {
   
    /**
     * rows IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        clsBOAccount BOA=new clsBOAccount();
        String login=(String) session.getAttribute("username");
        try {
            String action =request.getParameter("action");
             if(action.equalsIgnoreCase("view")) {
                getAllStudent(response, session);
             } else if(action.equalsIgnoreCase("view")) {
                getAllStudent(response, session);
             }
            else if(action.equalsIgnoreCase("search")) {
               searchStudent(request, response);
             }
            else if(action.equalsIgnoreCase("create")) {
               CreateStudent(response, session);
             }
            else if(action.equalsIgnoreCase("addone")) {
                   InsertOneStudent(request, response, session);
             }
            else if(action.equalsIgnoreCase("addlist")) {

             }
        } finally { 
            out.close();
        }
    } 
    private void InsertOneStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        String MSSV=request.getParameter("txtMSSV");
        String FullName=request.getParameter("txtname");
        String Birthday=request.getParameter("sYear")+"-"+request.getParameter("sMonth")+"-"+request.getParameter("sDay");
        String Gender=request.getParameter("sSex");
        String Class=request.getParameter("sClass");
        int CourseCode=Integer.parseInt(request.getParameter("sCourse"));
        String Type=request.getParameter("sType");
        String BacHoc=request.getParameter("sBacHoc");
        String Home=request.getParameter("txthome");
        String Address=request.getParameter("txtadd");
        String CMND=request.getParameter("txtcmnd");
        String NhapHoc=request.getParameter("sYear1")+"-"+request.getParameter("sMonth1")+"-"+request.getParameter("sDay1");
        String Phone=request.getParameter("txtphone");
        String Email=request.getParameter("txtemail");
        clsStudent cls=new clsStudent(FullName, Birthday, MSSV, Class, Email, Phone, Address, Home, "Đang học", CourseCode, NhapHoc, Gender, CMND, Type, BacHoc);
        clsBOStudent BOS=new clsBOStudent();
        if(BOS.CheckExistedCode(MSSV)){
            session.setAttribute("mes", "Thêm sinh viên thất bại vì Mã số sinh viên này đã tồn tại!");
            String path = "./jsps/jspThongBao.jsp";
            response.sendRedirect(path);
        }else{
            if(BOS.Insert(cls)){
                session.setAttribute("mes", "Thêm sinh viên thành công!");
            String path = "./jsps/jspThongBao.jsp";
            response.sendRedirect(path);
            }else {
                session.setAttribute("mes", "Thêm sinh viên thất bại vui lòng kiểm tra lại!");
            String path = "./jsps/jspThongBao.jsp";
            response.sendRedirect(path);
            }
        }
        
    }
    /**
     *
     * @param response
     * @param session
     * @throws IOException
     * @throws Exception
     */
    private void CreateStudent(HttpServletResponse response, HttpSession session) throws IOException, Exception{
        clsBOCourse BOC=new clsBOCourse();
        ArrayList<String> listClass=BOC.getAllClassName();
        session.setAttribute("listClass", listClass);
        ArrayList<clsCourse> listCourse=BOC.GetAllCorse();
        session.setAttribute("listCourse", listCourse);
        String path = "./jsps/jspTiepNhanSV.jsp";
        response.sendRedirect(path);
    }
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws Exception
     */
    private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception{
        PrintWriter out = response.getWriter();
        String type=request.getParameter("type");
        String name=request.getParameter("name");
        clsBOStudent BOS=new clsBOStudent();
        ArrayList<clsStudent> studentlist=new ArrayList<clsStudent>();
        if(type.equalsIgnoreCase("mssv")){
            studentlist=BOS.getStudentsByCode(name);
        }else if(type.equalsIgnoreCase("name")){
            studentlist=BOS.getStudentsByName(name);
        }else if(type.equalsIgnoreCase("classname")){
           studentlist=BOS.GetStudentsByClass(name);
        }else if(type.equalsIgnoreCase("All")){
            studentlist=BOS.GetAllStudent();
        }
        out.println("<tr><th>STT</th><th>MSSV</th><th>Họ Tên</th><th>Lớp</th><th>Ngày sinh</th><th>Giới tính</th><th>Loại</th><th>Sửa</th><th>Xóa</th></tr>");
        for(int i=0;i<studentlist.size();i++){
            StringBuffer str=new StringBuffer();
            str.append("<tr><td>").append(i + 1).append("</td>");
            str.append("<td>").append(studentlist.get(i).getCode()).append("</a></td>");
            str.append("<td>").append(studentlist.get(i).getFullname()).append("</td>");
            str.append("<td>").append(studentlist.get(i).getClasss()).append("</td>");
            str.append("<td>").append(studentlist.get(i).getBirthDay()).append("</td>");
            str.append("<td>").append(studentlist.get(i).getGender()).append("</td>");
            str.append("<td>").append(studentlist.get(i).getType()).append("</td>");
            str.append("<td><a href='../servStudentManager?MSSV=").append(studentlist.get(i).getCode()).append("'>Sửa</a></td>");
            str.append("<td><a href='../servStudentManager?MSSV=").append(studentlist.get(i).getCode()).append("'>Xóa</a></td>");
            out.println(str.toString());
        }
    }
    /**
     *
     * @param response
     * @param session
     * @throws Exception
     */
private void getAllStudent(HttpServletResponse response, HttpSession session) throws Exception{
        clsBOStudent BOS=new clsBOStudent();
        ArrayList<clsStudent> listStudent=BOS.GetAllStudent();
        session.setAttribute("liststudent", listStudent);
       clsBOCourse BOC=new clsBOCourse();
        ArrayList<String> listClass=BOC.getAllClassName();
        session.setAttribute("listClass", listClass);
        String path = "./jsps/jspQuanLySinhVien.jsp";
        response.sendRedirect(path);
}
     /**
      *
      * @param request
      * @param response
      * @throws ServletException
      * @throws IOException
      */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(servStudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(servStudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
