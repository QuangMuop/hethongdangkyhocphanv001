package system.bo;
import java.util.ArrayList;
import system.access.mapper.clsMapperAccount;
import system.dto.clsAccount;
public class clsBOAccount {

    public void UpdateStatus(String username) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        mpa.AccoutUpdateStatus(username);
    }
    /**
     * 
     * @param username
     * @param pass
     * @return
     * @throws Exception
     */
    public boolean Login(String username, String pass) throws Exception{
        clsMapperAccount account=new clsMapperAccount();
        return account.AccountLogin(username, pass);
    }
    /**
     *
     * @return
     * @throws Exception
     */
    public ArrayList<clsAccount> getAllAccout() throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        return mpa.getAllAccount();
    }
     public ArrayList<clsAccount> getAllAccoutWithLimmit(int start, int limmit) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        return mpa.getAllAccountWithLimmit(start, limmit);
    }
    /**
     *
     * @param username
     * @return
     * @throws Exception
     */
    public ArrayList<clsAccount> SearchAcByUser(String username) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        return mpa.SearchAccByUser(username);
    }
    public ArrayList<clsAccount> SearchAcByUserWithLimmit(String username,int start, int limmit) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        return mpa.SearchAccByUserWithLimmit(username, start, limmit);
    }
    public int CountNumAccount() throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        return mpa.CountNumAccount();
    }
     public int CountNumAccountByUser(String Username) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        return mpa.CountNumAccountByUser(Username);
    }
    /**
     *
     * @param username
     * @return
     * @throws Exception
     */
    public int getAccountType(String username) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        clsAccount account=mpa.getAccountInfo(username);
        return account.getType();
    }
    
    /**
     *
     * @param account
     * @return
     * @throws Exception
     */
    public boolean Insert(clsAccount account) throws Exception{
       clsMapperAccount BOA=new clsMapperAccount();
       return BOA.AccountInsert(account);
    }

    /**
     * 
     * @param username
     * @throws Exception
     */
    public void Delete(String username) throws Exception{
        try{
            clsMapperAccount mapper = new clsMapperAccount();
            mapper.AccountDelete(username);
        }catch(Exception ex){
            throw ex;
        }
    }

    /**
     *
     * @param user
     * @throws Exception
     */
    public void updateLogin(String user) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        mpa.AccountUpdateLogin(user);
    }
    
    /**
     * 
     * @param user
     * @return
     * @throws Exception
     */
    public boolean checkLogin(String user) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        return mpa.AccountCheckLogin(user);
    }

    /**
     *
     * @param user
     * @return
     * @throws Exception
     */
    public boolean checkLock(String user) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        return mpa.AccountCheckLock(user);
    }
    /**
     *
     * @param user
     * @param newpass
     * @throws Exception
     */
    public void changePass(String user, String newpass) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        mpa.AccountChangePass(user, newpass);
    }
}