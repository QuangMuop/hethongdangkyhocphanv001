package system.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.bo.clsBOLecturer;
import system.dto.clsLecturer;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="LecturerDetail", urlPatterns={"/LecturerDetail"})
public class LecturerDetail extends HttpServlet {
   
   
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
        PrintWriter out = resp.getWriter();

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();

        String lecturerId = req.getParameter("lecturerecode");
        String strErr = "";
        ArrayList<String> listInfomation = new ArrayList<String>();
        //1. LecturerCode,   2. FullName,     3. BirthDay, 4. Email, 5. Phone
        //6. Address,   7. HocHam,  8. Degree,  9.Gender,   10. CMND.
        try{
            clsBOLecturer lecturerBo = new clsBOLecturer();
            clsLecturer lecturer = lecturerBo.getLecturereByCode(lecturerId);

            listInfomation.add(lecturer.getLecturerCode());
            listInfomation.add(lecturer.getFullname());
            listInfomation.add(lecturer.getBirthDay());
            listInfomation.add(lecturer.getEmail());
            listInfomation.add(lecturer.getPhone());
            listInfomation.add(lecturer.getAddress());
            listInfomation.add(lecturer.getHocHam());
            listInfomation.add(lecturer.getHocVi());
            listInfomation.add(lecturer.getGender());
            listInfomation.add(lecturer.getCMND());
        }catch(Exception ex){
            strErr = ex.toString();
        }

        session.setAttribute("listinfomation", listInfomation);
        String path = "./jsps/jspChiTietGV.jsp";
        resp.sendRedirect(path);
    }
}
