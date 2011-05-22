

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
import system.bo.clsBOSubject;
import system.dto.clsSubject;

@WebServlet(name="servSubject", urlPatterns={"/servSubject"})
public class servSubject extends HttpServlet {
   
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
         String action =request.getParameter("action");
        try {
            if(action.equalsIgnoreCase("view")){
            getAllSubject(response, session);
            }else if(action.equalsIgnoreCase("search")){
                searchSubject(request, response);
            }
            else if(action.equalsIgnoreCase("createcomplete")){
                InsertSubject(request, response, session);
            }
            else if(action.equalsIgnoreCase("edit")){
               editSubject(request, response, session);
            }
            else if(action.equalsIgnoreCase("update")){
                updateSubject(request,response, session);
               
            }
             else if(action.equalsIgnoreCase("delete")){
                predeleteSubject(request, response, session);

            }
            else if(action.equalsIgnoreCase("deletecomplete")){
              deleteSubject(request, response, session);

            }
        } finally {
            out.close();
        }
    }
    private void deleteSubject(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
        String subcode=request.getParameter("subcode");
        clsBOSubject BOS =new clsBOSubject();
       if(BOS.SubjectDeleteByCode(subcode)){
           getAllSubject(response, session);
       }
       else {
            session.setAttribute("mes", "Môn học này không thể xóa vì còn có các thông tin liên quan khác");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
       }
        
    }
   private void predeleteSubject(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
        String subcode=request.getParameter("subcode");
        clsBOSubject BOS=new clsBOSubject();
        clsSubject sub=BOS.getSubjectinfoByCode(subcode);
        session.setAttribute("sub", sub);
        String path = "./jsps/jspXoaMonHoc.jsp";
        response.sendRedirect(path);
    }
    /**
     *
     * @param request
     * @param response
     * @throws Exception
     */
    private void updateSubject(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
     String subname=request.getParameter("txtsubname");
     String subcode=request.getParameter("txtsuncode");
     int numTC=Integer.parseInt(request.getParameter("snumTC"));
     int TCLT=Integer.parseInt(request.getParameter("snumTCLT"));
     int TCTH=Integer.parseInt(request.getParameter("txtTCTH"));
     clsSubject sub=new clsSubject(subname, subcode, numTC, TCLT, TCTH);
     clsBOSubject BOS=new clsBOSubject();
     BOS.updateSubject(sub);
     getAllSubject(response, session);
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void editSubject(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
        String subcode=request.getParameter("subcode");
        clsBOSubject BOS=new clsBOSubject();
        clsSubject sub=BOS.getSubjectinfoByCode(subcode);
        session.setAttribute("sub", sub);
        String path = "./jsps/jspSuaMonHoc.jsp";
             response.sendRedirect(path);
    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void InsertSubject(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
     String subname=request.getParameter("txtsubname");
     String subcode=request.getParameter("txtsuncode");
     int numTC=Integer.parseInt(request.getParameter("snumTC"));
     int TCLT=Integer.parseInt(request.getParameter("snumTCLT"));
     int TCTH=Integer.parseInt(request.getParameter("txtTCTH"));
     clsSubject sub=new clsSubject(subname, subcode, numTC, TCLT, TCTH);
     clsBOSubject BOS=new clsBOSubject();
     if(BOS.SubjectInsert(sub)==1){
           session.setAttribute("mes", "Tên môn học đã tồn tại, xin kiểm tra lại ở danh lớp học");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
     }else if(BOS.SubjectInsert(sub)==2){
         session.setAttribute("mes", "Mã môn học đã tồn tại, xin kiểm tra lại ở danh lớp học");
         String path = "./jsps/jspThongBao.jsp";
         response.sendRedirect(path);
    }
     else {
         getAllSubject(response, session);
     }
    }
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws Exception
     */
    private void searchSubject(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception{
         PrintWriter out = response.getWriter();
        String name=request.getParameter("name");
        clsBOSubject BOS=new clsBOSubject();
        ArrayList<clsSubject> sub=BOS.SearchSubjectByName(name);
        out.println("<tr><th>STT</th><th>Mã môn</th><th>Môn học</th><th>Số TC</th><th>Số TCLT</th><th>Số TCTH</th><th>Sửa</th><th>Xóa</th></tr>");
        for(int i=0;i<sub.size();i++){
          out.println("<tr><td>"+(i+1)+"</td><td>"+sub.get(i).getSubCode()+"</td><td>"+sub.get(i).getSubName()+"</td><td>"+sub.get(i).getNumTC()+"</td><td>"+sub.get(i).getTCLT()+"</td><td>"+sub.get(i).getTCTH()+"</td><td><a href='../servSubject?action=edit&subcode="+sub.get(i).getSubCode()+"'>Sửa</a></td><td><a href='../servSubject?action=delete&subcode="+sub.get(i).getSubCode()+"'>Xóa</a></td></tr>");
        }
    }
/**
 *
 * @param resp
 * @param session
 * @throws Exception
 */
    private void getAllSubject(HttpServletResponse resp, HttpSession session) throws Exception{
        clsBOSubject BOS=new clsBOSubject();
        ArrayList<clsSubject> sublist=BOS.GetListSubject();
        session.setAttribute("sub", sublist);
        String path = "./jsps/jspDanhSachMonHoc.jsp";
        resp.sendRedirect(path);
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
            Logger.getLogger(servSubject.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servSubject.class.getName()).log(Level.SEVERE, null, ex);
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
