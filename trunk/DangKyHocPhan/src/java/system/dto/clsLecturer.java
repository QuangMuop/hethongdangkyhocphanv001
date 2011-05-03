

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
    public clsLecturer(){

    }
    public clsLecturer(String fullname, String birthday, String email, String phone, String address, String hocham, String hocvi){
        this.FullName=fullname;
        this.BirthDay=birthday;
        this.Email=email;
        this.Phone=phone;
        this.Address=address;
        this.HocHam=hocham;
        this.HocVi=hocvi;
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
}
