
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
    private String IsStuding;
    private int Course;
    private String Gender;
    private String CMND;
    private String Type;//loại sinh viên, chính quy hay từ xa
    private String BacHoc;//bậc học, đại học, cao học, cao đẳng
    private String Note=null;
    public clsStudent(){

    }
    public clsStudent(String fullname, String birthday, String code, String classs, String email, String phone, String address, String home, String isstuding, int course, String gender, String cmnd, String type, String bachoc){
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
        this.Gender=gender;
        this.CMND=cmnd;
        this.Type=type;
        this.BacHoc=bachoc;
        this.Note = "";
    }
    public void setFullName(String name){
    this.FullName=name;
}
public void setBirthDay(String birth){
    this.BirthDay=birth;
}
public void setGender(String gender){
    this.Gender=gender;
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
public void setIsStuding(String studing){
    this.IsStuding=studing;
}
public void setCourse(int course){
    this.Course=course;
}
public void setCMND(String cmnd){
    this.CMND=cmnd;
}
public void setType(String type){
    this.Type=type;
}
public void setBacHoc(String bachoc){
    this.BacHoc=bachoc;
}
public void setNote(String note){
    this.Note=note;
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
public String getIsStuding(){
    return this.IsStuding;
}
public int getCourse(){
    return this.Course;
}
public String getGender(){
    return this.Gender;
}
public String getCMND(){
    return this.CMND;
}
public String getType(){
    return this.Type;
}
public String getBacHoc(){
    return this.BacHoc;
}
public String getNote(){
    return this.Note;
}
}
