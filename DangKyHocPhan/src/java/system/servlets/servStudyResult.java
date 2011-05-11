

package system.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.access.mapper.clsMapperStudyResult;
import system.bo.clsBOStudent;
import system.dto.clsStudent;
import system.dto.clsStudyResult;

@WebServlet(name="servStudyResult", urlPatterns={"/servStudyResult"})
public class servStudyResult extends HttpServlet {
   
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
            String login=(String) session.getAttribute("username");
            if(login==null){
              String path = "./jsps/jspChuaDangNhap.jsp";
              response.sendRedirect(path);
            }
            else {
              getStudyResult(request, response, session,login);
               }
            
          
        } finally { 
            out.close();
        }
    } 
private void getStudyResult(HttpServletRequest request, HttpServletResponse response,HttpSession session, String user) throws Exception{
    clsMapperStudyResult mps=new clsMapperStudyResult();
              ArrayList<clsStudyResult> sr=mps.getYear(user);
              session.setAttribute("year", sr);
              clsBOStudent BOStudent=new clsBOStudent();
              clsStudent student =new clsStudent();
              student=BOStudent.getStudentInfoByCode(user);
              session.setAttribute("student", student);
              String path = "./jsps/jspXemKQHocTap.jsp";
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
            Logger.getLogger(servStudyResult.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servStudyResult.class.getName()).log(Level.SEVERE, null, ex);
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
