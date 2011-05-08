package system.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import system.access.mapper.clsMapperLecturer;
import system.dto.clsLecturer;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="justfortest", urlPatterns={"/justfortest"})
public class justfortest extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");        
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("Search"))
            SerchAction(req, resp);
        else if(action.equalsIgnoreCase("Insert")){
            InsertAction(req, resp);
        }       
    }

    private void SerchAction(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        PrintWriter out = resp.getWriter();
        String name = (String)req.getParameter("txtName");
        out.println("Name entered: " + name);
        try {
            clsMapperLecturer lMapper = new clsMapperLecturer();
            clsLecturer lecturer = new clsLecturer();
            lecturer = lMapper.getLecturerInfo(name);
            out.println("<br/>" + lecturer.getFullname());
            out.println("<br/>" + lecturer.getAddress());
            out.println("<br/>" + lecturer.getBirthDay());
        } catch (Exception ex) {
            Logger.getLogger(justfortest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean InsertAction(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        PrintWriter out = resp.getWriter();
        out.println("<br/>Insert Action called");

//        String LecturerCode = (String)req.getParameter("txtId");
//        String FullName = (String)req.getParameter("txtFullName");
//        String sDay = (String)req.getParameter("sDay");
//        String sMonth = (String)req.getParameter("sMonth");
//        String sYear = (String)req.getParameter("sYear");
//        String BirthDay = sYear + "-" + sMonth + "-" + sDay;
//        String Email = (String)req.getParameter("txtEmail");
//        String Phone = (String)req.getParameter("txtPhone");
//        String Address = (String)req.getParameter("txtAddress");
//        String HocHam = (String)req.getParameter("sHocHam");
//        String HocVi = (String)req.getParameter("sHocVi");
        String LecturerCode = "GV006";
        String FullName = "Huỳnh Ngọc Tín";
        String BirthDay = "1975-5-5";
        String Email = "thuongnh@uit.edu.vn";
        String Phone = "01683508402";
        String Address = "HCM";
        String HocHam = "null";
        String HocVi = "Thạc sĩ";

     clsLecturer lecturer = new clsLecturer(FullName, BirthDay, Email, Phone, Address, HocHam, HocVi,"","");
        lecturer.setLecturerCode(LecturerCode);
        try {
            clsMapperLecturer mapper = new clsMapperLecturer();
            boolean checkCode = mapper.LecturerCheckExistCode(LecturerCode);
            if(checkCode == true){
                out.println("Ma GV da ton tai");
                return false;
            }
            mapper.LecturerInsert(lecturer);
            out.println("Đã thêm ông/bà: " + FullName + " vào giỏ");
        } catch (Exception ex) {
            Logger.getLogger(justfortest.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.println("<br/>" + LecturerCode);
        out.println("<br/>" + FullName);
        out.println("<br/>" + BirthDay);
        out.println("<br/>" + Email);
        out.println("<br/>" + Phone);
        out.println("<br/>" + Address);
        out.println("<br/>" + HocHam);
        out.println("<br/>" + HocVi);
        return false;
    }

}
