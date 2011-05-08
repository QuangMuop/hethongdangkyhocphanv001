package system.bo;
import system.access.mapper.clsMapperAccount;
import system.dto.clsAccount;
public class clsBOAccount {
public boolean Login(String username, String pass) throws Exception{
    clsMapperAccount account=new clsMapperAccount();
    return account.AccountLogin(username, pass);
}
public int getAccountType(String username) throws Exception{
    clsMapperAccount mpa=new clsMapperAccount();
    clsAccount account=mpa.getAccountInfo(username);
    return account.getType();
}
}
