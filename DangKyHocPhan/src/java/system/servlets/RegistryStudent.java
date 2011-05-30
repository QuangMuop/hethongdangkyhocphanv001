package system.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import system.bo.clsBOStudent;
import system.dto.clsAccount;
import system.dto.clsCourse;
import system.dto.clsStudent;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="RegistryStudent", urlPatterns={"/RegistryStudent"})
public class RegistryStudent extends HttpServlet {
      

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
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

         try{
            session.removeAttribute("listinfomation");
        }catch(Exception ex){
            Logger.getLogger(RegistryStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        String function = req.getParameter("action");
        String path = "./jsps/jspTiepNhanSV.jsp";

        ArrayList<String> result = new ArrayList<String>();
        if(function.equals("addone")){
            result = AddOne(req);
            path = "./jsps/jspTiepNhanSV.jsp?result=added";
        }else if(function.equals("addlist")){
            result = AddList(req);
            path = "./jsps/jspTiepNhanSV.jsp?result=added";        
        }else{
            path = "./jsps/jspTiepNhanSV.jsp?result=failed";
        }

        clsBOCourse courseBo = new clsBOCourse();
        int n = 0;
        try {
            ArrayList<clsCourse> listCourse = courseBo.GetAllCorse();
            n = listCourse.size();
        } catch (Exception ex) {
            Logger.getLogger(RegistryStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        session.setAttribute("numcourse", Integer.toString(n));
        session.setAttribute("listinfomation", result);
        resp.sendRedirect(path);
    }


    /**
     * Add one student into databse, infomations about that one are entered normally
     * @param req
     * @param session
     */   
    private ArrayList<String> AddOne(HttpServletRequest req){
        //CELL 1// FullName//CELL2: MSSV//CELL3: BirthDay//CELL4: Lop - Class//CELL5: Email
    //CELL6: PhoneNumber//CELL7: TamTru/CELL8: ThuongTru
    //CELL: Status: Đang học, đang bảo lưu, đang ...
    //CELL10: CourseNumber//CELL11: Sex//CELL12: ID (CMND)
    //CELL13: Hình thức: Chính qui, tại chức, ...
    //CELL14: Bậc học : đại học, cao đẳng, cử nhân, trung cấp,...
        ArrayList<String> listInfomation = new ArrayList<String>();
        try {            
            listInfomation.add((String) req.getParameter("txtFirstName") + " " +
                                                (String) req.getParameter("txtLastName"));
            listInfomation.add((String)req.getParameter("txtMSSV"));
            listInfomation.add((String) req.getParameter("sYear") + "-" +
                               (String) req.getParameter("sMonth") + "-" +
                               (String) req.getParameter("sDay"));
            listInfomation.add((String)req.getParameter("sClass"));
            listInfomation.add((String)req.getParameter("txtEmail"));
            listInfomation.add((String)req.getParameter("txtPhoneNumber"));
            listInfomation.add((String)req.getParameter("txtTamTru"));
            listInfomation.add((String)req.getParameter("txtThuongTru"));
            listInfomation.add((String)req.getParameter("sIsStuding"));
            listInfomation.add((String)req.getParameter("sCourse"));
            listInfomation.add((String)req.getParameter("sSex"));
            listInfomation.add((String)req.getParameter("txtCMND"));
            listInfomation.add((String)req.getParameter("sType"));
            listInfomation.add((String)req.getParameter("sBachoc"));

            return UpdateStudent(listInfomation);

        } catch (Exception ex) {
            Logger.getLogger(RegistryStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listInfomation;
    }


    /**
     *
     * @param req
     * @param session
     * @return
     */
    private ArrayList<String> AddList(HttpServletRequest req){
        HSSFWorkbook wb = GetWorkbook(req);        
        ArrayList<String> listStudentGetFromFile = GetList(wb);

        try {
             return UpdateStudent(listStudentGetFromFile);
        } catch (Exception ex) {
            Logger.getLogger(RegistryStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listStudentGetFromFile;
    }


    /**
     * Check excell file in request from client, if there are some file (just check for one until now)
     * then create a new workbook from that data, and return it for create student object
     * for insertion into database
     * @param req
     * @return
     */
    private HSSFWorkbook GetWorkbook(HttpServletRequest req){
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
                Logger.getLogger(RegistryStudent.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex) {
                Logger.getLogger(RegistryStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /**
     * Get infomation of students in excell file
     * @param wb workbook hold data
     * @return information about student as format:
     *                  CELL 1// FullName//CELL2: MSSV//CELL3: BirthDay//CELL4: Lop - Class//CELL5: Email
     *                  CELL6: PhoneNumber//CELL7: TamTru/CELL8: ThuongTru
     *                  CELL: Status: Đang học, đang bảo lưu, đang ...
     *                  CELL10: CourseNumber//CELL11: Sex//CELL12: ID (CMND)
     *                  CELL13: Hình thức: Chính qui, tại chức, ...
     *                  CELL14: Bậc học : đại học, cao đẳng, cử nhân, trung cấp,...
     */

    private ArrayList<String> GetList(HSSFWorkbook wb){
         int i = 0;
        ArrayList<String> listStudentInfo = new ArrayList<String>();
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
         return listStudentInfo;
    }


    
    /**
     * Create students with infomation get from list, then insert them into database
     * this also init account for that students
     * @param listStudentInfomation hold information about students get from excel file
     * @throws Exception
     */
    private ArrayList<String> UpdateStudent(ArrayList<String> listStudentInfomation) throws Exception{
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
            
            String error = "";
            if(studentBO.CheckExistedCode(MSSV) == true){
                error = "MSSV đã tồn tại";
            }else{
                error = "Thành công";
                clsStudent student = new clsStudent(FullName, Birthday, MSSV, Class, Email, Phone, Address, Home,
                                            IsStuding, Integer.parseInt(CourseCode),"", Gender, CMND, Type, BacHoc);
                clsAccount account = new clsAccount(MSSV, MSSV, FullName, 0, 0, 0);
                
                studentBO.Insert(student);
                accountBO.Insert(account);
            }
            listStudentInfomation.add(i++, error);
        }
        return listStudentInfomation;
    }

}
 
