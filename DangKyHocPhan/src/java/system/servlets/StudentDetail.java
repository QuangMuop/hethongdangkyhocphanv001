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
@WebServlet(name="StudentDetail", urlPatterns={"/StudentDetail"})
public class StudentDetail extends HttpServlet {
   
    
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

        String MSSV = req.getParameter("MSSV");        

        clsStudent student = new clsStudent();
        try{
            clsBOStudent studentBo = new clsBOStudent();
            student = studentBo.getStudentInfoByCode(MSSV);            
        }catch(Exception ex){
            Logger.getLogger(StudentDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("student", student);        
        String path = "./jsps/jspThongTinSinhVien.jsp";
        resp.sendRedirect(path);
    }
}
