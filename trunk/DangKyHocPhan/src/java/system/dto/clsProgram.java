
package system.dto;

public class clsProgram {
private int ProgramCode;
private String SubjectCode;
private int Semester;
private String SubName;
public clsProgram(){

}
public clsProgram(int programcode, String subjectcode, int semester, String subname){
    this.ProgramCode=programcode;
    this.SubjectCode=subjectcode;
    this.Semester=semester;
    this.SubName=subname;
}
public void setProgramCode(int programcode){
    this.ProgramCode=programcode;
}
public void setSemester(int semester){
    this.Semester=semester;
}
public void setSubName(String subname){
    this.SubName=subname;
}
public void setSubjectCode(String subjectcode){
    this.SubjectCode=subjectcode;
}
public int getProgramCode(){
    return this.ProgramCode;
}
public int getSemester(){
    return this.Semester;
}
public String getSubName(){
    return this.SubName;
}
public String getSubjectCode(){
    return this.SubjectCode;
}
}
