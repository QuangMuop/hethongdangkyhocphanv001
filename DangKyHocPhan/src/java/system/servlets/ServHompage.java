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
import system.bo.ClsBONews;
import system.dto.ClsNews;

/**
 *
 * @author Ultimate
 */
@WebServlet(name = "ServHompage", urlPatterns = {"/ServHompage"})
public class ServHompage extends HttpServlet {

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
         String action = request.getParameter("action");
        try {
            if(action.equalsIgnoreCase("view")){
            ClsBONews BON = new ClsBONews();
            ArrayList<ClsNews> List = BON.GetAllNews();
            session.setAttribute("news", List);
            String path = "./jsps/jspTrangChu.jsp";
            response.sendRedirect(path);
            }
            else if(action.equalsIgnoreCase("detail")){
                DetailNews(request, response, session);
            }
        } finally {
            out.close();
        }
    }
 private void DetailNews(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int Id = Integer.parseInt(request.getParameter("Id"));
        ClsBONews BON = new ClsBONews();
        ClsNews newinfo = BON.GetNewsInfo(Id);
        session.setAttribute("news", newinfo);
        String path = "./jsps/jspChiTietTinTuc.jsp";
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
            Logger.getLogger(ServHompage.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServHompage.class.getName()).log(Level.SEVERE, null, ex);
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
