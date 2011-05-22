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
import system.access.mapper.clsMapperViewProgram;
import system.bo.clsBOAccount;
import system.bo.clsBOStudent;
import system.dto.clsStudent;
import system.dto.clsViewProgram;

@WebServlet(name="servProgram", urlPatterns={"/servProgram"})
public class servProgram extends HttpServlet {
   
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
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        clsBOAccount BOA=new clsBOAccount();
        try {
           String login=(String) session.getAttribute("username");
            if(login==null){
             session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
           }
            else {
               if( BOA.getAccountType(login)==0)
              getProgram(response, session, login);
               else {
                   session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập với tài khoản sinh viên!");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
               }
               }
        } finally { 
            out.close();
        }
    } 
private void getProgram(HttpServletResponse response,HttpSession session, String user) throws Exception{
              clsBOStudent BOStudent=new clsBOStudent();
              clsStudent student =new clsStudent();
              student=BOStudent.getStudentInfoByCode(user);
              session.setAttribute("student", student);
              clsMapperViewProgram mppr=new clsMapperViewProgram();
              ArrayList<clsViewProgram> pro=mppr.getProgramByCode(user);
              session.setAttribute("pro", pro);
              String path = "./jsps/jspXemChuongTrinhDaoTao.jsp";
              response.sendRedirect(path);
              }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            Logger.getLogger(servProgram.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servProgram.class.getName()).log(Level.SEVERE, null, ex);
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
