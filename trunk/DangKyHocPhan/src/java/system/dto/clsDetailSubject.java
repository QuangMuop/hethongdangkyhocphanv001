
package system.dto;

public class clsDetailSubject {
private String SubjectCode;
private String PreSubjectCode;
public clsDetailSubject(){

}
public clsDetailSubject(String subjectcode, String presubjectcode){
    this.SubjectCode=subjectcode;
    this.PreSubjectCode=presubjectcode;
}
public void setSubjectCode(String subjectcode){
    this.SubjectCode=subjectcode;
}
public void setPreSubjectCode(String presubjectcode){
    this.PreSubjectCode=presubjectcode;
}
public String getSubjectCode(){
    return this.SubjectCode;
}
public  String getPreSubjectCode(){
    return this.PreSubjectCode;
}
}
