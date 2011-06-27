package system.dto;

public class clsViewProgram {

    private String SubCode;
    private String SubName;
    private int NumTC;
    private int NumTCLT;
    private int NumTCTH;
    private float Mark;
    private int Semester;

    public clsViewProgram() {
    }

    public clsViewProgram(String subcode, String subname, int numtc, int numtclt, int numtcth, float mark, int semester) {
        this.SubCode = subcode;
        this.SubName = subname;
        this.NumTC = numtc;
        this.NumTCLT = numtclt;
        this.NumTCTH = numtcth;
        this.Mark = mark;
        this.Semester = semester;
    }

    public void setSubCode(String subcode) {
        this.SubCode = subcode;
    }

    public void setSubName(String subname) {
        this.SubName = subname;
    }

    public void setNumTC(int numtc) {
        this.NumTC = numtc;
    }

    public void setNumTCLT(int numtclt) {
        this.NumTCLT = numtclt;
    }

    public void setNumTCTH(int numtcth) {
        this.NumTCTH = numtcth;
    }

    public void setMark(float mark) {
        this.Mark = mark;
    }

    public void setSemester(int semester) {
        this.Semester = semester;
    }

    public String getSubCode() {
        return this.SubCode;
    }

    public String getSubName() {
        return this.SubName;
    }

    public int getNumTC() {
        return this.NumTC;
    }

    public int getNumTCLT() {
        return this.NumTCLT;
    }

    public int getNumTCTH() {
        return this.NumTCTH;
    }

    public float getMark() {
        return this.Mark;
    }

    public int getSemester() {
        return this.Semester;
    }
}
