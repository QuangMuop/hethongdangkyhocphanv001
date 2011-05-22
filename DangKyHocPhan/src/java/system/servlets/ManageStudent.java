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
import system.bo.clsBOStudent;
import system.dto.clsStudent;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="ManageStudent", urlPatterns={"/ManageStudent"})
public class ManageStudent extends HttpServlet {
   
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String function = (String) req.getParameter("function");
        if(function == null)
            function = "";
        if(function.equalsIgnoreCase("loaddata")){
            LoadData(req, resp);
        }else{
            Search(req, resp);
            return;
        }

        String path = "./jsps/jspQuanLySinhVien.jsp";
        resp.sendRedirect(path);
    }

    private void LoadData(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        clsBOStudent studentBo = new clsBOStudent();
        HttpSession session = req.getSession();

        try {
            listStudent = studentBo.GetAllStudent("MSSV");
        } catch (Exception ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("liststudent", listStudent);
    }

    private void Search(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//    typesearch="All";
//    name="";
//    action="search";
//    actor="Admin";
        String error = "OK";
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        String typeSearch = (String) req.getParameter("type");
        String action = (String) req.getParameter("action");
        String name = (String) req.getParameter("name");
        String actor = (String) req.getParameter("actor");
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        clsBOStudent studentBo = new clsBOStudent();

        try{
            if(typeSearch.equalsIgnoreCase("ALL")){
                listStudent = studentBo.GetAllStudent("MSSV");
            }else if(typeSearch.equalsIgnoreCase("name")){
                listStudent = studentBo.getStudentsByName(name);
            }else if(typeSearch.equalsIgnoreCase("mssv")){
                clsStudent student = new clsStudent();
                student = studentBo.getStudentInfoByCode(name);
                listStudent.add(student);
            }else if(typeSearch.equalsIgnoreCase("classname")){
                listStudent = studentBo.GetStudentsByClass(name, "MSSV");
            }
        }catch(Exception ex){
            error = ex.toString();
        }

        int n = listStudent.size();
        out.println("<tr><th>STT</th><th>Họ và tên</th><th>MSSV</th><th>Lớp</th><th>Ngày Sinh</th><th>Sửa</th><th>Xóa</th></tr>");
        for(int i = 0; i < n; i++){
            out.println("<tr><td>"+ (i+1) +"</td>"
                    + "<td>"+ listStudent.get(i).getFullname()+"</td>"
                    + "<td>"+ listStudent.get(i).getCode()+"</td>"
                    + "<td>"+ listStudent.get(i).getClasss()+"</td>"
                    + "<td>"+ listStudent.get(i).getBirthDay()+"</td>"
                    + "<td><a href='../StudentDetail?MSSV="+ listStudent.get(i).getCode()+"'>Sửa</a></td>"
                    + "<td><a href='../UpdateStudent?functionname=delete&mssv="+listStudent.get(i).getCode()+"'>Xóa</a></td></tr>");
        }

    }
}
