
package system.dto;

import java.sql.Date;


public class clsStudent {
    private String FullName;
    private String BirthDay;
    private String Code;
    private String Class;
    private String Email;
    private String Phone;
    private String Address;
    private String Home;
    private int IsStuding;
    private int Course;
    public clsStudent(){

    }
    public clsStudent(String fullname, String birthday, String code, String classs, String email, String phone, String address, String home, int isstuding, int course){
        this.FullName=fullname;
        this.BirthDay=birthday;
        this.Code=code;
        this.Class=classs;
        this.Email=email;
        this.Phone=phone;
        this.Address=address;
        this.Home=home;
        this.IsStuding=isstuding;
        this.Course=course;
    }
    public void setFullName(String name){
    this.FullName=name;
}
public void setBirthDay(String birth){
    this.BirthDay=birth;
}
public void setCode(String code){
    this.Code=code;
}
public void setClass(String classs){
    this.Class=classs;
}
public void setEmail(String email){
    this.Email=email;
}
public void setPhone(String phone){
    this.Phone=phone;
}
public void setAddress(String add){
    this.Address=add;
}
public void setHome(String home){
    this.Home=home;
}
public void setIsStuding(int studing){
    this.IsStuding=studing;
}
public void setCourse(int course){
    this.Course=course;
}
public String getFullname(){
    return this.FullName;
}
public String getBirthDay(){
    return this.BirthDay;
}
public String getCode(){
    return this.Code;
}
public String getClasss(){
    return this.Class;
}
public String getEmail(){
    return this.Email;
}
public String getPhone(){
    return this.Phone;
}
public String getAddress(){
    return this.Address;
}
public String getHome(){
    return this.Home;
}
public int getIsStuding(){
    return this.IsStuding;
}
public int getCourse(){
    return this.Course;
}

}
