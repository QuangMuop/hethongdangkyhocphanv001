
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
import system.bo.clsBOAccount;
import system.bo.clsBOClass;
import system.dto.clsClass;

/**
 *
 * @author Ultimate
 */
@WebServlet(name = "servUpdateScore", urlPatterns = {"/servUpdateScore"})
public class servUpdateScore extends HttpServlet {

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
        String login=(String) session.getAttribute("username");
        try {
           // if(login==null){
              //  session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
               //   String path = "./jsps/jspThongBao.jsp";
               // response.sendRedirect(path);
           // }
           // else{
                String action =request.getParameter("action");
               if(action.equalsIgnoreCase("view")) {
                // if(BOA.getAccountType(login)==1)
                     getAllClass(response, session);
               // else{
                   //   session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập với tài khoản quản lý!");
                //  String path = "./jsps/jspThongBao.jsp";
               // response.sendRedirect(path);
               // }
            // }
           }
          
        } finally {            
            out.close();
        }
    }
private void getAllClass(HttpServletResponse resp, HttpSession session) throws IOException, Exception{
             clsBOClass BOClass=new clsBOClass();
             ArrayList<clsClass> result=BOClass.GetAllClass("ClassName");
             session.setAttribute("clases", result);
             String path = "./jsps/jspGhiNhanDiem.jsp";
             resp.sendRedirect(path);
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
            Logger.getLogger(servUpdateScore.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servUpdateScore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * 
     * @return 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
