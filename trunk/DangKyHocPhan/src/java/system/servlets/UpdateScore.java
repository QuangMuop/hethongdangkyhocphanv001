package system.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import system.bo.clsBOClass;
import system.bo.clsBORegistration;
import system.bo.clsBOStudyResult;
import system.bo.clsBOSubject;
import system.dto.clsClass;
import system.dto.clsRegistration;
import system.dto.clsStudyResult;
import system.dto.clsSubject;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="UpdateScore", urlPatterns={"/UpdateScore"})
public class UpdateScore extends HttpServlet {
   
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
        String path = "./jsps/jspGhiNhanDiemSV.jsp";
        String error = "";
        String function = (String)req.getParameter("function");

        if(function.equals("loaddata")){
            error = LoadData(session);
            resp.sendRedirect(path);
            return;
        }else if(function.equals("process")){
            error = ProcessUpdate(req);
        }else{
            error = "Lỗi: servlet UpdateScore, dòng 57";
        }
        if(!error.equals("OK")){
            error = "đã cập nhật thành công";
            session.setAttribute("mes", error);
            path = "./jsps/jspThongBao.jsp";
            resp.sendRedirect(path);
        }else
           resp.sendRedirect(path);
    }

    private String LoadData(HttpSession session){
        String error = "OK";
        clsBOClass classBo = new clsBOClass();
        clsBOSubject subBo = new clsBOSubject();
        ArrayList<String> listInfomation = new ArrayList<String>();
        int n = 0;
        ArrayList<clsClass> classList;
        try {
            classList = classBo.GetAllClass("ClassName");
            if(classList != null){
                n = classList.size();
                for(int i = 0; i < n; i++){
                    clsClass classTemp = classList.get(i);
                    String subCode = classTemp.getSubCode();
                    clsSubject subTemp = subBo.getSubjectinfoByCode(subCode);
                    String subName = subTemp.getSubName();
                    String info = classTemp.getClassName() + "-" + subName;
                    listInfomation.add(info);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateScore.class.getName()).log(Level.SEVERE, null, ex);
            error = ex.toString();
        }
        if(listInfomation.size() == 0)
            error += "Không load được dữ liệu";
        else{
            session.setAttribute("listinfomation", listInfomation);
        }
        return error;
    }

    private String ProcessUpdate(HttpServletRequest req){
        String error = "OK";
        int i = 0, n = 0;
        ArrayList<clsStudyResult> listStudyResult = GenratateData(req);
        clsBOStudyResult studyResultBo = new clsBOStudyResult();
        if(listStudyResult != null){
            n = listStudyResult.size();
            for(i = 0; i < n; i++){
                try {                    
                    clsStudyResult rsTemp = listStudyResult.get(i);
                    studyResultBo.Insert(rsTemp);
                } catch (Exception ex) {
                    Logger.getLogger(UpdateScore.class.getName()).log(Level.SEVERE, null, ex);
                    error = ex.toString();
                }
            }
        }
        
        return error;
    }

    private ArrayList<clsStudyResult> GenratateData(HttpServletRequest req){
        ArrayList<clsStudyResult> listResult = new ArrayList<clsStudyResult>();
        HSSFWorkbook wb = GetWorkbook(req);
        ArrayList<String> listInfomation = GetInfo(wb);
        int n = 0, i = 0;
        if(listInfomation.size() > 0)
            n = listInfomation.size();
//MSSV	Họ và tên	Mã môn học	Tên môn học	Điểm giữ kì	Điểm cuối kỳ	 TB Ghi chú
        while(i < n){
            String MSSV = listInfomation.get(i++);
            String FummName = listInfomation.get(i++);
            String SubCode = listInfomation.get(i++);
            String SubName = listInfomation.get(i++);
            String MidleScore = listInfomation.get(i++);
            String LastScore = listInfomation.get(i++);
            String FinalScoreStr = listInfomation.get(i++);
            float FinalScore = Float.parseFloat(FinalScoreStr);
            String Note = listInfomation.get(i++);
            String year = "2010-2011";

            String seminerStr = "20" + MSSV.substring(0, 1);
            int temp = Integer.parseInt(seminerStr);
            Date today = new Date();
            int current = today.getYear();
            int seminer = current - temp;
            seminer = 2;
            clsStudyResult srTemp = new clsStudyResult(MSSV, SubCode, FinalScore, year, seminer);
            listResult.add(srTemp);
        }

        return listResult;
    }

    /**
     * Check excell file in request from client,
     * if there are some file (just check for one until now)
     * then create a new workbook from that data, and return     
     * @param req
     * @return
     */
    private HSSFWorkbook GetWorkbook(HttpServletRequest req){
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if(isMultipart){
            ServletFileUpload upload = new ServletFileUpload();
            FileItemIterator iter;
            String fileNamSource = req.getParameter("filePath");
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
     * Get infomation of student's result in excell file
     * @param wb workbook hold data
     * @return information about student as format:
     */

    private ArrayList<String> GetInfo(HSSFWorkbook wb){
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
                 if(cellType == HSSFCell.CELL_TYPE_ERROR){
                     continue;
                 }
                //STT	MSSV	Họ và tên	Mã môn học	Tên môn học	Điểm giữ kì	Điểm cuối kỳ	 TB Ghi chú

                 for(int j = 1; j < 9; j++){
                     cellTemp = rowTemp.getCell(j);
                     cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
                     strValue = cellTemp.getStringCellValue();
                     listInfo.add(strValue);
                 }
             }
         }
         return listInfo;
    }   
}
