/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.access.mapper.*;
import system.bo.clsBOLecturer;
import system.dto.*;

/**
 *
 * @author Ultimate
 */
@WebServlet(name="servTest", urlPatterns={"/servTest"})
public class servTest extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         HttpSession session = request.getSession();
         String isupdate = request.getParameter("isupdate");
        try {
           if(isupdate.equalsIgnoreCase("false")){//Xem thông tin sinh viên
              clsMapperStudent mps=new clsMapperStudent();
              clsStudent cls=mps.getStudentInfoByCode("07520319");
              out.println(cls.getAddress());
            }
       } finally { 

            out.close();
        }
                   // String path = "./jsps/jspTrangChu.jsp";
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        //requestDispatcher.forward(req, resp);
                  //  response.sendRedirect(path);
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(servTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(servTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
