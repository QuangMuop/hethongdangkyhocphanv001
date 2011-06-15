
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
import system.bo.clsBOLecturer;
import system.bo.clsBORule;
import system.dto.clsLecturer;
import system.dto.clsRule;

@WebServlet(name="servLecturerManager", urlPatterns={"/servLecturerManager"})
public class servLecturerManager extends HttpServlet {
   
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
        clsBOAccount BOA=new clsBOAccount();
        String login=(String) session.getAttribute("username");
        try {
            if(login==null){
             session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
           }
            else{
            String action =request.getParameter("action");
             if(action.equalsIgnoreCase("view")) {
                  if(BOA.getAccountType(login)==1)
                getAllLecturer(response, session);
                  else{
                      session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập với tài khoản quản lý!");
                  String path = "./jsps/jspThongBao.jsp";
                response.sendRedirect(path);
                }
             }
      else  if(action.equalsIgnoreCase("search")) {
                search(request, response);
             }
            else  if(action.equalsIgnoreCase("detail")) {
                LecturerDetail(request, response, session);
             }
            else  if(action.equalsIgnoreCase("edit")) {
                EditLecturer(request, response, session);
             }
            else  if(action.equalsIgnoreCase("update")) {
               updateLecturer(request, response, session);
             }
            else  if(action.equalsIgnoreCase("predelete")) {
               preDeleteLecturer(request, response, session);
             }
            else  if(action.equalsIgnoreCase("delete")) {
               DeleteLecturer(request, response, session);
             }
            else  if(action.equalsIgnoreCase("add")) {
               addLecture(response, session);
             }
             else  if(action.equalsIgnoreCase("addone")) {
               insertOneLecture(request, response, session);
             }
             else  if(action.equalsIgnoreCase("addlist")) {
               insertListLecture(request, response, session);
             }
            }
        } finally { 
            out.close();
        }
    }
    private void insertListLecture(HttpServletRequest request,HttpServletResponse response,  HttpSession session){

    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void insertOneLecture(HttpServletRequest request,HttpServletResponse response,  HttpSession session) throws Exception{
        String Code=request.getParameter("txtCode");
        String FullName=request.getParameter("txtname");
        String BirthDay=request.getParameter("sYear")+"-"+request.getParameter("sMonth")+"-"+request.getParameter("sDay");
        String Gender=request.getParameter("sSex");
        String Address=request.getParameter("txtAddress");
        String Phone=request.getParameter("txtPhone");
        String Email=request.getParameter("txtEmail");
        String HocHam=request.getParameter("sHocHam");
        String HocVi=request.getParameter("sHocVi");
        String CMND=request.getParameter("txtCMND");
        clsLecturer cls=new clsLecturer(Code, FullName, BirthDay, Email, Phone, Address, HocHam, HocVi, Gender, CMND);
        clsBOLecturer BOL=new clsBOLecturer();
        if(BOL.LecturerInsert(cls)){
            session.setAttribute("mes", "Thêm giảng viên thành công!");
        String path = "./jsps/jspThongBao.jsp";
        response.sendRedirect(path);
        }
         else{
            session.setAttribute("mes", "Thêm giảng viên thất bại do Mã giảng viên đã tồn tại!");
        String path = "./jsps/jspThongBao.jsp";
        response.sendRedirect(path);
            }
    }
    /**
     *
     * @param response
     * @param session
     * @throws Exception
     */
    private void addLecture(HttpServletResponse response,  HttpSession session) throws Exception{
        clsBORule BOR=new clsBORule();
        clsRule rule=BOR.getRuleInfo();
        session.setAttribute("rule", rule);
        String path = "./jsps/jspTiepNhanGV.jsp";
        response.sendRedirect(path);
    }

        /**
         *
         * @param request
         * @param response
         * @param session
         * @throws Exception
         */
    private void DeleteLecturer(HttpServletRequest request,HttpServletResponse response,  HttpSession session) throws Exception{
        String Code=request.getParameter("txtcode");
        clsBOLecturer BOL=new clsBOLecturer();
        if(BOL.LecturerDeleteByCode(Code)){
        session.setAttribute("mes", "Xóa giảng viên hoàn tất!");
        String path = "./jsps/jspThongBao.jsp";
        response.sendRedirect(path);
        }
        else{
             session.setAttribute("mes", "Xóa giảng viên thất bại do còn các thông tin liên quan giảng viên, làm ơn xóa các thông tin này trước!");
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
    private void preDeleteLecturer(HttpServletRequest request,HttpServletResponse response,  HttpSession session) throws Exception{
         String lecturerId = request.getParameter("code");
        clsBOLecturer BOL=new clsBOLecturer();
        clsLecturer lec=BOL.getLecturereByCode(lecturerId);
        session.setAttribute("lec", lec);
         String path = "./jsps/jspDeleteLecturer.jsp";
        response.sendRedirect(path);
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws IOException
     * @throws Exception
     */
    private void updateLecturer(HttpServletRequest request,HttpServletResponse response,  HttpSession session) throws IOException, Exception{
        String Code=request.getParameter("txtCode");
        String FullName=request.getParameter("txtName");
        String BirthDay=request.getParameter("sYear")+"-"+request.getParameter("sMonth")+"-"+request.getParameter("sDay");
        String Gender=request.getParameter("sSex");
        String Address=request.getParameter("txtAddress");
        String Phone=request.getParameter("txtPhone");
        String Email=request.getParameter("txtEmail");
        String HocHam=request.getParameter("sHocHam");
        String HocVi=request.getParameter("sHocVi");
        String CMND=request.getParameter("txtCMND");
        clsLecturer cls=new clsLecturer(Code, FullName, BirthDay, Email, Phone, Address, HocHam, HocVi, Gender, CMND);
        clsBOLecturer BOL=new clsBOLecturer();
        BOL.LecturerUpdate(cls);
        session.setAttribute("mes", "Cập nhật thành công!");
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
    private void EditLecturer(HttpServletRequest request,HttpServletResponse response,  HttpSession session) throws Exception{
        String lecturerId = request.getParameter("code");
        clsBOLecturer BOL=new clsBOLecturer();
        clsLecturer lec=BOL.getLecturereByCode(lecturerId);
        session.setAttribute("lec", lec);
         String path = "./jsps/jspCapNhatGV.jsp";
        response.sendRedirect(path);
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void LecturerDetail(HttpServletRequest request,HttpServletResponse response,  HttpSession session) throws Exception{
        String lecturerId = request.getParameter("code");
        clsBOLecturer BOL=new clsBOLecturer();
        clsLecturer lec=BOL.getLecturereByCode(lecturerId);
        session.setAttribute("lec", lec);
         String path = "./jsps/jspChiTietGV.jsp";
        response.sendRedirect(path);
    }
    /**
     *
     * @param response
     * @param session
     * @throws Exception
     */
private void getAllLecturer(HttpServletResponse response, HttpSession session) throws Exception{
    clsBOLecturer BOL=new clsBOLecturer();
    ArrayList<clsLecturer> leclist=BOL.GetAllLecturer();
        session.setAttribute("leclist", leclist);
        String path = "./jsps/jspQuanLyGiangVien.jsp";
        response.sendRedirect(path);

}
/**
 * 
 * @param request
 * @param response
 * @throws Exception
 */
private void search(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String type=request.getParameter("type");
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
         clsBOLecturer BOL=new clsBOLecturer();
         ArrayList<clsLecturer> listLect=new ArrayList<clsLecturer>();
         if(type.equalsIgnoreCase("id")){
             listLect=BOL.GetLecturerById(name);
         }
        else if(type.equalsIgnoreCase("name"))
          {
            listLect=BOL.GetLecturerByName(name);
         }
         else if(type.equalsIgnoreCase("All"))
          {
            listLect=BOL.GetAllLecturer();
         }
         out.println("<tr><th>STT</th><th>Mã GV</th><th>Họ Tên</th><th>Ngày Sinh</th><th>Giới tính</th><th>Học hàm</th><th>Học vị</th><th>Sửa</th><th>Xóa</th></tr>");
        for(int i=0;i<listLect.size();i++){
            out.println(""
                    + "<tr>"
                    + "<td>"+(i+1)+"</td>"
                    + "<td><a href='../servLecturerManager?action=detail&code="+ listLect.get(i).getLecturerCode()+"'>"+listLect.get(i).getLecturerCode()+"</a></td>"
                    + "<td>" + listLect.get(i).getFullname()+ "</td>"
                    + "<td>" + listLect.get(i).getBirthDay()+ "</td>"
                    + "<td>" + listLect.get(i).getGender()+ "</td>"
                    + "<td>" + listLect.get(i).getHocHam()+ "</td>"
                    + "<td>" + listLect.get(i).getHocVi()+ "</td>"
                    + "<td><a href='../servLecturerManager?code=" + listLect.get(i).getLecturerCode() + "&action=edit'>Sửa</a></td>"
                    + "<td><a href='../servLecturerManager?code=" + listLect.get(i).getLecturerCode() + "&action=predelete'> Xóa</a></td>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(servLecturerManager.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servLecturerManager.class.getName()).log(Level.SEVERE, null, ex);
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
