
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
import javax.servlet.http.HttpSession;
import system.bo.clsBOStudent;
import system.dto.clsStudent;


@WebServlet(name="servUpdateInfo", urlPatterns={"/servUpdateInfo"})
public class servUpdateInfo extends HttpServlet {
   
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String isupdate = request.getParameter("isupdate");
        try {
            String login=(String) session.getAttribute("username");
            if(login==null){
              String path = "./jsps/jspChuaDangNhap.jsp";
              response.sendRedirect(path);
            }
            else {
               if(isupdate.equalsIgnoreCase("false")){//Xem thông tin sinh viên
                   getStudentInfo(session, response);
                }
               else if(isupdate.equalsIgnoreCase("true")){//cập nhật thông tin sinh viên
                  updateStudentInfo(session, request, response);
               }
            }
           
        } finally { 
            out.close();
        }
    }
    private void getStudentInfo(HttpSession session,HttpServletResponse response) throws Exception{
        String username=(String)session.getAttribute("username");
       clsBOStudent BOStudent=new clsBOStudent();
        clsStudent student =new clsStudent();
        student=BOStudent.getStudentInfoByCode(username);
       session.setAttribute("student", student);
       String path = "./jsps/jspThongTinSinhVien.jsp";
       response.sendRedirect(path);
    }
private void updateStudentInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException, Exception{
    String username=(String)session.getAttribute("username");
    String name=request.getParameter("name");
    String date=request.getParameter("day");
    String month=request.getParameter("month");
    String year=request.getParameter("year");
    String gender=request.getParameter("gender");
    String classs=request.getParameter("classs");
    String course=request.getParameter("course");
    String type=request.getParameter("type");
    String bachoc=request.getParameter("bachoc");
    String email=request.getParameter("email");
    String phone=request.getParameter("phone");
    String address=request.getParameter("address");
    String home=request.getParameter("home");
    String cmnd=request.getParameter("cmnd");
    String updateinfo="Thông tin mới cập nhật - Tên: "+ name + ", Ngày sinh: "+date+"/"+month+"/"+year+", Giới tính: "+gender+", Lớp: "+classs+
            ", Khóa: "+course+", Loại hình đào tạo: "+type+", Bậc học: "+bachoc+", Email: "+email+", Điện thoại: "+phone+
            ", Địa chỉ liên lạc: "+address+", Thường trú: "+home+", CMND: "+cmnd;
    clsBOStudent student=new clsBOStudent();
    student.updateStudentByStudent(updateinfo, username);
     String path = "./jsps/jspCapNhatThongTinOK.jsp";
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
            Logger.getLogger(servUpdateInfo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servUpdateInfo.class.getName()).log(Level.SEVERE, null, ex);
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
