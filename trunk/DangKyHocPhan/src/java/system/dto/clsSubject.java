package system.dto;

public class clsSubject {

    private String SubName;
    private String SubCode;
    private int NumTC;
    private int TCLT;
    private int TCTH;

    public clsSubject() {
    }

    public clsSubject(String subname, String subcode, int numtc, int tclt, int tcth) {
        this.SubName = subname;
        this.SubCode = subcode;
        this.NumTC = numtc;
        this.TCLT = tclt;
        this.TCTH = tcth;
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

    public void setTCLT(int tclt) {
        this.TCLT = tclt;
    }

    public void setTCTH(int tcth) {
        this.TCTH = tcth;
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

    public int getTCLT() {
        return this.TCLT;
    }

    public int getTCTH() {
        return this.TCTH;
    }
}
