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
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import system.bo.clsBOStudent;
import system.dto.clsStudent;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="ViewListStudent", urlPatterns={"/ViewListStudent"})
public class ViewListStudent extends HttpServlet {
       
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
        
        HttpSession session = req.getSession();

        String exportFile = (String) req.getParameter("exportfile");
        if(exportFile == null)
            exportFile = "Not export file";

        try {
             session.removeAttribute("listinfomation");
             session.removeAttribute("exportfile");
        } catch (Exception ex) {
            Logger.getLogger(ViewListStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        String mssv = "";
        String fullName = "";

        String search = (String) req.getParameter("search");     //Yes or no
        String order = (String) req.getParameter("order");       // default = MSSV
        String className = (String) req.getParameter("sSearch");        
        mssv = (String) req.getParameter("txtMSSV");
        fullName = (String) req.getParameter("txtFullName");

        if(className != null){
            session.setAttribute("classnametemp", className);
        }else{
            className = (String) session.getAttribute("classnametemp");
            if(className == null)
                className = "ALL"; //set default
        }

        if(order != null){
            session.setAttribute("ordertemp", order);
        }else{
            order = (String) session.getAttribute("ordertemp");
            if(order == null)
                order = "MSSV";
        }

        if((className!=null && className.equals("ALL") && search.equals("yes")))
            search = "no";

        ArrayList<String> listInfomation = new ArrayList<String>();
        try {
             listInfomation = PrepareData(search, className, order, mssv, fullName);
        } catch (Exception ex) {
            Logger.getLogger(ViewListStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        String path = "./jsps/jspDanhSachSinhVien.jsp";
        session.setAttribute("listinfomation", listInfomation);       

        if(exportFile.equals("true")){
            String err = ExportFile(req, resp, listInfomation);
            session.setAttribute("mes", err);
            path = "jsps/jspThongBao.jsp";
        }

        resp.sendRedirect(path);
    }

    private ArrayList<String> PrepareData(String search, String className, String order, String mssv, String fullName) throws Exception{
        ArrayList<String> listInfomation = new ArrayList<String>();
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        clsBOStudent studentBo = new clsBOStudent();
        if(search.equals("yes")){
            listStudent = studentBo.GetStudentsByClass(className, order);
        }else if(search.equals("no")){
            listStudent = studentBo.GetAllStudent(order);
        }else if(search.equals("frmMSSV")){
            clsStudent student = new clsStudent();
            student = studentBo.getStudentInfoByCode(mssv);
            if(student != null)
                listStudent.add(student);
        }else if(search.equals("frmFullName")){
            clsStudent student = new clsStudent();
            student = studentBo.getStudentInfoByName(fullName);
            if(student != null)
                listStudent.add(student);
        }

        int n = listStudent.size();
        int i = 0;
        //Fullname, MSSV, BirthDay, ClassName, Email, Phone, Address,Home,
        //IsStudying, courseCode, NhapHoc, gender, CMND, Type, Bac hoc, Note
        for(i = 0; i < n; i++){
            clsStudent studentTemp = listStudent.get(i);
            listInfomation.add(studentTemp.getFullname());
            listInfomation.add(studentTemp.getCode());
            listInfomation.add(studentTemp.getBirthDay());
            listInfomation.add(studentTemp.getClasss());
            listInfomation.add(studentTemp.getEmail());
            listInfomation.add(studentTemp.getPhone());
            listInfomation.add(studentTemp.getAddress());
            listInfomation.add(studentTemp.getHome());
            listInfomation.add(studentTemp.getIsStuding());
            listInfomation.add(Integer.toString(studentTemp.getCourse()));
            listInfomation.add(studentTemp.getNhaphoc());
            listInfomation.add(studentTemp.getGender());
            listInfomation.add(studentTemp.getCMND());
            listInfomation.add(studentTemp.getType());
            listInfomation.add(studentTemp.getBacHoc());
            listInfomation.add(studentTemp.getNote());
        }
        return listInfomation;
    }

    /**
     * Export list student to excell file, save it
     * on server side
     * @param req
     */
    private String ExportFile(HttpServletRequest req, HttpServletResponse resp, ArrayList<String> listInfo){
        String result = "";
        try{
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("DS Sinh Vien");
            HSSFCellStyle style = hwb.createCellStyle();

            boolean done = false;
            int count = 0;
            int j = 0;
            int n = listInfo.size();
            while(j < n){
                HSSFRow row = sheet.createRow((short) +(count++));
                HSSFCell cell = null;
                for(int i = 0; i < 16 && j<n; i++){
                    cell = row.createCell((short) +i);
                    cell.setCellStyle(style);
                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    String test = listInfo.get(j++);
                    cell.setCellValue(test);
                }
            }

            style.setFillBackgroundColor(HSSFColor.AQUA.index);
            style.setFillPattern(HSSFCellStyle.BIG_SPOTS);
            style.setFillForegroundColor(HSSFColor.AQUA.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

            FileOutputStream fileOut = new FileOutputStream("DS.xls");
            hwb.write(fileOut);
            fileOut.close();
            DownloadFile("DS.xls", resp);
            result = "Tao file thanh cong";
        }
        catch (Exception ex){
            result = ex.toString();
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
