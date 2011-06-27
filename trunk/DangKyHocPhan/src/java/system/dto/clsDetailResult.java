package system.dto;

public class clsDetailResult {

    private String Year;
    private int Semester;
    private String SubCode;
    private String SubName;
    private int NumTC;
    private float Mark;

    public clsDetailResult() {
    }

    public clsDetailResult(String year, int semester, String subcode, String subname, int numtc, float mark) {
        this.Year = year;
        this.Semester = semester;
        this.SubCode = subcode;
        this.SubName = subname;
        this.NumTC = numtc;
        this.Mark = mark;
    }

    public void setYear(String year) {
        this.Year = year;
    }

    public void setSemester(int semester) {
        this.Semester = semester;
    }

    public void setSubName(String subname) {
        this.SubName = subname;
    }

    public void setSubCode(String subcode) {
        this.SubCode = subcode;
    }

    public void setNumTC(int numtc) {
        this.NumTC = numtc;
    }

    public void setMark(float mark) {
        this.Mark = mark;
    }

    public String getYear() {
        return this.Year;
    }

    public int getSemester() {
        return this.Semester;
    }

    public String getSubName() {
        return this.SubName;
    }

    public String getSubCode() {
        return this.SubCode;
    }

    public int getNumTC() {
        return this.NumTC;
    }

    public float getMark() {
        return this.Mark;
    }
}
