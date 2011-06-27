package system.servlets;

import java.io.IOException;
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
import system.bo.clsBOLecturer;
import system.bo.clsBOSubject;
import system.dto.clsClass;
import system.utilities.SystemProperities;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name = "ViewSchedule", urlPatterns = {"/ViewSchedule"})
public class ViewSchedule extends HttpServlet {

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
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        try {
            ViewSchedule(session, resp);
        } catch (Exception ex) {
            Logger.getLogger(ViewSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ViewSchedule(HttpSession session, HttpServletResponse resp) throws Exception {
        clsBOClass BOC = new clsBOClass();
        ArrayList<clsClass> listclass = BOC.GetAllClass("DateOfWeek");
        session.setAttribute("list", listclass);
        session.setAttribute("time", "Thời khóa biểu học kỳ " + SystemProperities.Curentsemester + " năm học " + SystemProperities.CurentYear);
        String path = "./jsps/jspXemTKB.jsp";
        resp.sendRedirect(path);
    }
}
