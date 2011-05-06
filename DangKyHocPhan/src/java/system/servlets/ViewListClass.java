package system.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.access.mapper.clsMapperClass;
import system.access.mapper.clsMapperLecturer;
import system.bo.clsBOClass;
import system.bo.clsBOLecturer;
import system.bo.clsBOSubject;
import system.dto.clsClass;
import system.dto.clsSubject;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="ViewListClass", urlPatterns={"/ViewListClass"})
public class ViewListClass extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {                        
        String isSearchEngine = (String) req.getParameter("searchengine");
        if(isSearchEngine.equalsIgnoreCase("true")){
            SetDataWithSearchEngine(req, resp);
        }else if(isSearchEngine.equalsIgnoreCase("false")){
            SetDataWithoutSearchEngine(req, resp);
           
        }
    }

    private void SetDataWithoutSearchEngine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        ArrayList<clsClass> listClass = new ArrayList<clsClass>();
        ArrayList<clsSubject> listSubject = new ArrayList<clsSubject>();
        ArrayList<String> listLecturerName = new ArrayList<String>();
        
        int i,j,n,m;

        try {
            clsBOClass classBo = new clsBOClass();
            clsBOLecturer lecturerBo = new clsBOLecturer();
            clsBOSubject subjectBo = new clsBOSubject();

            listClass = classBo.GetAllClass();
            n = listClass.size();
            for(i = 0; i < n; i++){
                String subjectId = listClass.get(i).getSubCode();
                clsSubject subjectTemp = subjectBo.getSubjectinfoByCode(subjectId);
                listSubject.add(subjectTemp);

                String lectureCode = listClass.get(i).getLectureCode();
                String lectureName = lecturerBo.LecturerGetLecturerNameFromId(lectureCode);
                listLecturerName.add(lectureName);
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewListClass.class.getName()).log(Level.SEVERE, null, ex);
        }


        session.setAttribute("a", "toi khong hieu tai sao lainhu vay/...");
        session.setAttribute("listclass", listClass);
        session.setAttribute("listsubject", listSubject);
        session.setAttribute("listlecturername", listLecturerName);

        String path = "./jsps/jspXemDSLop.jsp";
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        //requestDispatcher.forward(req, resp);
        resp.sendRedirect(path);
    }

    private void SetDataWithSearchEngine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Co search");
    }
}
