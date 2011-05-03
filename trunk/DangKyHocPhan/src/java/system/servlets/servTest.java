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
import system.access.mapper.*;
import system.dto.*;

/**
 *
 * @author Ultimate
 */
@WebServlet(name="servTest", urlPatterns={"/servTest"})
public class servTest extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           String Username=request.getParameter("txtUsername");
            String Password=request.getParameter("txtPassword");
            clsLecturer cls=new clsLecturer();
            clsMapperLecturer mpc=new clsMapperLecturer();
           cls= mpc.getLecturerInfo(Username);
            out.println(cls.getAddress());
                    } finally { 
            out.close();
        }
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
