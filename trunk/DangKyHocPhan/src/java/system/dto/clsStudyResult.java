package system.dto;

public class clsStudyResult {

    private String StudentCode;
    private String SubjectCode;
    private float Mark;
    private String Year;
    private int Semester;

    public clsStudyResult() {
    }

    public clsStudyResult(String studentcode, String subjectcode, float mark, String year, int semester) {
        this.StudentCode = studentcode;
        this.SubjectCode = subjectcode;
        this.Mark = mark;
        this.Year = year;
        this.Semester = semester;
    }

    public void setYear(String year) {
        this.Year = year;
    }

    public void setSemester(int semester) {
        this.Semester = semester;
    }

    public void setStudentCode(String studentcode) {
        this.StudentCode = studentcode;
    }

    public void setSubjectCode(String subjectcode) {
        this.SubjectCode = subjectcode;
    }

    public void setMark(float mark) {
        this.Mark = mark;
    }

    public String getStudentCode() {
        return this.StudentCode;
    }

    public String getSubjectCode() {
        return this.SubjectCode;
    }

    public String getYear() {
        return this.Year;
    }

    public int getSemester() {
        return this.Semester;
    }

    public float getMark() {
        return this.Mark;
    }
}
