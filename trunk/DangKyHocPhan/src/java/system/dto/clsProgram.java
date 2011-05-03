
package system.dto;

public class clsProgram {
private int ProgrameCode;
private String SubjectCode;
public clsProgram(int programcode, String subjectcode){
    this.ProgrameCode=programcode;
    this.SubjectCode=subjectcode;
}
public void setProgramCode(int programcode){
    this.ProgrameCode=programcode;
}
public void setSubjectCode(String subjectcode){
    this.SubjectCode=subjectcode;
}
public int getProgramCode(){
    return this.ProgrameCode;
}
public String getSubjectCode(){
    return this.SubjectCode;
}
}
