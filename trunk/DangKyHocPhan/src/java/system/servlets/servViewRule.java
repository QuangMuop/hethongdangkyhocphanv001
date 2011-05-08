
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
import system.bo.clsBORule;
import system.dto.clsRule;


@WebServlet(name="servViewRule", urlPatterns={"/servViewRule"})
public class servViewRule extends HttpServlet {
   
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String issetup = (String) request.getParameter("issetup");
        try {
            if(issetup.equalsIgnoreCase("false")){//xem qui định
            getRule(session,response);
            }
            else if(issetup.equalsIgnoreCase("true")){//sửa qui định
             UpdateRule(request, response,session);
            
            }
        } finally { 
            out.close();
        }
    } 

   private void getRule(HttpSession session,HttpServletResponse response) throws Exception{
       clsRule rule=new clsRule();
       clsBORule BORuler=new clsBORule();
       rule=BORuler.getRuleInfo();
       session.setAttribute("rule", rule);
       String path = "./jsps/jspXemQuiDinh.jsp";
       response.sendRedirect(path);
   }

   /**
    *
    * @param request
    * @param response
    * @throws Exception
    */
   private void UpdateRule(HttpServletRequest request,HttpServletResponse response,HttpSession session ) throws Exception{
            PrintWriter out = response.getWriter();
            int MaxStudentAge=Integer.parseInt(request.getParameter("sTuoiSVToiDa"));
            int MinStudentAge=Integer.parseInt(request.getParameter("sTuoiSVToiThieu"));
            int MaxLecturerAge=Integer.parseInt(request.getParameter("sTuoiGVToiDa"));
            int MinLecturerAge=Integer.parseInt(request.getParameter("sTuoiGVToiThieu"));
            int MaxTC=Integer.parseInt(request.getParameter("sTCToiDa"));
            int MinTC=Integer.parseInt(request.getParameter("sTCToiThieu"));
            int MaxNumOfStudent=Integer.parseInt(request.getParameter("sSVToiDaLop"));
            int MinNumOfStudent=Integer.parseInt(request.getParameter("sSVToiThieuLop"));
            float MarkPass=Float.parseFloat(request.getParameter("sDiem"));
            clsRule rule=new clsRule(MaxTC, MinTC, MaxStudentAge, MinStudentAge, MaxNumOfStudent, MinNumOfStudent, MarkPass, MaxLecturerAge, MinLecturerAge);
            clsBORule BORule=new clsBORule();
            BORule.updateRule(rule);
             getRule(session,response);
             String path = "./jsps/jspXemQuiDinh.jsp";
             response.sendRedirect(path);
   }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(servViewRule.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(servViewRule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
