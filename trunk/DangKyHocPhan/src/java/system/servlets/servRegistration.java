
package system.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import system.bo.clsBOClass;
import system.bo.clsBORegistration;
import system.bo.clsBOStudent;
import system.dto.clsClass;
import system.dto.clsRegistration;
import system.dto.clsStudent;
import system.utilities.SystemProperities;

@WebServlet(name="servRegistration", urlPatterns={"/servRegistration"})
public class servRegistration extends HttpServlet {
   
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    String[] registry;
    String login;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        try {
            //session.setAttribute("username", "07520319");
            login=(String) session.getAttribute("username");
            if(login==null){
             session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
            }
            else {
                String first=request.getParameter("reg");
                if(first.equalsIgnoreCase("view")){
                   forward(request, response, session);
                } else if(first.equalsIgnoreCase("registry")){
                    registry(request, response, session);
             }
                else if(first.equalsIgnoreCase("reset")){
                   getAllClass(request, response, session);
                }
                else if(first.equalsIgnoreCase("complete")){
                    completeReg(login,response, session);
                }
            }


        } finally {
            out.close();
        }
    }
    private void forward(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws Exception{
       clsRegistration cls=new clsRegistration(login, "", SystemProperities.Curentsemester, SystemProperities.CurentYear, 0);
       clsBORegistration BOreg=new clsBORegistration();
       ArrayList<String> reged=BOreg.getRegistrationInfo(cls);
       if(reged.isEmpty()){
           getAllClass(req, resp, session);
       }else{
               showreg(reged, req, resp, session);
       }
    }
     /**
     * 
     * @param username
     * @throws Exception
     */
    private void completeReg(String username,HttpServletResponse resp, HttpSession session) throws Exception{
        clsBORegistration BOReg=new clsBORegistration();
        BOReg.deleteAll(username, SystemProperities.Curentsemester, SystemProperities.CurentYear);
        int n=registry.length;
        for(int i=0;i<n;i++){
            clsRegistration temp=new clsRegistration(username, registry[i], SystemProperities.Curentsemester, SystemProperities.CurentYear, 0);
            BOReg.insert(temp);
        }
            session.setAttribute("mes", "Đăng ký thành công!");
             String path = "./jsps/jspThongBao.jsp";
             resp.sendRedirect(path);
    }
    /**
     *
     * @param req
     * @param resp
     * @param session
     * @throws IOException
     * @throws Exception
     */
    private void registry(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException, Exception{
        registry=req.getParameterValues("check");
        if(req.getParameterValues("check")==null){
            getAllClass(req, resp, session);
        }else{
        int n=registry.length;
        ArrayList<clsClass> reg=new ArrayList<clsClass>();
        clsClass temp=new clsClass();
        clsBOClass BOC=new clsBOClass();
        for(int i=0; i<n; i++){
            temp=BOC.getClassFromId(registry[i]);
            reg.add(temp);
        }
        session.setAttribute("reg", reg);
        String path = "./jsps/jspPreviewRegistry.jsp";
        resp.sendRedirect(path);
        }
     }
    /**
     *
     * @param req
     * @param resp
     * @param session
     * @throws IOException
     * @throws Exception
     */
private void getAllClass(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException, Exception{
             clsBOStudent BOStudent=new clsBOStudent();
             clsStudent student=BOStudent.getStudentInfoByCode(login);
             session.setAttribute("student", student);
             session.setAttribute("time", "Học kỳ "+SystemProperities.Curentsemester +" năm học "+SystemProperities.CurentYear);
             clsBOClass BOClass=new clsBOClass();
             ArrayList<clsClass> result=BOClass.GetAllClass("ClassName");
             session.setAttribute("clases", result);
             String path = "./jsps/jspDangKyMonHoc.jsp";
             resp.sendRedirect(path);
    }
 private void showreg(ArrayList<String> reged,HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException, Exception{
        int n=reged.size();
        ArrayList<clsClass> reg=new ArrayList<clsClass>();
        clsClass temp=new clsClass();
        clsBOClass BOC=new clsBOClass();
        for(int i=0; i<n; i++){
            temp=BOC.getClassFromId(reged.get(i));
            reg.add(temp);
        }
        session.setAttribute("reg", reg);
        String path = "./jsps/jspPreviewRegistry.jsp";
        resp.sendRedirect(path);
      }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            Logger.getLogger(servRegistration.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
