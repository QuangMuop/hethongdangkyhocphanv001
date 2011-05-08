package system.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String function = (String)req.getParameter("function");

        if(function.equals("addone")){
            AddOne(req, session);
        }else if(function.equals("addlist")){
            AddList(req, session);
        }else{
            out.println("Sorry you");
        }
    }

    private void AddOne(HttpServletRequest req, HttpSession session){
        
//        <td>MSSV</td> <td><input type="text" name="txtMSSV"></td>
//                            <td>Họ</td> <td><input type="text" name="txtFirstName"></td>
//                            <td>Tên</td> <td><input type="text" name="txtLastName"></td>
//                                <select name="sDay">
//                                <select name="sMonth">
//                                <select name="sYear">
//                            <select name="sClass">
//                                <select name="sSex">
//                            <td>Địa chỉ thường trú</td> <td><input type="text" name="txtThuongTru"></td>
//                            <td>Địa chỉ tạm trú</td> <td><input type="text" name="txtTamTru"></td>
//                            <td>Điện thoại</td> <td><input type="text" name="txtPhoneNumber"></td>
//                            <td>Email</td> <td><input type="text" name="txtEmail"></td>
//                                <select name="sCourse">
    }

    private void AddList(HttpServletRequest req, HttpSession session){
        
    }
}
