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
import system.bo.clsBORegistration;
import system.bo.clsBOStudent;
import system.dto.clsClass;
import system.dto.clsRegistration;
import system.utilities.SystemProperities;

@WebServlet(name = "ServScore", urlPatterns = {"/ServScore"})
public class ServScore extends HttpServlet {

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
            // if(user==null){
            ////    session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
            //    String path = "./jsps/jspThongBao.jsp";
            //   response.sendRedirect(path);
            // }else{
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("view")) {
                if (BOA.getAccountType(user) == 0) {
                    getAllClass(response, session);
                } else {
                    session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập bằng tài sinh viên!");
                    String path = "./jsps/jspThongBao.jsp";
                    response.sendRedirect(path);
                }

            } else if (action.equalsIgnoreCase("reload")) {
                if (BOA.getAccountType(user) == 0) {
                    reLoadScoreTable(request, response);
                } else {
                    session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập bằng tài sinh viên!");
                    String path = "./jsps/jspThongBao.jsp";
                    response.sendRedirect(path);
                }

            }
            // }

        } finally {
            out.close();
        }
    }

    private void reLoadScoreTable(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
        clsBOStudent BOS = new clsBOStudent();
        PrintWriter out = response.getWriter();
        String ClassName = request.getParameter("classname");
        clsBORegistration BOR = new clsBORegistration();
        ArrayList<clsRegistration> list = BOR.getRegistrationByClassName(ClassName);
        if (list.isEmpty()) {
            out.println("Không có sinh viên học lớp này");
        } else if (list.get(0).getMark() == 11) {
            out.println("Chưa có điểm môn này");
        } else {
            out.println("<tr><th>STT</th><th>Họ Tên</th><th>MSSV</th><th>Điểm</th></tr>");
            for (int i = 0; i < list.size(); i++) {
                StringBuffer temp = new StringBuffer();
                temp.append("<tr><td>").append(i + 1).append("</td>");
                temp.append("<td>").append(BOS.getStudentInfoByCode(list.get(i).getStudentCode()).getFullname()).append("</td>");
                temp.append("<td>").append(list.get(i).getStudentCode()).append("</td>");
                if (list.get(i).getMark() == 11) {
                    temp.append("<td></td></tr>");
                } else {
                    temp.append("<td>").append(list.get(i).getMark()).append("</td></tr>");
                }
                out.println(temp.toString());
            }
        }
    }

    private void getAllClass(HttpServletResponse response, HttpSession session) throws Exception {
        session.setAttribute("time", "Học kỳ " + SystemProperities.Curentsemester + " năm học " + SystemProperities.CurentYear);
        clsBOClass BOClass = new clsBOClass();
        ArrayList<clsClass> result = BOClass.GetAllClass("ClassName");
        session.setAttribute("clases", result);
        String path = "./jsps/jspDiemCuoiKy.jsp";
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
            Logger.getLogger(ServScore.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServScore.class.getName()).log(Level.SEVERE, null, ex);
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
