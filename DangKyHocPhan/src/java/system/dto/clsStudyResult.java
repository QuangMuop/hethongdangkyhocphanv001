

package system.dto;

public class clsStudyResult {
private String StudentCode;
private String SubjectCode;
private float Mark;
public clsStudyResult(){

}
public clsStudyResult(String studentcode, String subjectcode, float mark){
    this.StudentCode=studentcode;
    this.SubjectCode=subjectcode;
    this.Mark=mark;
}
public void setStudentCode(String studentcode){
    this.StudentCode=studentcode;
}
public void setSubjectCode(String subjectcode){
    this.SubjectCode=subjectcode;
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
}
