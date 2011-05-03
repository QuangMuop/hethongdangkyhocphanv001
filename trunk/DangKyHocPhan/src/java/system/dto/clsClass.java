

package system.dto;

public class clsClass {
private String ClassName;
private String SubCode;
private String LecturerCode;
private String Date;
private String Room;
private int Shift;
private int NumOfStudent;
public clsClass(){

}
public clsClass(String classname, String subcode, String lecturercode, String date, String room, int shift, int numofstudent){
    this.ClassName=classname;
    this.SubCode=subcode;
    this.LecturerCode=lecturercode;
    this.Date=date;
    this.Room=room;
    this.Shift=shift;
    this.NumOfStudent=numofstudent;
}
public void setClassName(String name){
    this.ClassName=name;
}
public void setSubCode(String subcode){
    this.SubCode=subcode;
}
public void setLecturer(String lecturercode){
    this.LecturerCode=lecturercode;
}
public void setDate(String date){
    this.Date=date;
}
public void setRoom(String room){
    this.Room=room;
}
public void setShift(int shift){
    this.Shift=shift;
}
public void setNumOfStudent(int numofstudent){
    this.NumOfStudent=numofstudent;
}
public String getClassName(){
    return this.ClassName;
}
public String getSubCode(){
    return this.SubCode;
}
public String getLectureCode(){
    return this.LecturerCode;
}
public String getDate(){
    return this.Date;
}
public String getRoom(){
    return this.Room;
}
public int getShift(){
    return this.Shift;
}
public int getNumOfStudent(){
    return this.NumOfStudent;
}
}
