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
import system.bo.clsBOAccount;
import system.dto.ClsNews;

@WebServlet(name = "ServNews", urlPatterns = {"/ServNews"})
public class ServNews extends HttpServlet {

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
        clsBOAccount BOA = new clsBOAccount();
        String user = (String) session.getAttribute("username");
        try {
            if (user == null) {
                session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
                String path = "./jsps/jspThongBao.jsp";
                response.sendRedirect(path);
            } else {
                String action = request.getParameter("action");
                 if (action.equalsIgnoreCase("view")) {
                    if (BOA.getAccountType(user) == 1) {
                        GetAllNews(response, session);
                    } else {
                        session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập bằng tài khoản quản lý!");
                        String path = "./jsps/jspThongBao.jsp";
                        response.sendRedirect(path);
                    }
                } else if (action.equalsIgnoreCase("update")) {
                    UpdateNews(request);
                    GetAllNews(response, session);
                } else if (action.equalsIgnoreCase("delete")) {
                    DeleteNews(request);
                    GetAllNews(response, session);
                }
            }

        } finally {
            out.close();
        }
    }

    public void DeleteNews(HttpServletRequest request) throws Exception {
        int Id = Integer.parseInt(request.getParameter("Id"));
        ClsBONews BON = new ClsBONews();
        BON.DeleteNews(Id);
    }

    private void UpdateNews(HttpServletRequest request) throws Exception {
        int Id = Integer.parseInt(request.getParameter("Id"));
        ClsBONews BON = new ClsBONews();
        BON.UpdateNewsStatus(Id);
    }

   private void GetAllNews(HttpServletResponse response, HttpSession session) throws Exception {
        ClsBONews BON = new ClsBONews();
        ArrayList<ClsNews> List = BON.GetAllNews();
        session.setAttribute("news", List);
        String path = "./jsps/jspQuanLyTinTuc.jsp";
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
            Logger.getLogger(ServNews.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServNews.class.getName()).log(Level.SEVERE, null, ex);
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
