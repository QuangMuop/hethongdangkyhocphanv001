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
import system.access.mapper.ClsPro;
import system.bo.clsBOAccount;
import system.bo.clsBOCourse;
import system.bo.clsBOProgram;
import system.bo.clsBOSubject;
import system.dto.clsCourse;
import system.dto.clsProgram;
import system.dto.clsSubject;

@WebServlet(name = "servProManage", urlPatterns = {"/servProManage"})
public class servProManage extends HttpServlet {

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
                        getProgram(response, session);
                    } else {
                        session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập với tài khoản quản lý!");
                        String path = "./jsps/jspThongBao.jsp";
                        response.sendRedirect(path);
                    }
                } else if (action.equalsIgnoreCase("reload")) {
                    ReloadPro(request, response);
                } else if (action.equalsIgnoreCase("create")) {
                    createPro(response, session);
                } else if (action.equalsIgnoreCase("preview")) {
                    previewPro(request, response, session);
                } else if (action.equalsIgnoreCase("reset")) {
                    createPro(response, session);
                } else if (action.equalsIgnoreCase("complete")) {
                    createNewPro(response, session);
                } else if (action.equalsIgnoreCase("addsub")) {
                    addsub(request, response, session);

                } else if (action.equalsIgnoreCase("delsub")) {
                    delsub(request, response, session);
                } else if (action.equalsIgnoreCase("delete")) {
                    deletePro(request, response, session);
                } else if (action.equalsIgnoreCase("insert")) {
                    insertPro(request, response, session);
                }
            }

        } finally {
            out.close();
        }
    }

    private void deletePro(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int prodoe = Integer.parseInt(request.getParameter("code"));
        String subcode = request.getParameter("sub");
        clsProgram cls = new clsProgram(prodoe, subcode, 1, "");
        clsBOProgram BOP = new clsBOProgram();
        BOP.DeletePro(cls);
        getProgram(response, session);
    }

    private void insertPro(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int prodoe = Integer.parseInt(request.getParameter("code"));
        String subcode = request.getParameter("sub");
        int semester = Integer.parseInt(request.getParameter("semester"));
        clsProgram cls = new clsProgram(prodoe, subcode, semester, "");
        clsBOProgram BOP = new clsBOProgram();
        BOP.InsertPro(cls);
        getProgram(response, session);
    }

    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void addsub(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int procode = Integer.parseInt(request.getParameter("procode"));
        clsBOSubject BOS = new clsBOSubject();
        ArrayList<clsSubject> sublist = BOS.GetSubjectFree(procode);
        session.setAttribute("sublist", sublist);
        session.setAttribute("code", procode);
        String path = "./jsps/jspThemMonHocVaoCT.jsp";
        response.sendRedirect(path);
    }

    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void delsub(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int procode = Integer.parseInt(request.getParameter("codepro"));
        clsBOProgram BOP = new clsBOProgram();
        ArrayList<clsProgram> pro = BOP.getAllProByCode(procode);
        session.setAttribute("pro", pro);
        String path = "./jsps/jspXoaMonHocKhoiCt.jsp";
        response.sendRedirect(path);
    }

    /**
     *
     * @param response
     * @param session
     * @throws Exception
     */
    private void createNewPro(HttpServletResponse response, HttpSession session) throws Exception {
        ArrayList<clsProgram> prolist = (ArrayList<clsProgram>) session.getAttribute("prolist");
        clsBOProgram BOP = new clsBOProgram();
        ClsPro cls = new ClsPro();
        cls.ProInsert(prolist.get(0).getProgramCode());
        for (int i = 0; i < prolist.size(); i++) {
            BOP.InsertPro(prolist.get(i));
        }
        session.setAttribute("mes", "Tạo chương trình thành công, quay về trang chương trình đào tạo để biết chhi tiết!");
        String path = "./jsps/jspThongBao.jsp";
        response.sendRedirect(path);
    }

    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void previewPro(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        ArrayList<Integer> procode = (ArrayList<Integer>) session.getAttribute("procode");
        int newprocode = procode.size() + 1;
        if (request.getParameterValues("check") == null) {
            createPro(response, session);
        } else {
            String[] prosubcode = request.getParameterValues("check");
            ArrayList<clsProgram> prolist = new ArrayList<clsProgram>();
            clsBOSubject BOS = new clsBOSubject();
            for (int i = 0; i < prosubcode.length; i++) {
                String subname = BOS.getSubjectNameByCode(prosubcode[i]);
                clsProgram temp = new clsProgram(newprocode, prosubcode[i], Integer.parseInt(request.getParameter(prosubcode[i])), subname);
                prolist.add(temp);
            }
            session.setAttribute("prolist", prolist);
            String path = "./jsps/jspXemTruocCTDT.jsp";
            response.sendRedirect(path);
        }
    }

    /**
     *
     * @param response
     * @param session
     * @throws Exception
     */
    private void createPro(HttpServletResponse response, HttpSession session) throws Exception {
        clsBOSubject BOS = new clsBOSubject();
        ArrayList<clsSubject> sublist = BOS.GetListSubject();
        session.setAttribute("sub", sublist);
        clsBOProgram BOP = new clsBOProgram();
        ArrayList<Integer> procode = BOP.getAllProCode();
        session.setAttribute("procode", procode);
        String path = "./jsps/jspTaoCTDT.jsp";
        response.sendRedirect(path);
    }

    /**
     *
     * @param request
     * @param response
     * @throws Exception
     */
    private void ReloadPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int procode = Integer.parseInt(request.getParameter("procode"));
        clsBOProgram BOP = new clsBOProgram();
        ArrayList<clsProgram> pro = BOP.getAllProByCode(procode);
        response.getWriter().println("<tr><th>STT</th><th>Mã CT</th><th>Mã môn học</th><th >Tên môn học</th><th>Học kỳ</th></tr>");
        for (int i = 0; i < pro.size(); i++) {
            response.getWriter().println("<tr><td>" + (i + 1) + "</td><td>" + pro.get(i).getProgramCode() + "</td><td>" + pro.get(i).getSubjectCode() + "</td><td>" + pro.get(i).getSubName() + "</td><td>" + pro.get(i).getSemester() + "</td></tr>");
        }
    }

    /**
     *
     * @param response
     * @param session
     * @throws Exception
     */
    private void getProgram(HttpServletResponse response, HttpSession session) throws Exception {
        clsBOProgram BOP = new clsBOProgram();
        ArrayList<Integer> procode = BOP.getAllProCode();
        session.setAttribute("procode", procode);
        ArrayList<clsProgram> prolist = BOP.getAllProByCode(1);
        session.setAttribute("pro", prolist);
        String path = "./jsps/jspQuanLyCTDT.jsp";
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
            Logger.getLogger(servProManage.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servProManage.class.getName()).log(Level.SEVERE, null, ex);
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
