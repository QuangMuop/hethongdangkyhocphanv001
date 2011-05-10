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
     * Get account type: admin or normal
     * @param username
     * @return type of username
     * @throws Exception
     */
    public int getAccountType(String username) throws Exception{
        clsMapperAccount mpa=new clsMapperAccount();
        clsAccount account=mpa.getAccountInfo(username);
        return account.getType();
    }
    
    /**
     * Insert an account into database
     * @param account
     * @return true if successfull, false if fail
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
}
