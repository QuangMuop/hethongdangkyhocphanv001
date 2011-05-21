package system.servlets;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="ViewSchedule", urlPatterns={"/ViewSchedule"})
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
        SetDataForView(session);

        String path = "./jsps/jspXemTKB.jsp";
        resp.sendRedirect(path);
    }

    private void SetDataForView(HttpSession session){
        //Thu 2, clasname, sub name, phong, ca, giang vien
        ArrayList<String> listData = new ArrayList<String>();
        int i,j,n,m;
        try {
            clsBOClass classBo = new clsBOClass();
            clsBOLecturer lecturerBo = new clsBOLecturer();
            clsBOSubject subjectBo = new clsBOSubject();

            //Get class infomation
            String strOrderBy = "DateOfWeek";
            ArrayList<clsClass> Class = classBo.GetAllClass(strOrderBy);
            n = Class.size();
            for(i = 0; i < n; i++){
                listData.add(Class.get(i).getDate());
                listData.add(Class.get(i).getClassName());
                String subCode = Class.get(i).getSubCode();
                String subName = subjectBo.getSubjectNameByCode(subCode);
                listData.add(subName);
                listData.add(Class.get(i).getRoom());
                listData.add(Integer.toString(Class.get(i).getShift()));
                String lecturerCode = Class.get(i).getLectureCode();
                String lectureName = lecturerBo.LecturerGetLecturerNameFromId(lecturerCode);
                listData.add(lectureName);
            }            
        } catch (Exception ex) {
           
        }
        session.setAttribute("listdata", listData);
    }

}
