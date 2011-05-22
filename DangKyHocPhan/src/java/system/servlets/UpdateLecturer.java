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
import system.bo.clsBOClass;
import system.bo.clsBOLecturer;
import system.dto.clsClass;
import system.dto.clsLecturer;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="UpdateLecturer", urlPatterns={"/UpdateLecturer"})
public class UpdateLecturer extends HttpServlet {
      
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
        PrintWriter out = resp.getWriter();

        String id = (String) req.getParameter("id");
        String function = (String) req.getParameter("function");
        String error = "";
        String path = "./jsps/jspThongBao.jsp";


        if(function.equals("update")){
            error = Update(session, id);
            if(error.equals("OK"))
                path = "./jsps/jspCapNhatGV.jsp";
        }else if(function.equals("delete")){
            error = Delete(id);
            session.setAttribute("mes", error);
        }else if(function.equals("reupdate")){
            error = ReUpdate(req);
        }

        if(error.equals("OK"))
            error = "Thao tác được ghi nhận";
        resp.sendRedirect(path);
    }

    /**
     * Load database, send it to really change form
     * @param session
     * @param lecturerId
     * @return
     */
    private String Update(HttpSession session, String lecturerId){
        String error = "OK";
        clsLecturer lecturer = null;
        clsBOLecturer lecturerBo = new clsBOLecturer();
        try {
            lecturer = lecturerBo.getLecturereByCode(lecturerId);
        } catch (Exception ex) {
            Logger.getLogger(UpdateLecturer.class.getName()).log(Level.SEVERE, null, ex);
            error = ex.toString();
        }
        if(lecturer != null)
            session.setAttribute("lecturer", lecturer);

        return error;
    }

    /**
     * Called when really change infomation in database
     * @param req
     * @return
     */
    private String ReUpdate(HttpServletRequest req){
        String result = "OK";

        try {
            String lecturerCode = req.getParameter("txtLecturerCode");
            String FullName = req.getParameter("txtFullName");
            String BirthDay = req.getParameter("sYear") + "-" +
                               (String) req.getParameter("sMonth") + "-" +
                               (String) req.getParameter("sDay");
            String Email = req.getParameter("txtEmail");
            String Phone = req.getParameter("txtPhoneNumber");
            String Address = req.getParameter("txtAddress");
            String HocHam = req.getParameter("sHocHam");
            String HocVi = req.getParameter("sHocVi");
            String Sex = req.getParameter("sSex");
            String CMND = req.getParameter("txtCMND");

            clsLecturer lecturer = new clsLecturer(FullName, BirthDay, Email, Phone, Address, HocHam, HocVi, Sex, CMND);
            lecturer.setLecturerCode(lecturerCode);
            clsBOLecturer lecturerBo = new clsBOLecturer();
            lecturerBo.LecturerUpdate(lecturer);
            //return UpdateLecturer(listInfomation);

        } catch (Exception ex) {
            Logger.getLogger(RegistryLecturer.class.getName()).log(Level.SEVERE, null, ex);
            result = ex.toString();
        }
        return result;
    }

    private String Delete(String lecturerId){
        String result = "";
        clsBOLecturer lecturerBo = new clsBOLecturer();
        clsLecturer lecturer = null;
        clsBOClass classBo = new clsBOClass();
        ArrayList<clsClass> listClass = new ArrayList<clsClass>();
        try {
            lecturer = lecturerBo.getLecturereByCode(lecturerId);
            listClass = classBo.GetAllClassByLecturer(lecturerId);
            int n = listClass.size();
            int i;
            lecturerBo.LecturerDeleteByCode(lecturerId);
            result += "Đã xóa GV: " + lecturer.getFullname() + "<br/>";

            for(i = 0; i < n; i++){
                classBo.ClassDelete(listClass.get(i).getClassName());
                result += "Đã xóa lớp: " + listClass.get(i).getClassName() + " do GV "
                        + lecturer.getFullname()+ "giảng dạy.<br/>";
            }            
        } catch (Exception ex) {
            Logger.getLogger(UpdateLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
