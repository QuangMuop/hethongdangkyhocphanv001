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
import system.bo.clsBORule;
import system.bo.clsBOStudent;
import system.bo.clsBOSubject;
import system.dto.clsClass;
import system.dto.clsRegistration;
import system.dto.clsStudent;
import system.utilities.SystemProperities;

@WebServlet(name = "servRegistration", urlPatterns = {"/servRegistration"})
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
        clsBOAccount BOA = new clsBOAccount();
        try {
            String login = (String) session.getAttribute("username");
            if (login == null) {
                session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
                String path = "./jsps/jspThongBao.jsp";
                response.sendRedirect(path);
            } else {
                String first = request.getParameter("reg");
                if (first.equalsIgnoreCase("view")) {
                    if (BOA.getAccountType(login) == 0) {
                        forward(response, session, login);
                    } else {
                        session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập với tài khoản sinh viên!");
                        String path = "./jsps/jspThongBao.jsp";
                        response.sendRedirect(path);
                    }
                } else if (first.equalsIgnoreCase("registry")) {
                    registry(request, response, session, login);
                } else if (first.equalsIgnoreCase("reset")) {
                    getAllClass(response, session, login);
                } else if (first.equalsIgnoreCase("complete")) {
                    completeReg(login, response, session);
                }
            }


        } finally {
            out.close();
        }
    }

    /**
     * 
     * @param resp
     * @param session
     * @param login
     * @throws Exception 
     */
    private void forward(HttpServletResponse resp, HttpSession session, String login) throws Exception {
        clsRegistration cls = new clsRegistration(login, "", SystemProperities.Curentsemester, SystemProperities.CurentYear, 0);
        clsBORegistration BOreg = new clsBORegistration();
        ArrayList<String> reged = BOreg.getRegistrationInfo(cls);
        if (reged.isEmpty()) {
            getAllClass(resp, session, login);
        } else {
            showreg(reged, resp, session, login);
        }
    }

    /**
     * 
     * @param username
     * @throws Exception
     */
    private void completeReg(String username, HttpServletResponse resp, HttpSession session) throws Exception {
        clsBOSubject BOS = new clsBOSubject();
        clsBORule BOL = new clsBORule();
        String[] registry = (String[]) session.getAttribute("regitry");
        int n = registry.length;
        String[] classList = new String[n];
        int numTC = 0;
        for (int i = 0; i < n; i++) {
            numTC += BOS.getNumTCByClassName(registry[i]);
        }
        if (numTC < BOL.getRuleInfo().getMinTC()) {
            session.setAttribute("mes", "Số tín chỉ chưa đủ, số TC tối thiểu cho một học kỳ là :" + BOL.getRuleInfo().getMinTC() + ". Số TC bạn đăng ký là " + numTC);
            String path = "./jsps/jspThongBao.jsp";
            resp.sendRedirect(path);
        } else if (numTC > BOL.getRuleInfo().getMaxTC()) {
            session.setAttribute("mes", "Số tín chỉ quá qui định, số TC tối đa cho một học kỳ là :" + BOL.getRuleInfo().getMaxTC() + ". Số TC bạn đăng ký là " + numTC);
            String path = "./jsps/jspThongBao.jsp";
            resp.sendRedirect(path);
        } else {
            clsBORegistration BOReg = new clsBORegistration();
            BOReg.deleteAll(username, SystemProperities.Curentsemester, SystemProperities.CurentYear);

            for (int i = 0; i < n; i++) {
                clsRegistration temp = new clsRegistration(username, registry[i], SystemProperities.Curentsemester, SystemProperities.CurentYear, 0);
                //BOReg.insert(temp);
                String message = BOReg.insertCheck(temp);
                classList[i] = message;
            }
            int num = 0;
            for (int i = 0; i < n; i++) {
                if (classList[i].equalsIgnoreCase("OK") == false) {
                    num++;
                }
            }
            if (num == 0) {
                session.setAttribute("mes", "Đăng ký thành công!");
                String path = "./jsps/jspThongBao.jsp";
                resp.sendRedirect(path);
            } else {
                StringBuffer mes = new StringBuffer();
                mes.append("Đăng ký các lớp học: ");
                for (int i = 0; i < n; i++) {
                    if (classList[i].equalsIgnoreCase("OK") == false) {
                        mes.append(classList[i] + ", ");
                    }
                }
                mes.append("không thành công do bạn chưa học qua các môn học tiên quyết của các môn học này, hoặc số lượng sinh viên của lớp đã đủ so với quy định.");
                mes.append(" Hãy qua trang xem chi tiết các môn học tiên quyết để biết chi tiết. Các lớp học khác đăng ký thành công.");
                session.setAttribute("mes", mes.toString());
                String path = "./jsps/jspThongBao.jsp";
                resp.sendRedirect(path);
            }
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @param session
     * @throws IOException
     * @throws Exception
     */
    private void registry(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String login) throws IOException, Exception {
        String[] registry = req.getParameterValues("check");
        if (req.getParameterValues("check") == null) {
            getAllClass(resp, session, login);
        } else {
            int n = registry.length;
            ArrayList<clsClass> reg = new ArrayList<clsClass>();
            clsClass temp = new clsClass();
            clsBOClass BOC = new clsBOClass();
            for (int i = 0; i < n; i++) {
                temp = BOC.getClassFromId(registry[i]);
                reg.add(temp);
            }
            session.setAttribute("reg", reg);
            session.setAttribute("regitry", registry);
            String path = "./jsps/jspPreviewRegistry.jsp";
            resp.sendRedirect(path);
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @param session
     * @throws IOException
     * @throws Exception
     */
    private void getAllClass(HttpServletResponse resp, HttpSession session, String login) throws IOException, Exception {
        clsBOStudent BOStudent = new clsBOStudent();
        clsStudent student = BOStudent.getStudentInfoByCode(login);
        session.setAttribute("student", student);
        session.setAttribute("time", "Học kỳ " + SystemProperities.Curentsemester + " năm học " + SystemProperities.CurentYear);
        clsBOClass BOClass = new clsBOClass();
        ArrayList<clsClass> result = BOClass.GetAllClass("ClassName");
        session.setAttribute("clases", result);
        String path = "./jsps/jspDangKyMonHoc.jsp";
        resp.sendRedirect(path);
    }

    /**
     * 
     * @param reged
     * @param resp
     * @param session
     * @param login
     * @throws IOException
     * @throws Exception 
     */
    private void showreg(ArrayList<String> reged, HttpServletResponse resp, HttpSession session, String login) throws IOException, Exception {
        clsBOStudent BOStudent = new clsBOStudent();
        clsStudent student = BOStudent.getStudentInfoByCode(login);
        session.setAttribute("student", student);
        session.setAttribute("time", "Học kỳ " + SystemProperities.Curentsemester + " năm học " + SystemProperities.CurentYear);
        int n = reged.size();
        String[] registry = new String[n];
        ArrayList<clsClass> reg = new ArrayList<clsClass>();
        clsClass temp = new clsClass();
        clsBOClass BOC = new clsBOClass();
        for (int i = 0; i < n; i++) {
            temp = BOC.getClassFromId(reged.get(i));
            reg.add(temp);
            registry[i] = reged.get(i);

        }
        session.setAttribute("reg", reg);
        session.setAttribute("regitry", registry);
        String path = "./jsps/jspPreviewRegistry.jsp";
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
