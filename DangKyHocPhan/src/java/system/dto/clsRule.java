

package system.dto;

public class clsRule {
private int No=1;
private int MaxTC;
private int MinTC;
private int MaxStudentAge;
private int MinStudentAge;
private int MaxOfStudent;
private int MinOfStudent;
private int MarkPass;
private int MaxLecturerAge;
private int MinLecturerAge;
public clsRule(){
    this.No=1;
}
public clsRule(int maxtc, int mintc, int maxstudentage, int minstudentage, int maxofstudent, int minofstudent, int markpass, int maxlecturerage, int minlecturerage){
    this.No=1;
    this.MaxTC=maxtc;
    this.MinTC=mintc;
    this.MaxStudentAge=maxstudentage;
    this.MinStudentAge=minstudentage;
    this.MaxOfStudent=maxofstudent;
    this.MinOfStudent=minofstudent;
    this.MarkPass=markpass;
    this.MaxLecturerAge=maxlecturerage;
    this.MinLecturerAge=minlecturerage;
}
public void setNo(){
    this.No=1;
}
public void setMaxTC(int maxtc){
    this.MaxTC=maxtc;
}
public void setMinTC(int mintc){
    this.MinTC=mintc;
}
public void setMaxStudentAge(int maxstudentage){
    this.MaxStudentAge=maxstudentage;
}
public void setMinStudentAge(int minstudentage){
    this.MinStudentAge=minstudentage;
}
public void setMaxOfStudent(int maxofstudent){
    this.MaxOfStudent=maxofstudent;
}
public void setMinOfStudent(int minofstudent){
    this.MinOfStudent=minofstudent;
}
public void setMarkPass(int markpass){
    this.MarkPass=markpass;
}
public void setMinLecturerge(int minlecturerage){
    this.MinLecturerAge=minlecturerage;
}
public void setMaxLecturerge(int maxlecturerage){
    this.MaxLecturerAge=maxlecturerage;
}
public int getMaxTC(){
    return this.MaxTC;
}
public int getMinTC(){
    return this.MinTC;
}
public int getNo(){
    return this.No;
}
public int getMaxStudentAge(){
    return this.MaxStudentAge;
}
public int getMinStudentAge(){
    return this.MinStudentAge;
}
public int getMaxOfStudent(){
    return this.MaxOfStudent;
}
public int getMinOfStudent(){
        return this.MinOfStudent;
}
public int getMarkPass(){
    return this.MarkPass;
}
public int getMaxLecturerAge(){
    return this.MaxLecturerAge;
}
public int getMinLecturerAge(){
    return this.MinLecturerAge;
}
}
