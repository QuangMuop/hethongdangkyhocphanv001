
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
import system.bo.clsBOAccount;

@WebServlet(name="servChangePass", urlPatterns={"/servChangePass"})
public class servChangePass extends HttpServlet {
   
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        clsBOAccount BOA=new clsBOAccount();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         HttpSession session = request.getSession();
         String login=(String) session.getAttribute("username");
        try {
            if(login==null){
             session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
            }
            else {
               String change=request.getParameter("change");
               if(change.equalsIgnoreCase("firts")){
                   if(BOA.getAccountType(login)==0){
                   String path = "./jsps/jspDoiMatKhau.jsp";
                     response.sendRedirect(path);
                   }else{
                         session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập với tài khoản sinh viên!");
                          String path = "./jsps/jspThongBao.jsp";
                         response.sendRedirect(path);
                   }
               }
               else if(change.equalsIgnoreCase("change")){
                   changepass(login, session, request, response);
              }
            }
        } finally { 
            out.close();
        }
    }
    /**
     * 
     * @param session
     * @param request
     * @param response
     * @throws Exception
     */
private void changepass(String username, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
    String newpass=request.getParameter("newpass");
    clsBOAccount BOA=new clsBOAccount();
    BOA.changePass(username, newpass);
    session.setAttribute("mes", "Đổi mật khẩu thành công!");
    session.setAttribute("pass", newpass);
    String path = "./jsps/jspThongBao.jsp";
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
            Logger.getLogger(servChangePass.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servChangePass.class.getName()).log(Level.SEVERE, null, ex);
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
