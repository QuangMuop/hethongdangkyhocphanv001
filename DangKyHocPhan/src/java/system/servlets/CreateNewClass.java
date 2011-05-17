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
import system.bo.clsBOSubject;
import system.dto.clsClass;
import system.dto.clsLecturer;
import system.dto.clsSubject;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="CreateNewClass", urlPatterns={"/CreateNewClass"})
public class CreateNewClass extends HttpServlet {
   
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        super.service(req, resp);

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // Function is load data or registry data
        String function = (String)req.getParameter("function");
        String path = "./jsps/jspTaoLopHoc.jsp";
        String result = "";
        if(function != null){
            if(function.equals("loaddata")){
                LoadData(session);
            }else if(function.equals("registry")){
                 result = Registry(req, resp);
                 session.setAttribute("mes", result);
                 path = "./jsps/jspThongBao.jsp";
            }
        }
        resp.sendRedirect(path);
    }

    private void LoadData(HttpSession session){
        //Ten mon hoc, Giang vien, so tin chi li thuyet, so tin chi thuc hanh
        clsBOSubject subjectBo = new clsBOSubject();
        clsBOLecturer lecturerBo = new clsBOLecturer();
        clsBOClass classBo = new clsBOClass();
        ArrayList<clsSubject> subjects = new ArrayList<clsSubject>();
        ArrayList<clsLecturer> lecturers = new ArrayList<clsLecturer>();
        ArrayList<clsClass> classs = new ArrayList<clsClass>();

        try {
            subjects = subjectBo.GetListSubject();
            lecturers = lecturerBo.GetAllLecturer();
            classs = classBo.GetAllClass("ClassName");
        } catch (Exception ex) {
            Logger.getLogger(CreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        //A list hold list lecturer name
        ArrayList<String> lecturerNames = new ArrayList<String>();
        int n = lecturers.size();
        for(int i = 0; i < n; i++){
            lecturerNames.add(lecturers.get(i).getFullname());
        }


        //A list hold subject infomation by fomat:
        // Subject name - TCLT - TCTH
        ArrayList<String> subjectsInfo = new ArrayList<String>();
        n = subjects.size();
        for(int j = 0; j < n; j++){
            subjectsInfo.add(subjects.get(j).getSubName());            
        }

        //Mã	Tên Lớp	Giảng Viên	Số TC LT	Số TC TH	Phòng	Thứ	Ca
        ArrayList<String> classExited = new ArrayList<String>();
        n = classs.size();
        for(int i = 0; i < n; i++){
            classExited.add(classs.get(i).getClassName());

            String subCode = classs.get(i).getSubCode();
            clsSubject subTemp = new clsSubject();
            try {
                subTemp = subjectBo.getSubjectinfoByCode(subCode);
            } catch (Exception ex) {
                Logger.getLogger(CreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            classExited.add(subTemp.getSubName());

            String lecturerCode = classs.get(i).getLectureCode();
            clsLecturer lecturerTemp = new clsLecturer();
            try {
                lecturerTemp = lecturerBo.getLecturereByCode(lecturerCode);
            } catch (Exception ex) {
                Logger.getLogger(CreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            classExited.add(lecturerTemp.getFullname());

            classExited.add(Integer.toString(subTemp.getTCLT()));
            classExited.add(Integer.toString(subTemp.getTCTH()));
            classExited.add(classs.get(i).getRoom());
            classExited.add(classs.get(i).getDate());
            classExited.add((classs.get(i).getShift()==1)? "Sáng" : "Chiều");
        }

        session.setAttribute("lecturernames", lecturerNames);
        session.setAttribute("subjectinfo", subjectsInfo);
        session.setAttribute("classexisted", classExited);
    }

    /**
     * Process registry task
     * @param req
     * @param resp
     * @return descript result
     */
    private String Registry(HttpServletRequest req, HttpServletResponse resp){
        String error = "";
        String ClassName = "", subCode = "", lecturerCode = "";
        String dateOfWeek = "", Room = "", NumOfStudent = "", Time = "";
        String TestDate = "", TestTime = "", TestRoom = "";
        String tclt = "", tcth = "";
        int soTC = 0;
        clsBOClass classBo = new clsBOClass();
        clsBOSubject subjectBo = new clsBOSubject();
        clsBOLecturer lecturerBo = new clsBOLecturer();

        ClassName = (String) req.getParameter("txtClassId");
        dateOfWeek = (String) req.getParameter("sDay");
        Room = (String) req.getParameter("txtRoom");
        NumOfStudent = (String) req.getParameter("txtSLSV");
        Time = (String) req.getParameter("sTime");
        
        tclt = (String) req.getParameter("txtSoTCLT");
        tcth = (String) req.getParameter("txtSoTCTH");

        if(Time.charAt(0) == 'S')
            Time = "1";
        else
            Time = "2";

        String subName = (String) req.getParameter("sClassName");
        String lecturerName = (String) req.getParameter("sLecturerName");

        error = "OK";
        if(CheckClassIdExisted(ClassName) == true){
            error = "Lớp đã tồn tại </br>";
        }
        if(CheckLecturerVsDate(lecturerName, dateOfWeek, Integer.parseInt(Time))){
            error+= "Giảng viên " + lecturerName + " đã có lớp vào ngày thứ " + dateOfWeek +
                    " buổi " + (Time.equals("1") ? "Sáng" : "Chiều" + "/br");
        }
        if(CheckRoomVsDate(Room, dateOfWeek, Integer.parseInt(Time))){
            error += "Phòng " + Room + " đã có lớp học vào ngày "+ dateOfWeek + ", buổi " +
                    (Time.equals("1") ? "Sáng" : "Chiều") + "/br";
        }

        if(error.equals("OK") == false){
            return error;
        }

        try {            
            clsSubject sub = subjectBo.getSubjectinfoByName(subName);
            subCode = sub.getSubCode();
            clsLecturer lecturer = new clsLecturer();
            lecturer = lecturerBo.getLecturerInfo(lecturerName);
            lecturerCode = lecturer.getLecturerCode();
            
            soTC = Integer.parseInt(tcth) + Integer.parseInt(tclt);


            clsClass classDto = new clsClass(ClassName, subCode, subName, lecturerCode,
                                            dateOfWeek, Room, Integer.parseInt(Time),
                                            Integer.parseInt(NumOfStudent), TestDate,
                                            TestTime, TestRoom, lecturerName, soTC);
            classBo.ClassInsert(classDto);

            error = "Thêm thành công";
        } catch (Exception ex) {
            Logger.getLogger(CreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
            error = ex.toString();
        }
        //ssname, String subcode,String subname, String lecturercode, String date, 
        //String room, int shift, int numofstudent, String testdate, String testtime, 
        //String testroom, String lecturername, int numtc){

        return error;
    }

    /**
     * Check if the leckturer is busy at the time
     * @param lecturerName Lecturer's name for test
     * @param Date date for test
     * @param shift Shift for test
     * @return true if that lecturer already have another class at this time
     */
    private boolean CheckLecturerVsDate(String lecturerName, String Date, int shift){
        clsBOClass classBo = new clsBOClass();
        ArrayList<clsClass> classList = new ArrayList<clsClass>();
        try {
            clsBOLecturer lecturerBo = new clsBOLecturer();
            clsLecturer lecturer = lecturerBo.getLecturerInfo(lecturerName);
            String lecturerCode = lecturer.getLecturerCode();

            classList = classBo.GetAllClass("ClassName");
            int n = classList.size();
            for(int i = 0; i < n; i++){
                clsClass classTemp = classList.get(i);
                if((classTemp.getLectureCode().equalsIgnoreCase(lecturerCode))&&
                        (classTemp.getDate().equalsIgnoreCase(Date)) &&
                        (classTemp.getShift() == shift)){
                    return true;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * CHeck if a room have already a class at specify time
     * @param Room Room for check
     * @param Date Day for check
     * @param shift shift for check
     * @return true if the room is busy.
     */
    private boolean CheckRoomVsDate(String Room, String Date, int shift){
        clsBOClass classBo = new clsBOClass();
        ArrayList<clsClass> classList = new ArrayList<clsClass>();
        try {
            classList = classBo.GetAllClass("ClassName");
            int n = classList.size();
            for(int i = 0; i < n; i++){
                clsClass classTemp = classList.get(i);
                if(classTemp.getRoom().equalsIgnoreCase(Room) &&
                        (classTemp.getDate().equalsIgnoreCase(Date)) &&
                        (classTemp.getShift() == shift)){
                    return true;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * CHeck if class's id already existed in database.
     * @param className name of class for check
     * @return true if className already existed in database.
     */
    private boolean CheckClassIdExisted(String className){
        clsBOClass classBo = new clsBOClass();
        try {
            return classBo.ClassCheckExits(className);
        } catch (Exception ex) {
            Logger.getLogger(CreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
