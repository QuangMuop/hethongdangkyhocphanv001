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
        HttpSession session = req.getSession();

        String isSearchEngine = (String) req.getParameter("searchengine");

        SetDataForSearchEngine(req, resp, session);

        if(isSearchEngine.equalsIgnoreCase("true")){
            SetDataWithSearchEngine(req, resp, session);
        }else if(isSearchEngine.equalsIgnoreCase("false")){
            SetDataWithoutSearchEngine(req, resp, session);           
        }

        String path = "./jsps/jspXemDSLop.jsp";        
        resp.sendRedirect(path);
    }

    /**
     *Get search title: lecturer's name and subject's name
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void SetDataForSearchEngine(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
            throws ServletException, IOException {
        ArrayList<String> listLectureName = new ArrayList<String>();
        ArrayList<String> listSubjectName = new ArrayList<String>();

        int i,j,n,m;
        try {
            clsBOClass classBo = new clsBOClass();
            clsBOLecturer lecturerBo = new clsBOLecturer();
            clsBOSubject subjectBo = new clsBOSubject();

            ArrayList<clsClass> listClass = classBo.GetAllClass("ClassName");
            n = listClass.size();
            for(i = 0; i < n; i++){
                String subjectId = listClass.get(i).getSubCode();
                String subjectName = subjectBo.getSubjectNameByCode(subjectId);
                listSubjectName.add(subjectName);

                String lectureId = listClass.get(i).getLectureCode();
                String lectureName = lecturerBo.LecturerGetLecturerNameFromId(lectureId);
                listLectureName.add(lectureName);
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewListClass.class.getName()).log(Level.SEVERE, null, ex);
        }               
        session.setAttribute("listsubjectnamefull", listSubjectName);
        session.setAttribute("listlecturernamefull", listLectureName);
    }

    /**
     * Get data from datbase, put all into sesstion. Do without search selection
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void SetDataWithoutSearchEngine(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
            throws ServletException, IOException {
        ArrayList<clsClass> listClass = new ArrayList<clsClass>();
        ArrayList<clsSubject> listSubject = new ArrayList<clsSubject>();
        ArrayList<String> listLecturerName = new ArrayList<String>();
        
        int i,j,n,m;

        try {
            clsBOClass classBo = new clsBOClass();
            clsBOLecturer lecturerBo = new clsBOLecturer();
            clsBOSubject subjectBo = new clsBOSubject();

            listClass = classBo.GetAllClass("ClassName");
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
      
        session.setAttribute("listclass", listClass);
        session.setAttribute("listsubject", listSubject);
        session.setAttribute("listlecturername", listLecturerName);        
    }

    /**NOT YET
     *Get data from datbase, put all into sesstion. Do without search selection
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void SetDataWithSearchEngine(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
            throws ServletException, IOException {
        ArrayList<clsClass> listClass = new ArrayList<clsClass>();
        ArrayList<clsSubject> listSubject = new ArrayList<clsSubject>();
        ArrayList<String> listLecturerName = new ArrayList<String>();

        int i,j,n,m;

        try {
            clsBOClass classBo = new clsBOClass();
            clsBOLecturer lecturerBo = new clsBOLecturer();
            clsBOSubject subjectBo = new clsBOSubject();

            listClass = classBo.GetAllClass("");
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

        session.setAttribute("listclass", listClass);
        session.setAttribute("listsubject", listSubject);
        session.setAttribute("listlecturername", listLecturerName);
    }
}
