
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
import system.bo.clsBOComment;
import system.dto.clsComment;

@WebServlet(name = "servCommentManager", urlPatterns = {"/servCommentManager"})
public class servCommentManager extends HttpServlet {

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
        String user=(String) session.getAttribute("username");
        try {
          String action=request.getParameter("action");
                if(action.equalsIgnoreCase("view")){
                    getAllComment(response, session);
                }
                else if(action.equalsIgnoreCase("delete")){
                    deleteComment(request, response, session);
                }
                else if(action.equalsIgnoreCase("detail")){
                    detailComment(request, response, session);
                }
            
        } finally {            
            out.close();
        }
    }
 private void detailComment(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
        int Id=Integer.parseInt(request.getParameter("Id"));
        clsBOComment BOC=new clsBOComment();
        clsComment comment=BOC.getCommentInfo(Id);
        session.setAttribute("comment", comment);
        String path = "./jsps/jspChiTietComment.jsp";
        response.sendRedirect(path);
    }
    private void deleteComment(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
        int Id=Integer.parseInt(request.getParameter("Id"));
        clsBOComment BOC=new clsBOComment();
        BOC.deleteComment(Id);
        getAllComment(response, session);
    }
private void getAllComment(HttpServletResponse response,HttpSession session) throws Exception{
    clsBOComment BOC=new clsBOComment();
    ArrayList<clsComment> listcomment=BOC.getAllComment();
    session.setAttribute("comment", listcomment);
    String path = "./jsps/jspQuanLyComment.jsp";
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
            Logger.getLogger(servCommentManager.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servCommentManager.class.getName()).log(Level.SEVERE, null, ex);
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
