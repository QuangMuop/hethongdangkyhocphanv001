package system.servlets;

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
import system.access.mapper.clsMapperClass;
import system.access.mapper.clsMapperLecturer;
import system.dto.clsClass;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="ViewListClass", urlPatterns={"/ViewListClass"})
public class ViewListClass extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {                        
        String isSearchEngine = (String) req.getParameter("searchengine");
        if(isSearchEngine.equalsIgnoreCase("true")){
            SetDataWithSearchEngine(req, resp);
        }else if(isSearchEngine.equalsIgnoreCase("false")){
            SetDataWithoutSearchEngine(req, resp);
        }
    }

    private void SetDataWithoutSearchEngine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ArrayList<clsClass> listClass = new ArrayList<clsClass>();
        try {
            clsMapperClass classMapper = new clsMapperClass();
            clsMapperLecturer lecturerMapper = new clsMapperLecturer();

        } catch (Exception ex) {
            Logger.getLogger(ViewListClass.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.println("Ko search");
    }

    private void SetDataWithSearchEngine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Co search");
    }
}
