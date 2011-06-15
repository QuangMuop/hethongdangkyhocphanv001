

package system.dto;

import java.sql.Date;

public class clsLecturer {
    private String LecturerCode;
    private String FullName;
    private String BirthDay;
    private String Email;
    private String Phone;
    private String Address;
    private String HocHam;
    private String HocVi;
    private String Gender;
    private String CMND;
    public clsLecturer(){

    }
    public clsLecturer(String Code,String fullname, String birthday, String email, String phone, String address, String hocham, String hocvi, String gender, String cmnd){
        this.FullName=fullname;
        this.BirthDay=birthday;
        this.Email=email;
        this.Phone=phone;
        this.Address=address;
        this.HocHam=hocham;
        this.HocVi=hocvi;
        this.Gender=gender;
        this.CMND=cmnd;
        this.LecturerCode=Code;
    }
    public void setLecturerCode(String code){
        this.LecturerCode=code;
    }
public void setFullName(String name){
    this.FullName=name;
}
public void setBirthDay(String date){
    this.BirthDay=date;
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
public void setHocHam(String hocham){
    this.HocHam=hocham;
}
public void setHocVi(String hocvi){
    this.HocVi=hocvi;
}
public void setGender(String gender){
    this.Gender=gender;
}
public void setCMND(String cmnd){
    this.CMND=cmnd;
}
 public String getFullname(){
    return this.FullName;
}
 public String getLecturerCode(){
     return this.LecturerCode;
 }
public String getBirthDay(){
    return this.BirthDay;
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
public String getHocHam(){
    return this.HocHam;
}
public String getHocVi(){
    return this.HocVi;
}
public String getGender(){
    return this.Gender;
}
public String getCMND(){
    return this.CMND;
}
}
