
package system.dto;

public class clsProgram {
private int ProgramCode;
private String SubjectCode;
public clsProgram(){

}
public clsProgram(int programcode, String subjectcode){
    this.ProgramCode=programcode;
    this.SubjectCode=subjectcode;
}
public void setProgramCode(int programcode){
    this.ProgramCode=programcode;
}
public void setSubjectCode(String subjectcode){
    this.SubjectCode=subjectcode;
}
public int getProgramCode(){
    return this.ProgramCode;
}
public String getSubjectCode(){
    return this.SubjectCode;
}
}
