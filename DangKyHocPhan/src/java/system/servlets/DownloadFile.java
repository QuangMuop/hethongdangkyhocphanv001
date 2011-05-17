package system.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="DownloadFile", urlPatterns={"/DownloadFile"})
public class DownloadFile extends HttpServlet {
   
   
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
        try{            
            String filename = req.getParameter("filename");
            resp.reset();
            resp.setContentType("application/xls");
            resp.setHeader("Content-disposition","attachment; filename=" +filename);

            FileInputStream in = new FileInputStream(filename);
            byte[] buf = new byte[1024];            
            int len, i;
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
