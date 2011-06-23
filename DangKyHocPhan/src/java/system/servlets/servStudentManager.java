/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import system.bo.clsBOAccount;
import system.bo.clsBOCourse;
import system.bo.clsBORule;
import system.bo.clsBOStudent;
import system.dto.clsCourse;
import system.dto.clsRule;
import system.dto.clsStudent;

/**
 *
 * @author Ultimate
 */
@WebServlet(name="servStudentManager", urlPatterns={"/servStudentManager"})
public class servStudentManager extends HttpServlet {
   
    /**
     * rows IOException if an I/O error occurs
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
                getAllStudent(response, session);
                  else{
                      session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập với tài khoản quản lý!");
                  String path = "./jsps/jspThongBao.jsp";
                response.sendRedirect(path);
                }
             }
            else if(action.equalsIgnoreCase("search")) {
               searchStudent(request, response);
             }
            else if(action.equalsIgnoreCase("create")) {
               CreateStudent(response, session);
             }
            else if(action.equalsIgnoreCase("detail")) {
                   StudentDetail(request, response, session);
             }
            else if(action.equalsIgnoreCase("edit")) {
                   editStudent(request, response, session);
             }
            else if(action.equalsIgnoreCase("update")) {
                  updateStudent(request, response, session);
             }
            else if(action.equalsIgnoreCase("predelete")) {
                predelStudent(request, response, session);
             }
            else if(action.equalsIgnoreCase("delete")) {
                deleteStudent(request, response, session);
             }
            else if(action.equalsIgnoreCase("addone")) {
                   InsertOneStudent(request, response, session);
             }
            else if(action.equalsIgnoreCase("addlist")) {
               InsertListStudent(request, response, session);
             }
            }
        } finally { 
            out.close();
        }
    }
   private HSSFWorkbook GetWorkbook(HttpServletRequest req, HttpServletResponse response) throws IOException, FileUploadException{
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if(isMultipart){
            ServletFileUpload upload = new ServletFileUpload();
            FileItemIterator iter;
            String fileNamSource = req.getParameter("txtPath");
            try {
                iter = upload.getItemIterator(req);
                FileItemStream item = null;
                String name = "";
                InputStream stream = null;
                while (iter.hasNext()){
                    item = iter.next();
                    name = item.getFieldName();
                    stream = item.openStream();
                    if(item.isFormField()){
                        //String result = "notFormField";
                        continue;
                    }else {
                        name = item.getName();
                        if(name != null && !"".equals(name)){
                            String fileName = new File(item.getName()).getName();
                            //if(fileName.equals(fileNamSource)){
                                POIFSFileSystem fs = new POIFSFileSystem(stream);
                                HSSFWorkbook wb = new HSSFWorkbook(fs);
                                return wb;
                            //}
                        }
                    }
                }
            } catch (FileUploadException ex) {
               response.getWriter().println(ex.toString());
            }catch (IOException ex) {
               response.getWriter().println(ex.toString());
            }
        }
        return null;
    }
    private void InsertListStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, FileUploadException, Exception{
        HSSFWorkbook wb=GetWorkbook(request, response);
         int i = 0;
         int numerror=0;
        ArrayList<String> Studentinfo;
        ArrayList<String> result=new ArrayList<String>();
         int n = wb.getNumberOfSheets();

         for (int k = 0; k < n; k++){
             HSSFSheet sheet = wb.getSheetAt(k);
             int rows  = sheet.getPhysicalNumberOfRows();

             HSSFRow rowTemp;
             HSSFCell cellTemp;
             int cellType;
             String strValue = "";

             for (i = 0; i < rows; i++){
                 Studentinfo=new ArrayList<String>();
                 rowTemp = sheet.getRow(i);
                 cellTemp = rowTemp.getCell(0);
                 cellType = cellTemp.getCellType();
                 //check the first cell of data must be a number
                 if(cellType != HSSFCell.CELL_TYPE_NUMERIC){
                     continue;
                 }
                 //CELL 1// FullName//CELL2: MSSV//CELL3: BirthDay//CELL4: Lop - Class//CELL5: Email
                //CELL6: PhoneNumber//CELL7: TamTru/CELL8: ThuongTru
                //CELL9: Status: Đang học, đang bảo lưu, đang ...
                //CELL10: khóa học
                 //cell11: Ngày nhập học
                 //CELL11: Sex//CELL12: ID (CMND)
                //CELL13: Hình thức: Chính qui, tại chức, ...
                //CELL14: Bậc học : đại học, cao đẳng, cử nhân, trung cấp,...
                 for(int j = 1; j < 16; j++){
                     cellTemp = rowTemp.getCell(j);
                     cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
                     strValue = cellTemp.getStringCellValue();
                     Studentinfo.add(strValue);
                 }
                clsStudent cls=new clsStudent();
                cls=new clsStudent(Studentinfo.get(0), Studentinfo.get(2), Studentinfo.get(1), Studentinfo.get(3), Studentinfo.get(4), Studentinfo.get(5), Studentinfo.get(6), Studentinfo.get(7), Studentinfo.get(8),Integer.parseInt(Studentinfo.get(9)), Studentinfo.get(10), Studentinfo.get(11), Studentinfo.get(12), Studentinfo.get(13), Studentinfo.get(14));
               clsBOStudent BOS=new clsBOStudent();
                if(BOS.Insert(cls))
               {
                  result.add("OK");                    
               }
               else{
                       result.add(cls.getFullname());
                    }
                
            }
         }
         for(int j=0;j<result.size();j++){
            if(result.get(j).equalsIgnoreCase("OK")==false)
                 numerror++; 
         }
          if(numerror>0) {
              StringBuffer message=new StringBuffer();
               message.append("Các sinh viên có tên: ");
              for(int j=0;j<result.size();j++){
                if(result.get(j).equalsIgnoreCase("OK")==false)
                message.append(result.get(j)).append(", ");
                }
              message.append(" thêm không thành công do dữ liệu không hợp lệ, còn lại thêm thành công");
              session.setAttribute("mes", message.toString());
           String path = "./jsps/jspThongBao.jsp";
           response.sendRedirect(path);
          }
          else{
          session.setAttribute("mes", "Thêm tất cả sinh viên thành công!");
           String path = "./jsps/jspThongBao.jsp";
           response.sendRedirect(path);
          }
         
    }
    private void updateStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        String MSSV=request.getParameter("txtCode");
        String FullName=request.getParameter("txtname");
        String Birthday=request.getParameter("sYear")+"-"+request.getParameter("sMonth")+"-"+request.getParameter("sDay");
        String Gender=request.getParameter("sSex");
        String Class=request.getParameter("sClass");
        int CourseCode=Integer.parseInt(request.getParameter("sCourse"));
        String Type=request.getParameter("sType");
        String BacHoc=request.getParameter("sBacHoc");
        String Home=request.getParameter("txthome");
        String Address=request.getParameter("txtadd");
        String CMND=request.getParameter("txtCMND");
        String NhapHoc=request.getParameter("sYear1")+"-"+request.getParameter("sMonth1")+"-"+request.getParameter("sDay1");
        String Phone=request.getParameter("txtphone");
        String Email=request.getParameter("txtemail");
        String isStuding=request.getParameter("sStatus");
        clsStudent cls=new clsStudent(FullName, Birthday, MSSV, Class, Email, Phone, Address, Home, isStuding, CourseCode, NhapHoc, Gender, CMND, Type, BacHoc);
        clsBOStudent BOS=new clsBOStudent();
        BOS.updateStudentByAmin(cls);
        session.setAttribute("mes", "Cập nhật thông tin sinh viên hoàn tất!");
            String path = "./jsps/jspThongBao.jsp";
            response.sendRedirect(path);
    }
     private void editStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
       String MSSV=request.getParameter("MSSV");
       clsBOStudent BOStudent=new clsBOStudent();
        clsStudent student =new clsStudent();
        student=BOStudent.getStudentInfoByCode(MSSV);
       session.setAttribute("student", student);
       clsBOCourse BOC=new clsBOCourse();
       ArrayList<String> listClass=BOC.getAllClassName();
        session.setAttribute("listClass", listClass);
         ArrayList<clsCourse> listCourse=BOC.GetAllCorse();
        session.setAttribute("listCourse", listCourse);
        clsBORule BOR=new clsBORule();
        clsRule rule=BOR.getRuleInfo();
        session.setAttribute("rule", rule);
       String path = "./jsps/jspCapNhatSV.jsp";
       response.sendRedirect(path);
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
       String MSSV=request.getParameter("MSSV");
       clsBOStudent BOS=new clsBOStudent();
       if(BOS.Delete(MSSV)){
           session.setAttribute("mes", "Xóa sinh viên hoàn tất!");
            String path = "./jsps/jspThongBao.jsp";
            response.sendRedirect(path);
       }
             else{
           session.setAttribute("mes", "Xóa sinh viên thất bại do còn có thông tin khác liên quan tới sinh viên này, xin xóa các thông tin này trước");
            String path = "./jsps/jspThongBao.jsp";
            response.sendRedirect(path);
            }
    }
    private void predelStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
         String MSSV=request.getParameter("MSSV");
       clsBOStudent BOStudent=new clsBOStudent();
        clsStudent student =new clsStudent();
        student=BOStudent.getStudentInfoByCode(MSSV);
       session.setAttribute("student", student);
       String path = "./jsps/jspXoaSV.jsp";
       response.sendRedirect(path);
    }
    private void StudentDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
         String MSSV=request.getParameter("MSSV");
       clsBOStudent BOStudent=new clsBOStudent();
        clsStudent student =new clsStudent();
        student=BOStudent.getStudentInfoByCode(MSSV);
       session.setAttribute("student", student);
       String path = "./jsps/jspChiTietSV.jsp";
       response.sendRedirect(path);
    }
       
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void InsertOneStudent(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        String MSSV=request.getParameter("txtMSSV");
        String FullName=request.getParameter("txtname");
        String Birthday=request.getParameter("sYear")+"-"+request.getParameter("sMonth")+"-"+request.getParameter("sDay");
        String Gender=request.getParameter("sSex");
        String Class=request.getParameter("sClass");
        int CourseCode=Integer.parseInt(request.getParameter("sCourse"));
        String Type=request.getParameter("sType");
        String BacHoc=request.getParameter("sBacHoc");
        String Home=request.getParameter("txthome");
        String Address=request.getParameter("txtadd");
        String CMND=request.getParameter("txtcmnd");
        String NhapHoc=request.getParameter("sYear1")+"-"+request.getParameter("sMonth1")+"-"+request.getParameter("sDay1");
        String Phone=request.getParameter("txtphone");
        String Email=request.getParameter("txtemail");
        clsStudent cls=new clsStudent(FullName, Birthday, MSSV, Class, Email, Phone, Address, Home, "Đang học", CourseCode, NhapHoc, Gender, CMND, Type, BacHoc);
        clsBOStudent BOS=new clsBOStudent();
        if(BOS.CheckExistedCode(MSSV)){
            session.setAttribute("mes", "Thêm sinh viên thất bại vì Mã số sinh viên này đã tồn tại!");
            String path = "./jsps/jspThongBao.jsp";
            response.sendRedirect(path);
        }else{
            if(BOS.Insert(cls)){
                session.setAttribute("mes", "Thêm sinh viên thành công!");
            String path = "./jsps/jspThongBao.jsp";
            response.sendRedirect(path);
            }else {
                session.setAttribute("mes", "Thêm sinh viên thất bại vui lòng kiểm tra lại!");
            String path = "./jsps/jspThongBao.jsp";
            response.sendRedirect(path);
            }
        }
        
    }
    /**
     *
     * @param response
     * @param session
     * @throws IOException
     * @throws Exception
     */
    private void CreateStudent(HttpServletResponse response, HttpSession session) throws IOException, Exception{
        clsBOCourse BOC=new clsBOCourse();
        ArrayList<String> listClass=BOC.getAllClassName();
        session.setAttribute("listClass", listClass);
        ArrayList<clsCourse> listCourse=BOC.GetAllCorse();
        session.setAttribute("listCourse", listCourse);
        clsBORule BOR=new clsBORule();
        clsRule rule=BOR.getRuleInfo();
        session.setAttribute("rule", rule);
        String path = "./jsps/jspTiepNhanSV.jsp";
        response.sendRedirect(path);
    }
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws Exception
     */
    private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception{
        PrintWriter out = response.getWriter();
        String type=request.getParameter("type");
        String name=request.getParameter("name");
        int start=Integer.parseInt(request.getParameter("start"));
        clsBOStudent BOS=new clsBOStudent();
        ArrayList<clsStudent> studentlist=new ArrayList<clsStudent>();
        int numstudent=0;
        if(type.equalsIgnoreCase("mssv")){
            numstudent=BOS.CountStudentByCode(name);
            studentlist=BOS.getStudentsByCodeWithLimmit(name, start, 5);
        }else if(type.equalsIgnoreCase("name")){
            numstudent=BOS.CountStudentByName(name);
            studentlist=BOS.getStudentsByNameWithLimit(name, start, 5);
        }else if(type.equalsIgnoreCase("classname")){
            numstudent=BOS.CountStudentByClass(name);
           studentlist=BOS.getStudentsByClassWithLimmit(name, start, 5);
        }else if(type.equalsIgnoreCase("All")){
            numstudent=BOS.CountAllStudent();
            studentlist=BOS.getAllStudentWithLimit(start, 5);
        }
        if(studentlist.isEmpty()){
            out.println("Không có kết quả nào phù hợp");
        }else{
        out.println("<tr><th>STT</th><th>MSSV</th><th>Họ Tên</th><th>Lớp</th><th>Ngày sinh</th><th>Giới tính</th><th>Loại</th><th>Sửa</th><th>Xóa</th><th>Cập nhật</th></tr>");
        for(int i=0;i<studentlist.size();i++){
            StringBuffer str=new StringBuffer();
            str.append("<tr><td>").append(start + 1 + i).append("</td>");
            str.append("<td><a href='../servStudentManager?action=detail&MSSV=<%="+studentlist.get(i).getCode()+"'>").append(studentlist.get(i).getCode()).append("</a></td>");
            str.append("<td>").append(studentlist.get(i).getFullname()).append("</td>");
            str.append("<td>").append(studentlist.get(i).getClasss()).append("</td>");
            str.append("<td>").append(studentlist.get(i).getBirthDay()).append("</td>");
            str.append("<td>").append(studentlist.get(i).getGender()).append("</td>");
            str.append("<td>").append(studentlist.get(i).getType()).append("</td>");
            str.append("<td><a href='../servStudentManager?action=edit&MSSV=").append(studentlist.get(i).getCode()).append("'>Sửa</a></td>");
            str.append("<td><a href='../servStudentManager?action=delete&MSSV=").append(studentlist.get(i).getCode()).append("'>Xóa</a></td>");
            if(studentlist.get(i).getNote().equalsIgnoreCase("null")||studentlist.get(i).getNote().equalsIgnoreCase(""))
                str.append("<td>Không</td>");
            else
                 str.append("<td>Có</td>");
            out.println(str.toString());
        }
        }
         out.println("<input type='hidden' value='"+numstudent+"' id='numstuafter' />");
    }
    /**
     *
     * @param response
     * @param session
     * @throws Exception
     */
private void getAllStudent(HttpServletResponse response, HttpSession session) throws Exception{
        clsBOStudent BOS=new clsBOStudent();
        int numstudent=BOS.CountAllStudent();
        session.setAttribute("numStudent", numstudent);
        ArrayList<clsStudent> listStudent=BOS.getAllStudentWithLimit(0, 5);
        session.setAttribute("liststudent", listStudent);
       clsBOCourse BOC=new clsBOCourse();
        ArrayList<String> listClass=BOC.getAllClassName();
        session.setAttribute("listClass", listClass);
        String path = "./jsps/jspQuanLySinhVien.jsp";
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
            Logger.getLogger(servStudentManager.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servStudentManager.class.getName()).log(Level.SEVERE, null, ex);
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
