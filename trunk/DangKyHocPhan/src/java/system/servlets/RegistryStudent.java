package system.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import system.bo.clsBOAccount;
import system.bo.clsBOStudent;
import system.dto.clsAccount;
import system.dto.clsStudent;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="RegistryStudent", urlPatterns={"/RegistryStudent"})
public class RegistryStudent extends HttpServlet {
      

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
        
        String function = (String)req.getParameter("function");

        if(function.equals("addone")){
            if(AddOne(req, session) == true){
                out.println("<h3 align=\"center\">Nhập thành công</h3>");
            }else{
                out.println("<h3 align=\"center\">Nhập Không thành công</h3>");
            }
            out.println("<input type=\"button\" value=\"Trở lại\">");
        }else if(function.equals("addlist")){
            AddList(req, session);
        }else{
            out.println("Sorry you");
        }
    }

    /**
     * Add one student into databse, infomations about that one are entered normally
     * @param req
     * @param session
     */
    private boolean AddOne(HttpServletRequest req, HttpSession session){
        boolean result = false;
        try {
            String MSSV = (String) req.getParameter("txtMSSV");
            String FullName = (String) req.getParameter("txtFirstName") + (String) req.getParameter("txtLastName");
            String BirthDay = (String) req.getParameter("sYear") + "-" + (String) req.getParameter("sMonth") + "-" + (String) req.getParameter("sDay");
            String ClassName = (String) req.getParameter("sClass");
            String Sex = (String) req.getParameter("sSex");
            String DCThuongTru = (String) req.getParameter("txtThuongTru");
            String DCTamTru = (String) req.getParameter("txtTamTru");
            String Phone = (String) req.getParameter("txtPhoneNumber");
            String Email = (String) req.getParameter("txtEmail");
            String Course = (String) req.getParameter("sCourse");
            //clsStudent student = new clsStudent(FullName, BirthDay, MSSV, ClassName, Email, Phone, DCTamTru, DCThuongTru, 1, Integer.parseInt(Course));
            clsStudent student = new clsStudent(FullName, BirthDay, MSSV, ClassName, Email, Phone,
                                                DCThuongTru, DCTamTru, "Đang học", Integer.parseInt(Course),
                                                Sex, "CMND", "Chính qui", "Đại học");
            clsAccount account = new clsAccount(MSSV, MSSV, FullName, 0, 0, 0);

            clsBOStudent studentBo = new clsBOStudent();
            clsBOAccount accountBo = new clsBOAccount();
            //if(studentBo.c)
            result = studentBo.Insert(student);
            result = accountBo.Insert(account);
            //if result == true do something: creaste account for student, ...
            //else if result == false do something else
        } catch (Exception ex) {
            Logger.getLogger(RegistryStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * Add a list of student into database, infomations get from excell file, and load from local
     * machince
     * @param req
     * @param session
     */
    private ArrayList<String> AddList(HttpServletRequest req, HttpSession session){
        //Do it later
        String path = (String)req.getParameter("txtPath");
        String path1 = "C:\\student 001.xls";

        ArrayList<String> listStudentGetFromFile = GetList(path);
        try {
             UpdateStudent(listStudentGetFromFile);
        } catch (Exception ex) {
            Logger.getLogger(RegistryStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listStudentGetFromFile;
    }

    private ArrayList<String> GetList(String path){
         int i = 0;
        ArrayList<String> listStudentInfo = new ArrayList<String>();
        if (path != null && !path.equals("")) {
          try{
             FileInputStream fs = new FileInputStream(path);
             HSSFWorkbook wb = new HSSFWorkbook(fs);
             int n = wb.getNumberOfSheets();

             for (int k = 0; k < n; k++){
                 HSSFSheet sheet = wb.getSheetAt(k);
                 int rows  = sheet.getPhysicalNumberOfRows();

                 HSSFRow rowTemp;
                 HSSFCell cellTemp;
                 int cellType;
                 String strValue = "";                 
                
                 for (i = 0; i < rows; i++){
                     rowTemp = sheet.getRow(i);                     
                     cellTemp = rowTemp.getCell(0);
                     cellType = cellTemp.getCellType();
                     //check the first cell of data must be a number
                     if(cellType != HSSFCell.CELL_TYPE_NUMERIC){
                         continue;
                     }
                    //CELL 1// FullName//CELL2: MSSV//CELL3: BirthDay//CELL4: Lop - Class//CELL5: Email
                    //CELL6: PhoneNumber//CELL7: TamTru/CELL8: ThuongTru
                    //CELL: Status: Đang học, đang bảo lưu, đang ...
                    //CELL10: CourseNumber//CELL11: Sex//CELL12: ID (CMND)
                    //CELL13: Hình thức: Chính qui, tại chức, ...
                    //CELL14: Bậc học : đại học, cao đẳng, cử nhân, trung cấp,...
                     for(int j = 1; j < 15; j++){
                         cellTemp = rowTemp.getCell(j);
                         cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
                         strValue = cellTemp.getStringCellValue();
                         listStudentInfo.add(strValue);
                     }
                 }
              }
          }catch(Exception e){
              System.out.println(e);
          }
        }
        return listStudentInfo;
    }

    private void UpdateStudent(ArrayList<String> listStudentInfomation) throws Exception{
        String FullName = "";       String MSSV = "";        String Birthday = "";
        String Class = "";          String Email = "";       String Phone = "";
        String Address = "";        String Home = "";        String IsStuding = "";
        String CourseCode = "";     String Gender = "";      String CMND = "";
        String Type = "";           String BacHoc = "";

        int i = 0;
        int n = listStudentInfomation.size();
        clsBOStudent studentBO = new clsBOStudent();
        clsBOAccount accountBO = new clsBOAccount();
        //CELL 1// FullName//CELL2: MSSV//CELL3: BirthDay//CELL4: Lop - Class//CELL5: Email
        //CELL6: PhoneNumber//CELL7: TamTru/CELL8: ThuongTru
        //CELL: Status: Đang học, đang bảo lưu, đang ...
        //CELL10: CourseNumber//CELL11: Sex//CELL12: ID (CMND)
        //CELL13: Hình thức: Chính qui, tại chức, ...
        //CELL14: Bậc học : đại học, cao đẳng, cử nhân, trung cấp,...
        while(i < n){
            FullName = listStudentInfomation.get(i++);
            MSSV = listStudentInfomation.get(i++);
            Birthday = listStudentInfomation.get(i++);
            Birthday = "2000-5-4";
            Class = listStudentInfomation.get(i++);
            Email = listStudentInfomation.get(i++);
            Phone = listStudentInfomation.get(i++);
            Address = listStudentInfomation.get(i++);
            Home = listStudentInfomation.get(i++);
            IsStuding = listStudentInfomation.get(i++);
            CourseCode = listStudentInfomation.get(i++);
            Gender = listStudentInfomation.get(i++);
            CMND = listStudentInfomation.get(i++);
            Type = listStudentInfomation.get(i++);
            BacHoc = listStudentInfomation.get(i++);

            clsStudent student = new clsStudent(FullName, Birthday, MSSV, Class, Email, Phone, Address, Home,
                                            IsStuding, Integer.parseInt(CourseCode), Gender, CMND, Type, BacHoc);
            studentBO.Insert(student);

            clsAccount account = new clsAccount(MSSV, MSSV, FullName, 0, 0, 0);
            boolean resulteInsertAccount = accountBO.Insert(account);
        }
    }
}
