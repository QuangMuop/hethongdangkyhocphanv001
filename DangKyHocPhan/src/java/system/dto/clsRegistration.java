

package system.dto;


public class clsRegistration {
private String StudentCode;
private String SubjectCode;
private int Semester;
private String Year;
private float Mark;

public clsRegistration(String studentcode, String subjectcode, int semester,String year, float mark ){
    this.StudentCode=studentcode;
    this.SubjectCode=subjectcode;
    this.Semester=semester;
    this.Year=year;
    this.Mark=mark;
}
public void setStudentCode(String studentcode){
    this.StudentCode=studentcode;
}
public void setSubjectCode(String subjectcode){
    this.SubjectCode=subjectcode;
}
public void setSemester(int semetesr){
    this.Semester=semetesr;
}
public void setYear(String year){
    this.Year=year;
}
public void setMark(float mark){
    this.Mark=mark;
}
public String getStudentCode(){
    return this.StudentCode;
}
public String getSubjectCode(){
    return this.SubjectCode;
}
public float getMark(){
    return this.Mark;
}
public String getYear(){
    return this.Year;
}
public int getSemester(){
    return this.Semester;
}
}
