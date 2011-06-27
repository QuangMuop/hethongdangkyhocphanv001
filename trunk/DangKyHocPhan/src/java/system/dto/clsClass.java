package system.dto;

public class clsClass {

    private String ClassName;
    private String SubCode;
    private String LecturerCode;
    private String Date;
    private String Room;
    private int Shift;
    private int NumOfStudent;
    private String TestDate = "Null";
    private String TestTime = "Null";
    private String TestRoom = "Null";
    private String SubName;
    private String LecturerName;
    private int NumTC;

    public clsClass() {
    }

    public clsClass(String classname, String subcode, String subname, String lecturercode, String date, String room, int shift, int numofstudent, String testdate, String testtime, String testroom, String lecturername, int numtc) {
        this.ClassName = classname;
        this.SubCode = subcode;
        this.LecturerCode = lecturercode;
        this.Date = date;
        this.Room = room;
        this.Shift = shift;
        this.NumOfStudent = numofstudent;
        this.TestDate = testdate;
        this.TestTime = testtime;
        this.TestRoom = testroom;
        this.SubName = subname;
        this.LecturerName = lecturername;
        this.NumTC = numtc;
    }

    public void setLectureName(String lecturername) {
        this.LecturerName = lecturername;
    }

    public void setClassName(String name) {
        this.ClassName = name;
    }

    public void setNumTC(int numtc) {
        this.NumTC = numtc;
    }

    public void setSubName(String subname) {
        this.SubName = subname;
    }

    public void setSubCode(String subcode) {
        this.SubCode = subcode;
    }

    public void setLecturer(String lecturercode) {
        this.LecturerCode = lecturercode;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public void setRoom(String room) {
        this.Room = room;
    }

    public void setShift(int shift) {
        this.Shift = shift;
    }

    public void setNumOfStudent(int numofstudent) {
        this.NumOfStudent = numofstudent;
    }

    public void setTestDate(String testdate) {
        this.TestDate = testdate;
    }

    public void setTestTime(String testtime) {
        this.TestTime = testtime;
    }

    public void setTestRoom(String testroom) {
        this.TestRoom = testroom;
    }

    public String getClassName() {
        return this.ClassName;
    }

    public String getSubCode() {
        return this.SubCode;
    }

    public String getLectureCode() {
        return this.LecturerCode;
    }

    public String getDate() {
        return this.Date;
    }

    public String getRoom() {
        return this.Room;
    }

    public int getShift() {
        return this.Shift;
    }

    public int getNumOfStudent() {
        return this.NumOfStudent;
    }

    public String getTestDate() {
        return this.TestDate;
    }

    public String getTestTime() {
        return this.TestTime;
    }

    public String getTestRoom() {
        return this.TestRoom;
    }

    public String getSubName() {
        return this.SubName;
    }

    public String getLecturerName() {
        return this.LecturerName;
    }

    public int getNumTC() {
        return this.NumTC;
    }
}
