

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
import javax.servlet.http.HttpSession;
import system.bo.clsBOAccount;
import system.bo.clsBOCourse;
import system.bo.clsBOProgram;
import system.dto.clsCourse;


@WebServlet(name="servCourse", urlPatterns={"/servCourse"})
public class servCourse extends HttpServlet {
   
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
        String user=(String) session.getAttribute("username");
        try {
           // if(user==null){
             //   session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
             //    String path = "./jsps/jspThongBao.jsp";
              //  response.sendRedirect(path);
          //  }
          //  else{
                String action=request.getParameter("action");
                if(action.equalsIgnoreCase("view")){
                  ViewAllCourse(response, session);
               }
                else if(action.equalsIgnoreCase("create")){
                CreateCourse(response, session);
                }
                else if(action.equalsIgnoreCase("createcomplete")){
                InsertCoure(request, response, session);
                }

            //}
        } finally { 
            out.close();
        }
    }
    private void InsertCoure(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
       int CourseCode=Integer.parseInt(request.getParameter("courseID"));
       int YearIn=Integer.parseInt(request.getParameter("yearIn"));
       int YearOut=Integer.parseInt(request.getParameter("yearOut"));
       int ProCode=Integer.parseInt(request.getParameter("ProCode"));
       clsCourse cls=new clsCourse(CourseCode, YearIn, YearOut, 0, ProCode);
       clsBOCourse BOC=new clsBOCourse();
       if(BOC.CourseInsert(cls))
           CreateCourse(response, session);
       else {
           session.setAttribute("mes", "Khóa học đã tồn tại, xin kiểm tra lại!");
               String path = "./jsps/jspThongBao.jsp";
              response.sendRedirect(path);
       }
    }
    private void CreateCourse(HttpServletResponse response, HttpSession session) throws Exception{
       clsBOProgram BOP=new clsBOProgram();
       ArrayList<Integer> procode=BOP.getAllProCode();
        session.setAttribute("pro", procode);
         clsBOCourse BOC=new clsBOCourse();
         ArrayList<clsCourse> courselist=BOC.GetAllCorse();
       session.setAttribute("course", courselist);
       String path = "./jsps/jspTaoKhoaHoc.jsp";
       response.sendRedirect(path);

    }
private void ViewAllCourse(HttpServletResponse response, HttpSession session) throws Exception{
    clsBOCourse BOC=new clsBOCourse();
    ArrayList<clsCourse> courselist=BOC.GetAllCorse();
    session.setAttribute("course", courselist);
     String path = "./jsps/jspQuanLyKhoaHoc.jsp";
    response.sendRedirect(path);
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
            Logger.getLogger(servCourse.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servCourse.class.getName()).log(Level.SEVERE, null, ex);
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
