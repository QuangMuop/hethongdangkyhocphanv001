

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
import system.bo.clsBODetailResult;
import system.bo.clsBOStudent;
import system.dto.clsStudent;
import system.dto.clsStudyResult;
import system.bo.clsBOStudyResult;
import system.dto.clsDetailResult;
@WebServlet(name="servStudyResult", urlPatterns={"/servStudyResult"})
public class servStudyResult extends HttpServlet {
   
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
        try {
            String login=(String) session.getAttribute("username");
            login = "07520319";
            if(login==null){
             session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
            }
            else {
                String first=request.getParameter("first");
                if(first.equalsIgnoreCase("true"))
                    getStudyResult(response, session,login);
                else if(first.equalsIgnoreCase("false")){
                   reloadResult(request, response, session, login);
                    
                }
               }
            
          
        } finally { 
            out.close();
        }
    } 
private void getStudyResult( HttpServletResponse response,HttpSession session, String user) throws Exception{
              clsBOStudyResult BOS=new clsBOStudyResult();
              ArrayList<clsStudyResult> sr=BOS.getYear(user);
              session.setAttribute("year", sr);
              clsBOStudent BOStudent=new clsBOStudent();
              clsStudent student =new clsStudent();
              student=BOStudent.getStudentInfoByCode(user);
              session.setAttribute("student", student);
              clsBODetailResult BOResult=new clsBODetailResult();
              ArrayList<clsDetailResult> result=BOResult.getResult(user,"All",0);
              session.setAttribute("result", result);
              String path = "./jsps/jspXemKQHocTap.jsp";
               response.sendRedirect(path);
}
private void reloadResult(HttpServletRequest request, HttpServletResponse response,HttpSession session, String user) throws Exception{{
              int numTC=0;
              float SumMark=0;
              float Average=0;
              PrintWriter out = response.getWriter();
              String year=request.getParameter("year");
              int semester=Integer.parseInt(request.getParameter("semester"));
              clsBODetailResult BOResult=new clsBODetailResult();
              ArrayList<clsDetailResult> result=BOResult.getResult(user,year,semester);
              out.println("<tr><th width='100px'>Năm học</th><th width='70px'>Học kỳ</th><th width='100px'>Mã môn</th><th width='300px'>Tên môn học</th><th width='70px'>Số TC</th><th width='80px'>Điểm</th><th width='100px'>Nhân hệ số</th></tr>");
              for(int i=0;i<result.size();i++){
              out.println("<tr><td>"+result.get(i).getYear()+"</td><td>"+result.get(i).getSemester()+"</td><td>"+result.get(i).getSubCode()+"</td><td>"+result.get(i).getSubName()+"</td><td>"+result.get(i).getNumTC()+"</td><td>"+result.get(i).getMark()+"</td><td>"+result.get(i).getNumTC()*result.get(i).getMark()+"</td></tr>");
              numTC+=result.get(i).getNumTC();
              SumMark+=(result.get(i).getNumTC()*result.get(i).getMark());
              Average=(float)Math.round(SumMark*100/numTC)/100;
              }
              out.println("<tr><td><h1>Tổng kết</h1></td><td></td><td></td><td><h1>Trung bình: "+ Average +"</h1></td><td><h1>"+numTC+"</h1></td><td></td><td><h1>"+SumMark+"</h1></td></tr>");
           }
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
            Logger.getLogger(servStudyResult.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servStudyResult.class.getName()).log(Level.SEVERE, null, ex);
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
