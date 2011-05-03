

package system.dto;


public class clsCourse {
private int CourseCode;
private int YearIn;
private int YeatOut;
private int NumOfStudent;
private int ProgramCode;
public clsCourse(){

}
public clsCourse(int coursecode, int yearin, int yearout, int numofstudent, int programcode){
    this.CourseCode=coursecode;
    this.YearIn=yearin;
    this.YeatOut=yearout;
    this.NumOfStudent=numofstudent;
    this.ProgramCode=programcode;
}
public void SetCourseCode(int coursecode){
    this.CourseCode=coursecode;
}
public void setYearIn(int yearin){
    this.YearIn=yearin;
}
public void setYearOut(int yearout){
    this.YeatOut=yearout;
}
public void setNumOfStudent(int numofstudent){
    this.NumOfStudent=numofstudent;
}
public void setProgramCode(int programcode){
    this.ProgramCode=programcode;
}
public int getCourseCode(){
    return this.CourseCode;
}
public int getYearIn(){
    return this.YearIn;
}
public int getYearOut(){
    return this.YeatOut;
}
public int getNumOfStudent(){
    return this.NumOfStudent;
}
public int getProgramCode(){
    return this.ProgramCode;
}
}
