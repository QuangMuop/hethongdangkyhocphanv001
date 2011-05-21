package system.servlets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javax.swing.text.html.parser.DTD;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import system.access.mapper.clsMapperStudyResult;
import system.access.mapper.clsMapperSubject;
import system.bo.clsBORegistration;
import system.bo.clsBOStudent;
import system.bo.clsBOStudyResult;
import system.bo.clsBOSubject;
import system.dto.clsRegistration;
import system.dto.clsStudent;
import system.dto.clsStudyResult;
import system.dto.clsSubject;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="DownloadFile", urlPatterns={"/DownloadFile"})
public class DownloadFile extends HttpServlet {
    int numTc = 0;
   
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
    }

    private String ExportFileListStudentInClass(String ClassName){
        ArrayList<String> listId = new ArrayList<String>();
        ArrayList<String> listFullName = new ArrayList<String>();
        clsBORegistration regBo = new clsBORegistration();
        clsBOStudent studentBo = new clsBOStudent();
        int i = 0;

        try {
            listId = regBo.getListStudentIdFromClassName(ClassName);
            int n = listId.size();
            String idTemp = "";
            String fullNameTemp = "";
            clsStudent studentTemp = null;
            for(i = 0; i < n; i++){
                idTemp = listId.get(i);
                studentTemp = studentBo.getStudentInfoByCode(idTemp);
                fullNameTemp = studentTemp.getFullname();
                listFullName.add(fullNameTemp);
            }
        } catch (Exception ex) {
            Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
        }

         try{
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("DSSV - " + ClassName);
            HSSFCellStyle style = hwb.createCellStyle();
            HSSFRow row1 = null;
            HSSFCell cell1 = null;
            int nrow = 0;

            //Write class's information into file
            row1 = sheet.createRow((short) +(nrow++));
            cell1 = row1.createCell((short) +2);
            cell1.setCellStyle(style);
            cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell1.setCellValue("Danh sách sinh viên lớp " + ClassName);

            row1 = sheet.createRow((short) +(nrow++));
            row1 = sheet.createRow((short) +(nrow++));

            String[] infoClass = {""};
            for(i = 0; i <  infoClass.length; i++){
                row1 = sheet.createRow((short) +(nrow++));
                cell1 = row1.createCell((short) +0);
                cell1.setCellStyle(style);
                cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell1.setCellValue(infoClass[i]);
            }
//Chu nhat sua tiep
            row1 = sheet.createRow((short) +(nrow++));
            row1 = sheet.createRow((short) +(nrow++));
            row1 = sheet.createRow((short) +(nrow++));

            String[] title = {"Mã môn học", "Tên môn học", "Điểm TB"};
            row1 = sheet.createRow((short) +(nrow++));
            for(i = 0; i < title.length; i++){
                cell1 = row1.createCell((short) +i);
                cell1.setCellStyle(style);
                cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell1.setCellValue(title[i]);
            }

            //write score of student into file
//            String subCode;
//            String subName;
//            Float mark;
//            for(i = 0; i < n; i++){
//                clsStudyResult stTemp = listStudyResult.get(i);
//                HSSFRow row = sheet.createRow((short) +(nrow++));
//
//                subCode = stTemp.getSubjectCode();
//                subName = subBo.getSubjectNameByCode(subCode);
//                mark = stTemp.getMark();
//                year = stTemp.getYear();
//                String[] info = {subCode , subName, Float.toString(mark)};
//
//                HSSFCell cell = null;
//                for(int j = 0; j < info.length; j++){
//                    cell = row.createCell((short) +j);
//                    cell.setCellStyle(style);
//                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//                    cell.setCellValue(info[j]);
//                }
//            }

            //style.setFillBackgroundColor(HSSFColor.AQUA.index);
            //style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
            //style.setFillForegroundColor(HSSFColor.AQUA.index);
            //style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

//            FileOutputStream fileOut = new FileOutputStream("BD" + mssv +".xls");
//            hwb.write(fileOut);
//            fileOut.close();
//            DownloadFile("BD" + mssv +".xls", resp);
//            result = "Tao file thanh cong";
        }
        catch (Exception ex){
            //result = ex.toString();
        }

        return null;
    }

    /**
     * export student's result to an excell file
     * @param req
     * @param resp
     * @param mssv Id of student
     * @return string descript the result
     * @throws Exception
     */
    private String ExportFileStudentScoreTable(HttpServletRequest req, HttpServletResponse resp, String mssv) throws Exception{
        String result = "";
        clsBOStudyResult srBo = new clsBOStudyResult();
        clsBOStudent studentBo = new clsBOStudent();
        clsBOSubject subBo = new clsBOSubject();
        clsStudent student = new clsStudent();
        ArrayList<clsStudyResult> listStudyResult = new ArrayList<clsStudyResult>();

        student = studentBo.getStudentInfoByCode(mssv);
        String year = (String) req.getParameter("year");
        year = (String) req.getAttribute("year");
        listStudyResult = srBo.GetListStudyResult(mssv, year);

        //Init file on server
        try{
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("Bang Diem SV " + mssv);
            HSSFCellStyle style = hwb.createCellStyle();

            boolean done = false;
            int nrow = 0, i = 0;
            int n = listStudyResult.size();

            String[] infoStudent = {"Họ Và Tên" + student.getFullname(),
                                    "MSSV: " + student.getCode(),
                                    "Số TC Da tich luy: " + numTc,
                                    "Diểm TB: " + DTB(mssv)};

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

            String[] title = {"Mã môn học", "Tên môn học", "Điểm TB"};
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
            for(i = 0; i < n; i++){
                clsStudyResult stTemp = listStudyResult.get(i);
                HSSFRow row = sheet.createRow((short) +(nrow++));

                subCode = stTemp.getSubjectCode();
                subName = subBo.getSubjectNameByCode(subCode);                
                mark = stTemp.getMark();
                year = stTemp.getYear();            
                String[] info = {subCode , subName, Float.toString(mark)};

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

            FileOutputStream fileOut = new FileOutputStream("BD" + mssv +".xls");
            hwb.write(fileOut);
            fileOut.close();
            DownloadFile("BD" + mssv +".xls", resp);
            result = "Tao file thanh cong";
        }
        catch (Exception ex){
            result = ex.toString();
        }
        return result;
    }

    private float DTB(String mssv){
        float result = 0;
        numTc = 0;
        ArrayList<clsStudyResult> studyResult = new ArrayList<clsStudyResult>();
        
        try {
            clsMapperStudyResult studyMapper = new clsMapperStudyResult();
            clsMapperSubject subMapper = new clsMapperSubject();
            clsSubject subTemp = null;
            clsStudyResult srTemp = null;
            
            studyResult = studyMapper.GetListStudyResult(mssv, "all");
            int n = studyResult.size();
            float[] score = new float[n];
            int[] tc = new int[n];
            
            for(int i = 0; i < n; i++){
                srTemp = studyResult.get(i);
                score[i] = srTemp.getMark();
                subTemp = subMapper.getSubjectinfoByCode(srTemp.getSubjectCode());
                tc[i] = subTemp.getNumTC();
            }
            
            float total = 0;            
            for(int i = 0; i < n; i++){
                numTc += tc[i];
                total += score[i] * tc[i];
            }

            if(numTc != 0)
                result = total/numTc;
        } catch (Exception ex) {
            Logger.getLogger(DownloadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private void DownloadFile(String filename, HttpServletResponse resp){
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
            e.printStackTrace();
        }
    }
}
