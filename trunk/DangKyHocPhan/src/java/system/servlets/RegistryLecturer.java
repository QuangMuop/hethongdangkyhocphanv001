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
import system.bo.clsBOLecturer;
import system.dto.clsAccount;
import system.dto.clsLecturer;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="RegistryLecturer", urlPatterns={"/RegistryLecturer"})
public class RegistryLecturer extends HttpServlet {

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
        String path = "./jsps/jspTiepNhanGV.jsp";

        try{
            session.removeAttribute("listinfomation");
        }catch(Exception ex){
            Logger.getLogger(RegistryLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> result = new ArrayList<String>();
        if(function.equals("addone")){
            result = AddOne(req);
            path = "./jsps/jspTiepNhanGV.jsp?result=added";            
        }else if(function.equals("addlist")){
            result = AddList(req);
            path = "./jsps/jspTiepNhanGV.jsp?result=added";            
        }else{
            path = "./jsps/jspTiepNhanGV.jsp?result=failed";            
        }
        session.setAttribute("listinfomation", result);
        resp.sendRedirect(path);
    }

    /**
     * Add one lecturer into databse, infomations about that one are entered normally
     * @param req
     */
    private ArrayList<String> AddOne(HttpServletRequest req){
        //1. LecturerCode,   2. FullName,     3. BirthDay, 4. Email, 5. Phone
        //6. Address,   7. HocHam,  8. Degree,  9.Gender,   10. CMND.
        ArrayList<String> listInfomation = new ArrayList<String>();
        try {
            listInfomation.add((String)req.getParameter("txtLecturerCode"));
            listInfomation.add((String) req.getParameter("txtFirstName") + " " +
                                                (String) req.getParameter("txtLastName"));            
            listInfomation.add((String) req.getParameter("sYear") + "-" +
                               (String) req.getParameter("sMonth") + "-" +
                               (String) req.getParameter("sDay"));            
            listInfomation.add((String)req.getParameter("txtEmail"));
            listInfomation.add((String)req.getParameter("txtPhoneNumber"));
            listInfomation.add((String)req.getParameter("txtAddress"));
            listInfomation.add((String)req.getParameter("sHocHam"));
            listInfomation.add((String)req.getParameter("sHocVi"));
            listInfomation.add((String)req.getParameter("sSex"));
            listInfomation.add((String)req.getParameter("txtCMND"));
            
            return UpdateLecturer(listInfomation);

        } catch (Exception ex) {
            Logger.getLogger(RegistryLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listInfomation;
    }


    /**
     * Add a list of Lecturer into database, infomations get from excell file,
     * and load from local machince
     * @param req     
     */
    private ArrayList<String> AddList(HttpServletRequest req){
        HSSFWorkbook wb = GetWorkbook(req);
        ArrayList<String> listStudentGetFromFile = GetList(wb);

        try {
             return UpdateLecturer(listStudentGetFromFile);
        } catch (Exception ex) {
            Logger.getLogger(RegistryLecturer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listStudentGetFromFile;
    }


    /**
     * Check excell file in request from client,
     * if there are some file (just check for one until now)
     * then create a new workbook from that data, and return
     * it for create Lecturer objects for insertion into database
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
                Logger.getLogger(RegistryLecturer.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex) {
                Logger.getLogger(RegistryLecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /**
     * Get infomation of lecturers in excell file
     * @param wb workbook hold data
     * @return information about student as format:     
     */

    private ArrayList<String> GetList(HSSFWorkbook wb){
         int i = 0;
        ArrayList<String> listInfo = new ArrayList<String>();
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
                //1. LecturerCode,   2. FullName,     3. BirthDay, 4. Email, 5. Phone
                //6. Address,   7. HocHam,  8. Degree,  9.Gender,   10. CMND.
                 for(int j = 1; j < 11; j++){
                     cellTemp = rowTemp.getCell(j);
                     cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
                     strValue = cellTemp.getStringCellValue();
                     listInfo.add(strValue);
                 }
             }
         }
         return listInfo;
    }

    /**
     * Create students with infomation get from list, then insert them into database
     * this also init account for that students
     * @param listStudentInfomation hold information about students get from excel file
     * @throws Exception
     */
    private ArrayList<String> UpdateLecturer(ArrayList<String> listInfomation) throws Exception{
        //1. LecturerCode,   2. FullName,     3. BirthDay, 4. Email, 5. Phone
        //6. Address,   7. HocHam,  8. Degree,  9.Gender,   10. CMND.
        String LecturerCode = "";
        String FullName = "";
        String Birthday = "";
        String Email = "";
        String Phone = "";
        String Address = "";
        String HocHam = "";
        String Degree = "";
        String Gender = "";
        String CMND = "";
        
        int i = 0;
        int n = listInfomation.size();
        clsBOLecturer lecturerBo = new clsBOLecturer();
        clsBOAccount accountBO = new clsBOAccount();        
        while(i < n){
            LecturerCode = listInfomation.get(i++);
            FullName = listInfomation.get(i++);
            Birthday = "1975-5-10";
            i++;
            //Birthday = listInfomation.get(i++);
            Email = listInfomation.get(i++);
            Phone = listInfomation.get(i++);
            Address = listInfomation.get(i++);
            HocHam = listInfomation.get(i++);
            Degree = listInfomation.get(i++);
            Gender = listInfomation.get(i++);
            CMND = listInfomation.get(i++);

            String error = "";
            if(lecturerBo.LecturerCheckExistCode(LecturerCode) == true){
                error = "Ma GV đã tồn tại";
            }else{
                error = "Thành công";
                clsLecturer lecturer = new clsLecturer(FullName, Birthday, Email, Phone, Address, HocHam, Degree, Gender, CMND);
                lecturer.setLecturerCode(LecturerCode);
                clsAccount account = new clsAccount(LecturerCode, LecturerCode, FullName, 0, 0, 0);
                lecturerBo.LecturerInsert(lecturer);
                accountBO.Insert(account);
            }
            listInfomation.add(i++, error);
        }
        return listInfomation;
    }
}
