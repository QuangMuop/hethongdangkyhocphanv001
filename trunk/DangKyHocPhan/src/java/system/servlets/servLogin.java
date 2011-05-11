
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

@WebServlet(name="servLogin", urlPatterns={"/servLogin"})
public class servLogin extends HttpServlet {
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
         String login = (String) request.getParameter("login");
        try {
             if(login.equalsIgnoreCase("true")){//login
            Login(session, request, response);
              }
            else if(login.equalsIgnoreCase("false")){//logout
            LogOut(session, request, response);
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
private void Login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
              String user=request.getParameter("txtUsername");
             String pass=request.getParameter("txtPassword");
            clsBOAccount BOAccount=new clsBOAccount();
            if(BOAccount.Login(user, pass)){
                session.setAttribute("username", user);
                String path = "./jsps/jspTrangChu.jsp";
                response.sendRedirect(path);

            } else {
                String path = "./jsps/jspLoginFail.jsp";
                response.sendRedirect(path);
            }
}
private void LogOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException{
               session.removeAttribute("username");
               session.removeAttribute("student");
               String path = "./jsps/jspTrangChu.jsp";
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
            Logger.getLogger(servLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servLogin.class.getName()).log(Level.SEVERE, null, ex);
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
