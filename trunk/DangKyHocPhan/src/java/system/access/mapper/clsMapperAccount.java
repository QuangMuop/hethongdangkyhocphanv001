/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.access.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import system.dto.*;
/**
 *
 * @author Ultimate
 */
public class clsMapperAccount extends clsMapperDb {
    public clsMapperAccount() throws Exception{
        super();
    }
     private void InitAccountDTOFromRs(clsAccount accountDTO, ResultSet rs) throws Exception{
        if((rs!=null) && (accountDTO!=null)){
            accountDTO.setFullName(rs.getString("FullName"));
            accountDTO.setPassWord(rs.getString("Passwords"));
            accountDTO.setUserName(rs.getString("UserName"));
            accountDTO.setIsLocked(Integer.parseInt(rs.getString("Islocked")));
            accountDTO.setIsLogin(Integer.parseInt(rs.getString("IsLogin")));
            accountDTO.setType(Integer.parseInt(rs.getString("Type")));
         }
    }
    public boolean  AccountLogin(String username, String password)throws Exception{
        boolean result=false;
        try{
            StringBuffer sql = new StringBuffer();
           sql.append("SELECT UserName, Passwords FROM dangkyhocphan.ACCOUNTS WHERE ");
            sql.append(" username = '").append(username).append("'");
            sql.append(" and passwords = '").append(password).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if ((rs != null) && (rs.next())) {
                result = true;
            }
            stmt.close();
        }catch(Exception ex){
            throw ex;
        }
        return result;
    }
    public clsAccount getAccountInfo(String username) throws Exception{
        clsAccount accountDTO=new clsAccount();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.accounts Where");
            sql.append(" username = '").append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                InitAccountDTOFromRs(accountDTO, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return accountDTO;
    }
    public void AccountInsert(clsAccount account) throws Exception{
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.accounts values( ");
            sql.append("'").append(account.getUserName()).append("', ");
            sql.append("'").append(account.getPassWord()).append("', ");
            sql.append("'").append(account.getFullName()).append("', ");
            sql.append(account.getIsLocked()).append(", ");
            sql.append(account.getLogin()).append(", ");
            sql.append(account.getType()).append(") ");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
    }
public boolean AccountCheckExits(String username) throws Exception{
    boolean result = false;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.accounts Where username = '").append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && (rs.next()))
                result = true;
            stmt.close();
        }catch(Exception ex){
                throw ex;
        }
        return result;
}
public void AccountDelete(String username) throws Exception{
    try{
    StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.accounts Where username = '").append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
}
public void AccountChangePass(String username, String password) throws Exception{
         try{
            StringBuffer sql = new StringBuffer();
            sql.append("update dangkyhocphan.accounts set passwords='").append(password).append("' Where username = '").append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
   }
public void AccountUpdateLogin(String username) throws Exception{
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select IsLogin from dangkyhocphan.Accounts Where username = '").append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
             ResultSet rs=stmt.executeQuery();
            int login=Integer.parseInt(rs.getString("IsLogin"));
            sql=new StringBuffer();
            if(login==0)
                sql.append("Update dangkyhocphan.Accounts set IsLogin=1 where UserName='").append(username).append("'");
            else
                sql.append("Update dangkyhocphan.Accounts set IsLogin=0 where UserName='").append(username).append("'");
             stmt = getConnection().prepareStatement(sql.toString());
            boolean execute = stmt.execute();
;
        }catch(Exception ex){
                throw ex;
        }
}
public void AccoutUpdateStatus(String username, int islocked) throws Exception{
     try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.accounts set IsLocked='").append(islocked).append("' Where username = '").append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            boolean execute = stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
}

}
