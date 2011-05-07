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
import system.bo.clsBOClass;
import system.bo.clsBOLecturer;
import system.bo.clsBORegistration;
import system.bo.clsBOStudent;
import system.bo.clsBOSubject;
import system.dto.clsClass;
import system.dto.clsStudent;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="ViewClassDetail", urlPatterns={"/ViewClassDetail"})
public class ViewClassDetail extends HttpServlet {
   
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        String classId = (String) req.getParameter("id");        
        HttpSession session = req.getSession();
        PrepareDataForView(req, resp, session, classId);


        String path = "./jsps/jspChiTietLopHoc.jsp";
        resp.sendRedirect(path);
    }

    private void PrepareDataForView(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String classId){
        ArrayList<String> classInfomation = new ArrayList<String>();
        ArrayList<String> studentInfomation = new ArrayList<String>();
        //className, TenMonHoc, MaGV, TenGV, SoLuongSV
        int i,j,n,m;
        try {
            clsBOClass classBo = new clsBOClass();
            clsBOLecturer lecturerBo = new clsBOLecturer();
            clsBOSubject subjectBo = new clsBOSubject();
            clsBOStudent studentBo = new clsBOStudent();
            clsBORegistration registryBo = new clsBORegistration();

            //Get class infomation
            clsClass Class = classBo.getClassinfo(classId);
            String className = Class.getClassName();
            classInfomation.add(className);
            String subCode = Class.getSubCode();
            String subName = subjectBo.getSubjectNameByCode(subCode);
            classInfomation.add(subName);
            String MaGV = Class.getLectureCode();
            classInfomation.add(MaGV);
            String TenGv = lecturerBo.LecturerGetLecturerNameFromId(MaGV);
            classInfomation.add(TenGv);
            int SLSV = Class.getNumOfStudent();
            classInfomation.add(Integer.toString(SLSV));

            //Get list of student in that class
            //MSSV, HotenSV, Khoa, TGDK
            ArrayList<String> studentCode = new ArrayList<String>();
            studentCode = registryBo.getListStudentIdFromClassName(classId);
            n = studentCode.size();
            for(i = 0; i < n; i++){
                String idtemp = studentCode.get(i);
                studentInfomation.add(idtemp);

                clsStudent studentTemp = studentBo.getStudentInfoByCode(idtemp);
                studentInfomation.add(studentTemp.getFullname());
                studentInfomation.add(Integer.toString(studentTemp.getCourse()));
                studentInfomation.add("unknown");
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewListClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("classinfomation", classInfomation);
        session.setAttribute("studentinfomation", studentInfomation);
    }
}
