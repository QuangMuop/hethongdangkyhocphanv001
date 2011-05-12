package system.servlets;

import java.io.IOException;
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
@WebServlet(name="ViewListStudent", urlPatterns={"/ViewListStudent"})
public class ViewListStudent extends HttpServlet {
       
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
        
        HttpSession session = req.getSession();
        try {
             session.removeAttribute("listinfomation");
        } catch (Exception ex) {
            Logger.getLogger(ViewListStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        String search = (String) req.getParameter("search");        
        String order = (String) req.getParameter("order");
        String className = (String) req.getParameter("sSearch");
        String mssv = "";
        String fullName = "";
        mssv = (String) req.getParameter("txtMSSV");
        fullName = (String) req.getParameter("txtFullName");

        if(className != null){
            session.setAttribute("classnametemp", className);
        }else{
            className = (String) session.getAttribute("classnametemp");
        }

        if((className!=null && className.equals("ALL") && search.equals("yes")))
            search = "no";

        ArrayList<String> listInfomation = new ArrayList<String>();
        try {
             listInfomation = PrepareDate(search, className, order, mssv, fullName);
        } catch (Exception ex) {
            Logger.getLogger(ViewListStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        String path = "./jsps/jspDanhSachSinhVien.jsp";
        session.setAttribute("listinfomation", listInfomation);
        resp.sendRedirect(path);
    }

    private ArrayList<String> PrepareDate(String search, String className, String order, String mssv, String fullName) throws Exception{
        ArrayList<String> listInfomation = new ArrayList<String>();
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        clsBOStudent studentBo = new clsBOStudent();
        if(search.equals("yes")){
            listStudent = studentBo.GetStudentsByClass(className, order);
        }else if(search.equals("no")){
            listStudent = studentBo.GetAllStudent(order);
        }else if(search.equals("frmMSSV")){
            clsStudent student = new clsStudent();
            student = studentBo.getStudentInfoByCode(mssv);
            if(student != null)
                listStudent.add(student);
        }else if(search.equals("frmFullName")){
            clsStudent student = new clsStudent();
            student = studentBo.getStudentInfoByName(fullName);
            if(student != null)
                listStudent.add(student);
        }

        int n = listStudent.size();
        int i = 0;
        //Fullname, MSSV, BirthDay, ClassName, Email, Phone, Address,Home,
        //IsStudying, courseCode, gender, CMND, Type, Bac hoc, Note
        for(i = 0; i < n; i++){
            clsStudent studentTemp = listStudent.get(i);
            listInfomation.add(studentTemp.getFullname());
            listInfomation.add(studentTemp.getCode());
            listInfomation.add(studentTemp.getBirthDay());
            listInfomation.add(studentTemp.getClasss());
            listInfomation.add(studentTemp.getEmail());
            listInfomation.add(studentTemp.getPhone());
            listInfomation.add(studentTemp.getAddress());
            listInfomation.add(studentTemp.getHome());
            listInfomation.add(studentTemp.getIsStuding());
            listInfomation.add(Integer.toString(studentTemp.getCourse()));
            listInfomation.add(studentTemp.getGender());
            listInfomation.add(studentTemp.getCMND());
            listInfomation.add(studentTemp.getType());
            listInfomation.add(studentTemp.getBacHoc());
            listInfomation.add(studentTemp.getNote());
        }
        return listInfomation;
    }
}
