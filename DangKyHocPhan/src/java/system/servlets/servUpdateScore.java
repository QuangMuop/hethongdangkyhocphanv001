
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
import system.bo.clsBOClass;
import system.bo.clsBOStudyResult;
import system.dto.clsClass;
import system.dto.clsStudent;
import system.dto.clsStudyResult;
import system.utilities.SystemProperities;

/**
 *
 * @author Ultimate
 */
@WebServlet(name = "servUpdateScore", urlPatterns = {"/servUpdateScore"})
public class servUpdateScore extends HttpServlet {

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
               if(action.equalsIgnoreCase("manage")) {
                 if(BOA.getAccountType(login)==1)
                     getAllClass(response, session);
                else{
                      session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập với tài khoản quản lý!");
                  String path = "./jsps/jspThongBao.jsp";
                response.sendRedirect(path);
                }
               }
               else  if(action.equalsIgnoreCase("lecturer")) {
                 if(BOA.getAccountType(login)==2)
                     getAllClass(response, session);
                else{
                      session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập với tài khoản giảng viên!");
                  String path = "./jsps/jspThongBao.jsp";
                response.sendRedirect(path);
                }
               }
               else if(action.equalsIgnoreCase("update")) {
                   updateSocre(request, response, session);
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
    private void updateSocre(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, FileUploadException, Exception{
       String subcode;
        HSSFWorkbook wb=GetWorkbook(request, response);
         int i = 0;
        ArrayList<String> StudyInfo;
        int n = wb.getNumberOfSheets();

         for (int k = 0; k < n; k++){
             HSSFSheet sheet = wb.getSheetAt(k);
             int rows  = sheet.getPhysicalNumberOfRows();

             HSSFRow rowTemp;
             HSSFCell cellTemp;
             int cellType;
             String strValue = "";
             //lấy mã môn học
              HSSFRow rowsubcode=  sheet.getRow(3);
              HSSFCell cellsubcode=rowsubcode.getCell(1);
               cellsubcode.setCellType(HSSFCell.CELL_TYPE_STRING);
               subcode = cellsubcode.getStringCellValue();
             for (i = 0; i < rows; i++){
                 StudyInfo=new ArrayList<String>();
                 rowTemp = sheet.getRow(i);
                 cellTemp = rowTemp.getCell(0);
                 cellType = cellTemp.getCellType();
                 //check the first cell of data must be a number
                 if(cellType != HSSFCell.CELL_TYPE_NUMERIC){
                     continue;
                 }
                 //CELL 1 MSSV
                //CELL2 Ho tên
                //CELL3 Diem
                 for(int j = 2; j < 4; j++){
                     cellTemp = rowTemp.getCell(j);
                    cellTemp.setCellType(HSSFCell.CELL_TYPE_STRING);
                    strValue = cellTemp.getStringCellValue();
                  StudyInfo.add(strValue);
                 }
                clsStudyResult cls=new clsStudyResult(StudyInfo.get(0), subcode, Float.parseFloat(StudyInfo.get(1)), SystemProperities.CurentYear, SystemProperities.Curentsemester);
                clsBOStudyResult BOS=new clsBOStudyResult();
                BOS.Insert(cls);
                
                
             }
             session.setAttribute("mes", "Ghi nhận điểm hoàn tất!");
                String path = "./jsps/jspThongBao.jsp";
               response.sendRedirect(path);
         }
         
    }
    /**
     * 
     * @param resp
     * @param session
     * @throws IOException
     * @throws Exception 
     */
private void getAllClass(HttpServletResponse resp, HttpSession session) throws IOException, Exception{
             clsBOClass BOClass=new clsBOClass();
             ArrayList<clsClass> result=BOClass.GetAllClass("ClassName");
             session.setAttribute("clases", result);
             String path = "./jsps/jspGhiNhanDiem.jsp";
             resp.sendRedirect(path);
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
            Logger.getLogger(servUpdateScore.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servUpdateScore.class.getName()).log(Level.SEVERE, null, ex);
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
