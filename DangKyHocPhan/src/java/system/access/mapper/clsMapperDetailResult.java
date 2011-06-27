package system.access.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import system.communication.database.ConnectionServer;
import system.dto.clsDetailResult;

public class clsMapperDetailResult extends clsMapperDb {

    public clsMapperDetailResult() throws Exception {
        super();
    }

    public void IniDetailResultDTOFromRs(clsDetailResult subject, ResultSet rs) throws SQLException {
        if ((rs != null) && (subject != null)) {
            subject.setSubName(rs.getString("SubName"));
            subject.setSubCode(rs.getString("SubCode"));
            subject.setNumTC(Integer.parseInt(rs.getString("NumTC")));
            subject.setYear(rs.getString("Year"));
            subject.setMark(Float.parseFloat(rs.getString("Mark")));
            subject.setSemester(Integer.parseInt(rs.getString("Semester")));
        }
    }

    public ArrayList<clsDetailResult> getResult(String MSSV, String year, int semester) throws Exception {
        ArrayList<clsDetailResult> subject = new ArrayList<clsDetailResult>();
        try {
            StringBuffer sql = new StringBuffer();
            if (year.equalsIgnoreCase("All") && semester == 0) {
                sql.append("Select Year,Semester, studyresult.SubCode, SubName, NumTC,  Mark from dangkyhocphan.studyresult,dangkyhocphan.subject where studyresult.SubCode=subject.SubCode and MSSV='" + MSSV + "'");
            } else if (year.equalsIgnoreCase("All") && semester != 0) {
                sql.append("Select Year,Semester, studyresult.SubCode, SubName, NumTC,  Mark from dangkyhocphan.studyresult,dangkyhocphan.subject where studyresult.SubCode=subject.SubCode and MSSV='" + MSSV + "' and Semester=" + semester + "");
            } else if (year.equalsIgnoreCase("All") == false && semester == 0) {
                sql.append("Select Year,Semester, studyresult.SubCode, SubName, NumTC,  Mark from dangkyhocphan.studyresult,dangkyhocphan.subject where studyresult.SubCode=subject.SubCode and MSSV='" + MSSV + "' and Year='" + year + "'");
            } else {
                sql.append("Select Year,Semester, studyresult.SubCode, SubName, NumTC,  Mark from dangkyhocphan.studyresult,dangkyhocphan.subject where studyresult.SubCode=subject.SubCode and MSSV='" + MSSV + "' and Semester=" + semester + " and Year='" + year + "'");
            }
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                clsDetailResult classTemp = new clsDetailResult();
                IniDetailResultDTOFromRs(classTemp, rs);
                subject.add(classTemp);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return subject;
    }
}
