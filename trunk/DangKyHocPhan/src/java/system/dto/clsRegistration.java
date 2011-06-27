package system.dto;

public class clsRegistration {

    private String StudentCode;
    private String ClassName;
    private int Semester;
    private String Year;
    private float Mark;

    public clsRegistration() {
    }

    public clsRegistration(String studentcode, String classname, int semester, String year, float mark) {
        this.StudentCode = studentcode;
        this.ClassName = classname;
        this.Semester = semester;
        this.Year = year;
        this.Mark = mark;
    }

    public void setStudentCode(String studentcode) {
        this.StudentCode = studentcode;
    }

    public void setClassName(String classname) {
        this.ClassName = classname;
    }

    public void setSemester(int semetesr) {
        this.Semester = semetesr;
    }

    public void setYear(String year) {
        this.Year = year;
    }

    public void setMark(float mark) {
        this.Mark = mark;
    }

    public String getStudentCode() {
        return this.StudentCode;
    }

    public String getClassName() {
        return this.ClassName;
    }

    public float getMark() {
        return this.Mark;
    }

    public String getYear() {
        return this.Year;
    }

    public int getSemester() {
        return this.Semester;
    }
}
