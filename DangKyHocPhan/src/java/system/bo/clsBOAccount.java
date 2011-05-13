package system.bo;
import system.access.mapper.clsMapperAccount;
import system.dto.clsAccount;
public class clsBOAccount {

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
        try {
            clsMapperAccount mapper = new clsMapperAccount();
            boolean isExisteAcc = mapper.AccountCheckExits(account.getUserName());
            if(isExisteAcc == true)
                return false;
            mapper.AccountInsert(account);
        }catch (Exception e) {
                throw e;
        }
        return true;
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
}