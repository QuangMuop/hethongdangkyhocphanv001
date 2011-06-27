package system.dto;

public class clsAccount {

    private String UserName;
    private String PassWord;
    private String FullName;
    private int IsLocked;//0 as false; 1 as true(true is locked)
    private int IsLogin;//0 as false; 1 as true(true is loging)
    private int Type;// 0 for student and for admin
    public clsAccount() {
    }

    public clsAccount(String username, String password, String fullname, int islocked, int islogin, int type) {
        this.UserName = username;
        this.PassWord = password;
        this.FullName = fullname;
        this.IsLocked = islocked;
        this.IsLogin = islogin;
        this.Type = type;
    }

    public void setUserName(String name) {
        this.UserName = name;
    }

    public void setPassWord(String pass) {
        this.PassWord = pass;
    }

    public void setFullName(String name) {
        this.FullName = name;
    }

    public void setIsLocked(int lock) {
        this.IsLocked = lock;
    }

    public void setIsLogin(int login) {
        this.IsLogin = login;
    }

    public void setType(int type) {
        this.Type = type;
    }

    public String getUserName() {
        return this.UserName;
    }

    public String getPassWord() {
        return this.PassWord;
    }

    public String getFullName() {
        return this.FullName;
    }

    public int getIsLocked() {
        return this.IsLocked;
    }

    public int getLogin() {
        return this.IsLogin;
    }

    public int getType() {
        return this.Type;
    }
}
