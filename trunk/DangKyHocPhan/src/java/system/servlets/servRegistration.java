
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
import system.bo.clsBOProgram;
import system.bo.clsBOStudent;
import system.dto.clsClass;
import system.dto.clsProgram;
import system.dto.clsStudent;

@WebServlet(name="servRegistration", urlPatterns={"/servRegistration"})
public class servRegistration extends HttpServlet {
   
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
        try {
            session.setAttribute("username", "07520319");
            String login=(String) session.getAttribute("username");
            if(login==null){
             session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
            }
            else {
                String first=request.getParameter("reg");
                if(first.equalsIgnoreCase("view")){
                    getAllClass(request, response, session);
                } else if(first.equalsIgnoreCase("registry")){
                    registry(request, response, session);
             }
                else if(first.equalsIgnoreCase("preview")){
                    preview(request, response, session);
                }
            }


        } finally {
            out.close();
        }
    }
    private void registry(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException{
          session.setAttribute("mes", "Đăng ký thành công!"+(String) session.getAttribute("username"));
      String path = "./jsps/jspThongBao.jsp";
      resp.sendRedirect(path);
    }
     private void preview(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException{
          session.setAttribute("mes", "xem trước đi "+(String) session.getAttribute("username"));
      String path = "./jsps/jspThongBao.jsp";
      resp.sendRedirect(path);
    }
    /**
     *
     * @param req
     * @param resp
     * @param session
     * @throws IOException
     * @throws Exception
     */
private void getAllClass(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException, Exception{
              String login=(String) session.getAttribute("username");
              clsBOStudent BOStudent=new clsBOStudent();
             clsStudent student=BOStudent.getStudentInfoByCode(login);
              session.setAttribute("student", student);
              clsBOClass BOClass=new clsBOClass();
              ArrayList<clsClass> result=BOClass.GetAllClass("ClassName");
              session.setAttribute("clases", result);
             String path = "./jsps/jspDangKyMonHoc.jsp";
             resp.sendRedirect(path);
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
            Logger.getLogger(servRegistration.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servRegistration.class.getName()).log(Level.SEVERE, null, ex);
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
