package system.servlets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import system.bo.clsBODetailResult;
import system.bo.clsBOStudent;
import system.dto.clsDetailResult;
import system.dto.clsStudent;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="DownloadFile", urlPatterns={"/DownloadFile"})
public class DownloadFile extends HttpServlet {
    int numTc = 0;
   
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
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        String function = (String) req.getParameter("action");
        String mssv = (String) req.getParameter("mssv");

        if(function.equals("studentresult")){
            try {
                ExportFileStudentScoreTable(req, resp, mssv);
            } catch (Exception ex) {
                Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(function.equals("studentlist")){
            try {
               // resp.getWriter().println("OK");
                ExportStudentList(req, resp);
            } catch (Exception ex) {
                Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   }
private void ExportStudentList(HttpServletRequest req, HttpServletResponse resp) throws Exception{
    String type=req.getParameter("type");
    String name=req.getParameter("name");
    clsBOStudent BOS=new clsBOStudent();
    ArrayList<clsStudent> studentlist=new ArrayList<clsStudent>();
    if(type.equalsIgnoreCase("mssv")){
            studentlist=BOS.getStudentsByCode(name);
        }else if(type.equalsIgnoreCase("name")){
           studentlist=BOS.getStudentsByName(name);
        }else if(type.equalsIgnoreCase("classname")){
         studentlist=BOS.GetStudentsByClass(name);
        }else if(type.equalsIgnoreCase("All")){
            studentlist=BOS.GetAllStudent();
        }
     try{
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("Danh sách sinh viên ");
            HSSFCellStyle style = hwb.createCellStyle();

            int nrow = 0, i = 0;
            int n = studentlist.size();

            //Write student's information into file
            HSSFRow row1 = null;
            HSSFCell cell1 = null;

            row1 = sheet.createRow((short) +(nrow++));
            cell1 = row1.createCell((short) +4);
            cell1.setCellStyle(style);
            cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
            if (type.equalsIgnoreCase("mssv")) {
               cell1.setCellValue("Danh sách sinh viên có MSSV "+name);
            } else if (type.equalsIgnoreCase("name")) {
              cell1.setCellValue("Danh sách sinh viên có tên "+name);
            } else if (type.equalsIgnoreCase("classname")) {
                cell1.setCellValue("Danh sách sinh viên lớp "+name);
            } else if (type.equalsIgnoreCase("All")) {
                cell1.setCellValue("Danh sách tất cả các sinh viên của khoa");
            }
            

            String[] title = {"STT","Họ tên","MSSV", "Ngày sinh", "Lớp","Email","Điện thoại","Tạm trú","Thường trú","Tình trạng","Khóa","Ngày nhập học","Giới tính","CMND","Hình thức đào tạo","Bậc học"};
            row1 = sheet.createRow((short) +(nrow++));
            for(i = 0; i < title.length; i++){                
                cell1 = row1.createCell((short) +i);
                cell1.setCellStyle(style);
                cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell1.setCellValue(title[i]);
            }

            //write score of student into file
            String Fullname;
            String Code;
            String Birthday;
            String Class;
            String Email;
            String Phone;
            String Address;
            String Home;
            String Status;
            int Course;
            String DateBegin;
            String Gender;
            String CMND;
            String Type;
            String BacHoc;
            for(i = 0; i < n; i++){
                clsStudent stTemp = studentlist.get(i);
                HSSFRow row = sheet.createRow((short) +(nrow++));

             Fullname=stTemp.getFullname();
             Code =stTemp.getCode();
             Birthday=stTemp.getBirthDay();
             Class=stTemp.getClasss();
             Email=stTemp.getEmail();
             Phone=stTemp.getPhone();
             Address=stTemp.getAddress();
             Home=stTemp.getHome();
             Status=stTemp.getIsStuding();
             Course=stTemp.getCourse();
             DateBegin=stTemp.getNhaphoc();
             Gender=stTemp.getGender();
             CMND=stTemp.getCMND();
             Type=stTemp.getType();
             BacHoc=stTemp.getBacHoc();
                String[] info = {Integer.toString(i+1),Fullname, Code , Birthday, Class,Email, Phone, Address, Home,Status, Integer.toString(Course), DateBegin, Gender, CMND, Type, BacHoc};

                HSSFCell cell = null;
                for(int j = 0; j < info.length; j++){
                    cell = row.createCell((short) +j);
                    cell.setCellStyle(style);
                    if(j==0) {
                        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(Double.parseDouble(info[j]));
                    }
                    else {
                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell.setCellValue(info[j]);
                    }
                    
                }
            }

            //style.setFillBackgroundColor(HSSFColor.AQUA.index);
            //style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
            //style.setFillForegroundColor(HSSFColor.AQUA.index);
            //style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            FileOutputStream fileOut = new FileOutputStream("DanhsachSV" +".xls");
            hwb.write(fileOut);
            fileOut.close();
            DownloadFile("DanhsachSV" +".xls", resp);
            
        }
        catch (Exception ex){
            resp.getWriter().println(ex.toString());
        }
     resp.getWriter().println("OK");
}
     /**
     * 
     * @param req
     * @param resp
     * @param mssv
     * @return
     * @throws Exception 
     */
    private String ExportFileStudentScoreTable(HttpServletRequest req, HttpServletResponse resp, String mssv) throws Exception{
        clsBODetailResult BODR=new clsBODetailResult();
        ArrayList<clsDetailResult> resultstudy=BODR.getResult(mssv,"All",0);
        int numtc=getnumtc(resultstudy);
        float DTB=DTB(resultstudy);
        String result = "";
        clsBOStudent studentBo = new clsBOStudent();
        
        clsStudent student = studentBo.getStudentInfoByCode(mssv);
        //Init file on server
        try{
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("Bang Diem SV " + mssv);
            HSSFCellStyle style = hwb.createCellStyle();

            boolean done = false;
            int nrow = 0, i = 0;
            int n = resultstudy.size();

            String[] infoStudent = {"Họ Và Tên: " + student.getFullname(),
                                    "MSSV: " + student.getCode(),
                                    "Số TC Da tich luy: " + numtc,
                                    "Diểm TB: " + DTB};

            //Write student's information into file
            HSSFRow row1 = null;
            HSSFCell cell1 = null;

            row1 = sheet.createRow((short) +(nrow++));
            cell1 = row1.createCell((short) +4);
            cell1.setCellStyle(style);
            cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell1.setCellValue("BẢNG ĐIỂM SINH VIÊN");

            row1 = sheet.createRow((short) +(nrow++));
            row1 = sheet.createRow((short) +(nrow++));

            for(i = 0; i < infoStudent.length; i++){
                row1 = sheet.createRow((short) +(nrow++));
                cell1 = row1.createCell((short) +0);
                cell1.setCellStyle(style);
                cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell1.setCellValue(infoStudent[i]);
            }

            row1 = sheet.createRow((short) +(nrow++));
            row1 = sheet.createRow((short) +(nrow++));
            row1 = sheet.createRow((short) +(nrow++));

            String[] title = {"Năm học","Học kỳ","Mã môn học", "Tên môn học", "Điểm"};
            row1 = sheet.createRow((short) +(nrow++));
            for(i = 0; i < title.length; i++){                
                cell1 = row1.createCell((short) +i);
                cell1.setCellStyle(style);
                cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell1.setCellValue(title[i]);
            }

            //write score of student into file
            String subCode;
            String subName;
            Float mark;
            int semester;
            String year;
            for(i = 0; i < n; i++){
                clsDetailResult stTemp = resultstudy.get(i);
                HSSFRow row = sheet.createRow((short) +(nrow++));

                subCode = stTemp.getSubCode();
                subName = stTemp.getSubName();               
                mark = stTemp.getMark();
                semester=stTemp.getSemester();
                year=stTemp.getYear();
                String[] info = {year,Integer.toString(semester), subCode , subName, Float.toString(mark)};

                HSSFCell cell = null;
                for(int j = 0; j < info.length; j++){
                    cell = row.createCell((short) +j);
                    cell.setCellStyle(style);
                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    cell.setCellValue(info[j]);
                }
            }

            //style.setFillBackgroundColor(HSSFColor.AQUA.index);
            //style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
            //style.setFillForegroundColor(HSSFColor.AQUA.index);
            //style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            FileOutputStream fileOut = new FileOutputStream("Bangdiem" + mssv +".xls");
            hwb.write(fileOut);
            fileOut.close();
            DownloadFile("Bangdiem" + mssv +".xls", resp);
            result = "Tao file thanh cong";
        }
        catch (Exception ex){
            result = ex.toString();
        }
        return result;
    }
  private int getnumtc(ArrayList<clsDetailResult> resultstudy){
      int numtc=0;
       for(int i=0;i<resultstudy.size();i++){
          numtc+=resultstudy.get(i).getNumTC();  
        }
      return numtc;
  }
    private float DTB(ArrayList<clsDetailResult> resultstudy){
        int numtc=getnumtc(resultstudy);
        float summark=0;
        float result = 0;
        for(int i=0;i<resultstudy.size();i++){
          summark+=resultstudy.get(i).getNumTC()*resultstudy.get(i).getMark();  
        }
        result=(float)Math.round(summark*100/numtc)/100;
        return result;
    }

    private void DownloadFile(String filename, HttpServletResponse resp) throws IOException{
        try{
            resp.reset();
            resp.setContentType("application/xls");
            resp.setHeader("Content-disposition","attachment; filename=" +filename);

            FileInputStream in = new FileInputStream(filename);
            int i;
            while ((i = in.read()) != -1){
                resp.getOutputStream().write(i);
            }
            in.close();
            resp.getOutputStream().flush();
        }catch(Exception e){
            resp.getWriter().println(e.toString());
        }
    }
}
