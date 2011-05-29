

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
import system.dto.clsAccount;


@WebServlet(name="servAccount", urlPatterns={"/servAccount"})
public class servAccount extends HttpServlet {
   
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
            if(user==null){
                session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập!");
                 String path = "./jsps/jspThongBao.jsp";
                response.sendRedirect(path);
            }else{
               String action=request.getParameter("action");
                if(action.equalsIgnoreCase("view")){
                    if(BOA.getAccountType(user)==1)
                      getAllAccount(response, session);
                    else {
                        session.setAttribute("mes", "Để xem trang này bạn phải đăng nhập bằng tài khoản quản lý!");
                 String path = "./jsps/jspThongBao.jsp";
                response.sendRedirect(path);
                    }
                    
               }
                else if(action.equalsIgnoreCase("search")){
                    searchAccount(request, response);
               }
                else if(action.equalsIgnoreCase("update")){
                    UpdateAccount(request, response, session);
               }
               else if(action.equalsIgnoreCase("create")){
               createAccount(request, response, session);
               }
            }
            
        } finally { 
            out.close();
        }
    }
    private void createAccount(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
        String username=request.getParameter("txtusername");
        String pass=request.getParameter("txtpass");
        String fullname=request.getParameter("txtname");
        int type=Integer.parseInt(request.getParameter("txttype"));
        clsBOAccount BOA=new clsBOAccount();
        clsAccount cls=new clsAccount(username, pass, fullname, 0, 0, type);
        if(BOA.Insert(cls))
        getAllAccount(response, session);
        else {
             session.setAttribute("mes", "Tạo tài khoản thất bại vì tên đăng nhập đã tồn tại!");
             String path = "./jsps/jspThongBao.jsp";
             response.sendRedirect(path);
        }

    }
    /**
     *
     * @param request
     * @param response
     * @param session
     * @throws Exception
     */
    private void UpdateAccount(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
        String username=request.getParameter("username");
        clsBOAccount BOA =new clsBOAccount();
        BOA.UpdateStatus(username);
        getAllAccount(response, session);
    }
    /**
     *
     * @param request
     * @param response
     * @throws Exception
     */
    private void searchAccount(HttpServletRequest request, HttpServletResponse response) throws Exception{
         PrintWriter out = response.getWriter();
        String username=request.getParameter("username");
        clsBOAccount BOA=new clsBOAccount();
        ArrayList<clsAccount> AccountList=BOA.SearchAcByUser(username);
        out.println("<tr> <th>STT</th><th>Tên đăng nhập</th><th>Họ Tên</th><th>Hiện trạng</th><th>Loại</th><th>Cập nhật</th></tr>");
        for(int i=0;i<AccountList.size();i++){
             StringBuffer str = new StringBuffer();
            str.append("<tr><td>"+(i+1)+"</td><td>"+AccountList.get(i).getUserName()+"</td>");
            str.append("<td>"+AccountList.get(i).getFullName()+"</td>");
            if(AccountList.get(i).getIsLocked()==0)
            str.append("<td>Bình thường</td>");
            else
            str.append("<td>Đang khóa</td>");
            if(AccountList.get(i).getType()==1)
            str.append("<td>Quản lý</td>");
           else
            str.append("<td>Sinh viên</td>");
            if(AccountList.get(i).getIsLocked()==1)
              str.append("<td><a href='../servAccount?action=update&username="+AccountList.get(i).getUserName()+"' >Mở khóa</a></td>");
            else
            str.append("<td><a href='../servAccount?action=update&username="+AccountList.get(i).getUserName()+"' >Khóa</a></td>");
            out.println(str.toString());
          }
    }
private void getAllAccount(HttpServletResponse response, HttpSession session) throws Exception{
    clsBOAccount BOA=new clsBOAccount();
    ArrayList<clsAccount> AccountList=BOA.getAllAccout();
    session.setAttribute("acc", AccountList);
    String path = "./jsps/jspCapNhatTaiKhoan.jsp";
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
            Logger.getLogger(servAccount.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servAccount.class.getName()).log(Level.SEVERE, null, ex);
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
