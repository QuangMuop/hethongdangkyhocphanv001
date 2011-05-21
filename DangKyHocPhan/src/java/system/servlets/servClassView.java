
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
import system.dto.clsStudent;
import system.dto.clsSubject;
import system.utilities.SystemProperities;

@WebServlet(name="servClassView", urlPatterns={"/servClassView"})
public class servClassView extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
         String action =request.getParameter("action");
        try {
            if(action.equalsIgnoreCase("view")){
             getAllClass(response, session);
            }
            else if(action.equalsIgnoreCase("detail")){
               ClassDetail(request, response, session);
            }
            else if(action.equalsIgnoreCase("delete")){
                getClassInfo(request, response, session);
            }
            else if(action.equalsIgnoreCase("deletecom")){
               deleteClass(request, response, session);
               
            }else if(action.equalsIgnoreCase("edit")){
                editClass(request, response, session);
            }
            else if(action.equalsIgnoreCase("student")){
                getAllClassSV(response, session);
            } else if(action.equalsIgnoreCase("update")){
                updateClass(request);
                getAllClass(response, session);
            }else if(action.equalsIgnoreCase("create")){
                createClass(request, response, session);
            }else if(action.equalsIgnoreCase("createcomplete")){
                insertClass(request, response, session);
            }
            else if(action.equalsIgnoreCase("search")){
                searchClass(request, response);
            }
        } finally { 
            out.close();
        }
    }
    /**
     *
     * @param request
     * @param response
     * @throws Exception
     */
    private void searchClass(HttpServletRequest request,HttpServletResponse response) throws Exception{
         PrintWriter out = response.getWriter();
        String type=request.getParameter("type");
        String name=request.getParameter("name");
        clsBOClass BOC=new clsBOClass();
        ArrayList<clsClass> classlist=new ArrayList<clsClass>();
        if(type.equalsIgnoreCase("subname")){
            classlist=BOC.GetAllClassBySub(name);
        }
        else if(type.equalsIgnoreCase("lecturer")) {
            classlist=BOC.GetAllClassByLecturer(name);
        }
        else{
            classlist=BOC.GetAllClass("ClassName");
        }
        if(request.getParameter("actor").equalsIgnoreCase("Admin")){
        out.println("<tr><th>STT</th><th>Mã lớp</th><th>Môn học</th><th>Giảng Viên</th><th>Số TC</th><th>Ngày</th><th>Phòng</th><th>Ca</th><th>Sửa</th><th>Xóa</th></tr>");
        for(int i=0;i<classlist.size();i++){
         out.println("<tr><td>"+(i+1)+"</td><td><a href='../servClassView?action=detail&classname="+classlist.get(i).getClassName()+"'>"+classlist.get(i).getClassName()+"</a></td><td>"+classlist.get(i).getSubName()+"</td><td>"+classlist.get(i).getLecturerName()+"</td><td>"+classlist.get(i).getNumTC()+"</td><td>Thứ " +classlist.get(i).getDate()+"</td><td>"+classlist.get(i).getRoom()+"</td><td>"+classlist.get(i).getShift()+"</td><td><a href='../servClassView?action=edit&classname="+classlist.get(i).getClassName()+"'>Sửa</a></td><td><a href='../servClassView?action=delete&classname="+classlist.get(i).getClassName()+"'>Xóa</a></td></tr>");
        }
        }
        else{
           out.println("<tr><th>STT</th><th>Mã lớp</th><th>Môn học</th><th>Giảng Viên</th><th>Số TC</th><th>Ngày</th><th>Phòng</th><th>Ca</th></tr>");
        for(int i=0;i<classlist.size();i++){
         out.println("<tr><td>"+(i+1)+"</td><td><a href='../servClassView?action=detail&classname="+classlist.get(i).getClassName()+"'>"+classlist.get(i).getClassName()+"</a></td><td>"+classlist.get(i).getSubName()+"</td><td>"+classlist.get(i).getLecturerName()+"</td><td>"+classlist.get(i).getNumTC()+"</td><td>Thứ " +classlist.get(i).getDate()+"</td><td>"+classlist.get(i).getRoom()+"</td><td>"+classlist.get(i).getShift()+"</td></tr>");
        }
        }
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void insertClass(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception{
        String ClassName=request.getParameter("txtClassId");
        String SubCode=request.getParameter("ClassName");
        String LectureCode=request.getParameter("LecturerName");
        String Date=request.getParameter("Day");
        String Room =request.getParameter("txtRoom");
        int Shift=Integer.parseInt(request.getParameter("sTime"));
        clsClass cls=new clsClass(ClassName, SubCode, "", LectureCode, Date, Room, Shift, 0, "", "", "", "", 0);
        clsBOClass BOC=new clsBOClass();
        if(BOC.ClassInsert(cls)==0){
            createClass(request, response, session);
        }else if(BOC.ClassInsert(cls)==1){
            session.setAttribute("mes", "Lớp học đã tồn tại, xin kiểm tra lại ở danh lớp học");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
        }
        else if(BOC.ClassInsert(cls)==2){
            session.setAttribute("mes", "Thời gian học(ngày, phòng, ca)đã bị trùng, xin kiểm tra lại");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
        }
        else{
             session.setAttribute("mes", "Giảng viên này đã có lớp học vào ngày và giờ này, xin kiểm tra lại");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
        }
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void createClass(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception{
       clsBOLecturer BOL=new clsBOLecturer();
       ArrayList<clsLecturer> leclist=BOL.GetAllLecturer();
       clsBOSubject BOS=new clsBOSubject();
       ArrayList<clsSubject> sublist =BOS.GetListSubject();
        session.setAttribute("leclist", leclist);
        session.setAttribute("sublist", sublist);
        clsBOClass BOC=new clsBOClass();
        ArrayList<clsClass> classlist=BOC.GetAllClass("ClassName");
        session.setAttribute("clases", classlist);
        String path = "./jsps/jspTaoLopHoc.jsp";
        response.sendRedirect(path);
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void ClassDetail(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception{
         String classname=request.getParameter("classname");
         clsBOClass BOC=new clsBOClass();
         clsClass cls=BOC.getClassinfo(classname);
         session.setAttribute("classdetail", cls);
         ArrayList<clsStudent> studentlist=new ArrayList<clsStudent>();
         studentlist=BOC.getAllStudentOfClass(classname);
          session.setAttribute("studentlist", studentlist);
          String path = "./jsps/jspChiTietLopHoc.jsp";
          response.sendRedirect(path);

    }
    /**
     *
     * @param request
     * @throws Exception
     */
    private void updateClass(HttpServletRequest request) throws Exception{
        String className=request.getParameter("classname");
        String subcode=request.getParameter("subcode");
        String lecturer=request.getParameter("lecturer");
        String date=request.getParameter("date");
        String room=request.getParameter("room");
        int shift=Integer.parseInt(request.getParameter("shift"));
        clsClass cls=new clsClass(className, subcode, "", lecturer, date, room, shift, 0, "", "", "", "", 0);
        clsBOClass BOC=new clsBOClass();
        BOC.ClassUpdateInfo(cls);
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void editClass(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception{
        String classname=request.getParameter("classname");
        clsBOClass BOC=new clsBOClass();
        clsClass cls=BOC.getClassinfo(classname);
         session.setAttribute("classdetail", cls);
         clsBOLecturer BOL=new clsBOLecturer();
         ArrayList<clsLecturer> lec=new ArrayList<clsLecturer>();
         lec=BOL.GetAllLecturer();
          session.setAttribute("lecturer", lec);
        String path = "./jsps/jspSuaLopHoc.jsp";
        response.sendRedirect(path);
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void deleteClass(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception{
          String classname=request.getParameter("classname");
          clsBOClass BOC=new clsBOClass();
         if(BOC.ClassDelete(classname)){
             getAllClass(response, session);
         }else{
             session.setAttribute("mes", "Lớp này đang có sinh viên đăng ký học, phải chuyển sinh viên qua lớp khác đã");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
         }
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void getClassInfo(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception{
        String classname=request.getParameter("classname");
        clsBOClass BOC=new clsBOClass();
        clsClass cls=BOC.getClassinfo(classname);
         session.setAttribute("classdetail", cls);
        String path = "./jsps/jspXoaLopHoc.jsp";
        response.sendRedirect(path);
    }

    /**
     *
     * @param resp
     * @param session
     * @throws IOException
     * @throws Exception
     */
private void getAllClass(HttpServletResponse resp, HttpSession session) throws IOException, Exception{
             session.setAttribute("time", "Học kỳ "+SystemProperities.Curentsemester +" năm học "+SystemProperities.CurentYear);
             clsBOClass BOClass=new clsBOClass();
             ArrayList<clsClass> result=BOClass.GetAllClass("ClassName");
             session.setAttribute("clases", result);
             clsBOLecturer BOL=new clsBOLecturer();
             ArrayList<clsLecturer> leclist=BOL.GetAllLecturer();
             session.setAttribute("lec", leclist);
             clsBOSubject BOS=new clsBOSubject();
             ArrayList<clsSubject> sublist=BOS.GetListSubject();
             session.setAttribute("sub", sublist);
             String path = "./jsps/jspXemDSLop.jsp";
             resp.sendRedirect(path);
    }
/**
 *
 * @param resp
 * @param session
 * @throws IOException
 * @throws Exception
 */
private void getAllClassSV(HttpServletResponse resp, HttpSession session) throws IOException, Exception{
             session.setAttribute("time", "Học kỳ "+SystemProperities.Curentsemester +" năm học "+SystemProperities.CurentYear);
             clsBOClass BOClass=new clsBOClass();
             ArrayList<clsClass> result=BOClass.GetAllClass("ClassName");
             session.setAttribute("clases", result);
              clsBOLecturer BOL=new clsBOLecturer();
             ArrayList<clsLecturer> leclist=BOL.GetAllLecturer();
             session.setAttribute("lec", leclist);
             clsBOSubject BOS=new clsBOSubject();
             ArrayList<clsSubject> sublist=BOS.GetListSubject();
             session.setAttribute("sub", sublist);
             String path = "./jsps/jspXemDSLopSV.jsp";
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
            Logger.getLogger(servClassView.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servClassView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
