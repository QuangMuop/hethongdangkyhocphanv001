/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.access.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import system.dto.*;
/**
 *
 * @author Ultimate
 */
public class clsMapperAccount extends clsMapperDb {

    /**
     * Constructor
     * @throws Exception
     */
    public clsMapperAccount() throws Exception{
        super();
    }

    /**
     * This function initial an accountDTO object.
     * Data get from a result set
     * @param accountDTO Object creasted
     * @param rs source
     * @throws Exception
     */
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
    public int CountNumAccount() throws Exception{
        int Result =0;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("select COUNT(UserName) as Num from dangkyhocphan.accounts");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                Result=Integer.parseInt(rs.getString("Num"));
            }
        }catch(Exception ex){
            throw ex;
        }
        return Result;
    }
    public int CountNumAccountByUser(String UserName) throws Exception{
        int Result =0;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("select COUNT(UserName) as Num from dangkyhocphan.accounts where UserName like'");
            sql.append(UserName).append("%'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                Result=Integer.parseInt(rs.getString("Num"));
            }
        }catch(Exception ex){
            throw ex;
        }
        return Result;
    }
    public ArrayList<clsAccount> getAllAccount() throws Exception{
          ArrayList<clsAccount> listResult = new ArrayList<clsAccount>();
         try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select DISTINCT * from dangkyhocphan.accounts");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsAccount classTemp = new clsAccount();
                InitAccountDTOFromRs(classTemp, rs);
                listResult.add(classTemp);
            }
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
    }
    public ArrayList<clsAccount> getAllAccountWithLimmit(int start, int limmit) throws Exception{
          ArrayList<clsAccount> listResult = new ArrayList<clsAccount>();
         try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select DISTINCT * from dangkyhocphan.accounts LIMIT "+start+","+limmit+"");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsAccount classTemp = new clsAccount();
                InitAccountDTOFromRs(classTemp, rs);
                listResult.add(classTemp);
            }
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
    }
    public ArrayList<clsAccount> SearchAccByUser(String username) throws Exception{
          ArrayList<clsAccount> listResult = new ArrayList<clsAccount>();
         try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select DISTINCT * from dangkyhocphan.accounts where UserName like'");
            sql.append(username).append("%'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsAccount classTemp = new clsAccount();
                InitAccountDTOFromRs(classTemp, rs);
                listResult.add(classTemp);
            }
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
    }
    public ArrayList<clsAccount> SearchAccByUserWithLimmit(String username,int start, int limmit) throws Exception{
          ArrayList<clsAccount> listResult = new ArrayList<clsAccount>();
         try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select DISTINCT * from dangkyhocphan.accounts where UserName like'");
            sql.append(username).append("%' LIMIT "+start+","+limmit+"");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsAccount classTemp = new clsAccount();
                InitAccountDTOFromRs(classTemp, rs);
                listResult.add(classTemp);
            }
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
    }
    /**
     * 
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public boolean  AccountLogin(String username, String password)throws Exception{
        boolean result=false;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT UserName, Passwords FROM dangkyhocphan.ACCOUNTS WHERE username=? and passwords=? ");
            //sql.append(" username = '").append(username).append("'");
           // sql.append(" and passwords = '").append(password).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.setString(1, username);
            stmt.setString(2, password);
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

    /**
     *
     * @param username
     * @return
     * @throws Exception
     */
    public boolean AccountCheckLogin(String username) throws Exception{
        int login=0;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT IsLogin FROM dangkyhocphan.ACCOUNTS WHERE ");
            sql.append(" username = '").append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();

            while ((rs != null) && (rs.next())) {
                login = Integer.parseInt(rs.getString("IsLogin"));
            }
            stmt.close();
        }catch(Exception ex){
            throw ex;
        }
        if(login==1)
            return true;
        else return false;
    }
    /**
     * 
     * @param username
     * @return
     * @throws Exception
     */
    public boolean AccountCheckLock(String username) throws Exception{
        int lock=0;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT IsLocked FROM dangkyhocphan.ACCOUNTS WHERE ");
            sql.append(" username = '").append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();

            while ((rs != null) && (rs.next())) {
                lock = Integer.parseInt(rs.getString("IsLocked"));
            }
            stmt.close();
        }catch(Exception ex){
            throw ex;
        }
        if(lock==1)
            return true;
        else return false;
    }
   /**
     *
     * @param username
     * @return
     * @throws Exception
     */
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
    
    /**
     * 
     * @param account
     * @throws Exception
     */
    public boolean  AccountInsert(clsAccount account) throws Exception{
        if(AccountCheckExits(account.getUserName())) return false;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("insert INTO dangkyhocphan.accounts values('");
            sql.append(account.getUserName()).append("','");
            sql.append(account.getPassWord()).append("','");
            sql.append(account.getFullName()).append("',");
            sql.append(account.getIsLocked()).append(",");
            sql.append(account.getLogin()).append(",");
            sql.append(account.getType()).append(")");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
            return true;
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * 
     * @param username
     * @return
     * @throws Exception
     */
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

    /**
     * 
     * @param username
     * @throws Exception
     */
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

    /**
     *
     * @param username
     * @param password
     * @throws Exception
     */
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
    
    /**
     *
     * @param username
     * @throws Exception
     */
    public void AccountUpdateLogin(String username) throws Exception{
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("update dangkyhocphan.accounts set IsLogin=(IsLogin+1)%2 where UserName='");
            sql.append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
            throw ex;
        }
    }

    /**
     *
     * @param username
     * @param islocked
     * @throws Exception
     */
    public void AccoutUpdateStatus(String username) throws Exception{
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("update dangkyhocphan.accounts set IsLocked=(IsLocked+1)%2 where UserName='").append(username).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            boolean execute = stmt.execute();
        }catch(Exception ex){
            throw ex;
        }
    }
}
