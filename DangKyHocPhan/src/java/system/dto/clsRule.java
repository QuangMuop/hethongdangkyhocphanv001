

package system.dto;

public class clsRule {
private int No=1;
private int MaxTC;
private int MinTC;
private int MaxStudentAge;
private int MinStudentAge;
private int MaxOfStudent;
private int MinofStudent;
private int MarkPass;
public clsRule(int maxtc, int mintc, int maxstudentage, int minstudentage, int maxofstudent, int minofstudent, int markpass){
    this.MaxTC=maxtc;
    this.MinTC=mintc;
    this.MaxStudentAge=maxstudentage;
    this.MinStudentAge=minstudentage;
    this.MaxOfStudent=maxofstudent;
    this.MinofStudent=minofstudent;
    this.MarkPass=markpass;
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
    this.MinStudentAge=minofstudent;
}
public void setMarkPass(int markpass){
    this.MarkPass=markpass;
}
public int getMaxTC(){
    return this.MaxTC;
}
public int getMinTC(){
    return this.MinTC;
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
        return this.MinofStudent;
}
public int getMarkPass(){
    return this.MarkPass;
}
}
