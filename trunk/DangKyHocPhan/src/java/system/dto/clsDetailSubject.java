
package system.dto;

public class clsDetailSubject {
private String SubjectCode;
private String PreSubjectCode;
private String Subname;
private String PreSubName;
public clsDetailSubject(){

}
public clsDetailSubject(String subjectcode, String presubjectcode, String subname, String presubname){
    this.SubjectCode=subjectcode;
    this.PreSubjectCode=presubjectcode;
    this.Subname=subname;
    this.PreSubName=presubname;
}
public void setSubjectCode(String subjectcode){
    this.SubjectCode=subjectcode;
}
public void setSubName(String subname){
    this.Subname=subname;
}
public void setPreSubName(String presubname){
    this.PreSubName=presubname;
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
public String getSubName(){
    return this.Subname;
}
public String getPreSubName(){
    return this.PreSubName;
}
}
