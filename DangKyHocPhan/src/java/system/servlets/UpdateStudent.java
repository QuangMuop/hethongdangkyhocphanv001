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
import system.bo.clsBOAccount;
import system.bo.clsBORegistration;
import system.bo.clsBOStudent;
import system.dto.clsAccount;
import system.dto.clsStudent;

/**
 *
 * @author ngloc_it
 */
@WebServlet(name="UpdateStudent", urlPatterns={"/UpdateStudent"})
public class UpdateStudent extends HttpServlet {
   
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
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();

        String functionName = req.getParameter("functionname");
        if(functionName == null)
            functionName = "";

        String result = "";
        if(functionName.equals("update")){
            result = UpdateStudent(req);
        }else if(functionName.equals("delete")){
            result = DeleteStudent(req);
        }else if(functionName.equals("updateaccount")){
            result = UpdateAccount(req);
        }else if(functionName.equals("updatescore")){
            result = UpdateScore(req);
        }
        session.setAttribute("mes", result);

        String path = "./jsps/jspThongBao.jsp";
         resp.sendRedirect(path);
    }

    private String UpdateStudent(HttpServletRequest req){
        String result = "Update student successfull";

        return result;
    }

    /**
     * Delte student by mssv, mssv get from request page
     * @param req
     * @return
     */
    private String DeleteStudent(HttpServletRequest req){
        String result = "";
        String mssv = (String)req.getParameter("mssv");
        if(mssv != null){
            try {
                clsBOAccount accountBo = new clsBOAccount();
                clsBOStudent studentBo = new clsBOStudent();
                clsBORegistration regisBo = new clsBORegistration();
                clsStudent studentdelete = studentBo.getStudentInfoByCode(mssv);

                regisBo.Delete(mssv);
                accountBo.Delete(mssv);
                studentBo.Delete(mssv);

                result = "Delted account " + mssv + "<br/>Delteed " +
                        "student " + studentdelete.getFullname() +
                        "<br/>deleted all his/her registration in database";
            } catch (Exception ex) {
                result = ex.toString();
                Logger.getLogger(UpdateStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }

    private String UpdateAccount(HttpServletRequest req){
        String result = "Update student's account successfull";

        return result;
    }

    private String UpdateScore(HttpServletRequest req){
        String result = "Update student's Score successfull";

        return result;
    }

    //private Update something else
}
