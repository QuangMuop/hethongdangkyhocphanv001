package system.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
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
@WebServlet(name="ManageLecturer", urlPatterns={"/ManageLecturer"})
public class ManageLecturer extends HttpServlet {
   
   
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
        HttpSession seesion = req.getSession();
        String searchEngine = "";
        String error = "";
        searchEngine = (String) req.getParameter("action");
        if(searchEngine == null)
            searchEngine = "";
        if(searchEngine.equalsIgnoreCase("search")){
            error = Search(req, resp);
            return;
        }else{
            error = PrepareData(seesion);
        }
        String path = "./jsps/jspQuanLyGiangVien.jsp";
        if(!error.equalsIgnoreCase("OK")){
            seesion.setAttribute("mes", error);
            path = "./jsps/jspThongBao.jsp";
        }
        resp.sendRedirect(path);
    }
    
    private String PrepareData(HttpSession session){
        String error = "OK";
        clsBOLecturer lecturerBo = new clsBOLecturer();
            ArrayList<clsLecturer> listLecturer = null;
        try {
            listLecturer = lecturerBo.GetAllLecturer();
        } catch (Exception ex) {
            Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
            error = ex.toString();
        }

        if(listLecturer != null){
            session.setAttribute("listlecturer", listLecturer);
        }
        return error;
    }

    private String Search(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String result = "OK";
        PrintWriter out = resp.getWriter();
        String type=req.getParameter("type");
        String name = req.getParameter("name");

        ArrayList<clsLecturer> listLecturer = new ArrayList<clsLecturer>();
        clsBOLecturer lecturerBo = new clsBOLecturer();
        if(type.equalsIgnoreCase("id")){
            try {
                clsLecturer lecturer = lecturerBo.getLecturereByCode(name);
                listLecturer.add(lecturer);
            } catch (Exception ex) {
                Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(type.equalsIgnoreCase("name")){
            try {
                listLecturer = lecturerBo.GetLecturerByName(name);
            } catch (Exception ex) {
                Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(type.equalsIgnoreCase("ALL")){
            try {
                listLecturer = lecturerBo.GetAllLecturer();
            } catch (Exception ex) {
                Logger.getLogger(ManageLecturer.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

        if(listLecturer == null)
            return "Not found";


        out.println("<tr><th>STT</th><th>Mã GV</th><th>Họ và tên</th><th>Ngày Sinh</th><th>Học Hàm</th><th>Học Vị</th><th>ĐT</th><th>Địa chỉ</th><th>Sửa</th><th>Xóa</th>");
        for(int i=0;i<listLecturer.size();i++){
            out.println(""
                    + "<tr>"
                    + "<td>"+(i+1)+"</td>"
                    + "<td><a href='../LecturerDetail?lecturerecode="+ listLecturer.get(i).getLecturerCode()+"'>"+listLecturer.get(i).getLecturerCode()+"</a></td>"
                    + "<td>" + listLecturer.get(i).getFullname()+ "</td>"
                    + "<td>" + listLecturer.get(i).getBirthDay()+ "</td>"
                    + "<td>" + listLecturer.get(i).getHocHam()+ "</td>"
                    + "<td>" + listLecturer.get(i).getHocVi()+ "</td>"
                    + "<td>" + listLecturer.get(i).getPhone()+ "</td>"
                    + "<td>" + listLecturer.get(i).getAddress()+ "</td>"
                    + "<td><a href='../UpdateLecturer?id=" + listLecturer.get(i).getLecturerCode() + "&function=update'>Sửa</a></td>"
                    + "<td><a href='../UpdateLecturer?id=" + listLecturer.get(i).getLecturerCode() + "&function=delete'> Xóa</a></td>");
        }
        return result;
    }
}
