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
        String strErr = "";
        ArrayList<String> listInfomation = new ArrayList<String>();
        /**
     *     CELL 1// FullName//CELL2: MSSV//CELL3: BirthDay//CELL4: Lop - Class//CELL5: Email
     *     CELL6: PhoneNumber//CELL7: TamTru/CELL8: ThuongTru
     *     CELL: Status: Đang học, đang bảo lưu, đang ...
     *     CELL10: CourseNumber//CELL11: Sex//CELL12: ID (CMND)
     *     CELL13: Hình thức: Chính qui, tại chức, ...
     *     CELL14: Bậc học : đại học, cao đẳng, cử nhân, trung cấp,...
     */
        try{
            clsBOStudent studentBo = new clsBOStudent();
            clsStudent student = studentBo.getStudentInfoByCode(MSSV);
            listInfomation.add(student.getFullname());
            listInfomation.add(student.getCode());
            listInfomation.add(student.getBirthDay());
            listInfomation.add(student.getClasss());
            listInfomation.add(student.getEmail());
            listInfomation.add(student.getPhone());
            listInfomation.add(student.getAddress());
            listInfomation.add(student.getHome());
            listInfomation.add(student.getIsStuding());
            listInfomation.add(Integer.toString(student.getCourse()));
            listInfomation.add(student.getGender());
            listInfomation.add(student.getCMND());
            listInfomation.add(student.getType());
            listInfomation.add(student.getBacHoc());
        }catch(Exception ex){
            strErr = ex.toString();
        }
        
        session.setAttribute("listinfomation", listInfomation);
        String path = "./jsps/jspChiTietSinhVien.jsp?";
        resp.sendRedirect(path);
    }
}
