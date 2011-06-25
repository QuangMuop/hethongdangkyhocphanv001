package system.access.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import system.dto.clsRegistration;
import system.dto.clsStudyResult;
import system.utilities.SystemProperities;

public class clsMapperRegistration extends clsMapperDb {

    /**
     * 
     * @throws Exception 
     */
    public clsMapperRegistration() throws Exception {
        super();
    }

    /**
     * 
     * @param reg
     * @param rs
     * @throws SQLException 
     */
    public void IniRegistrationDTOFromRs(clsRegistration reg, ResultSet rs) throws SQLException {
        if ((rs != null) && (reg != null)) {
            reg.setStudentCode(rs.getString("MSSV"));
            reg.setClassName(rs.getString("ClassName"));
            reg.setSemester(Integer.parseInt(rs.getString("Semester")));
            reg.setYear(rs.getString("Year"));
            reg.setMark(Float.parseFloat(rs.getString("Mark")));
        }
    }

    /**
     *
     * @param className
     * @return
     * @throws Exception
     */
    public ArrayList<String> getListStudentIdFromClassName(String className) throws Exception {
        ArrayList<String> listStudentCode = new ArrayList<String>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.registry Where ");
            sql.append("ClassName = '").append(className);
            sql.append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs != null && rs.next()) {
                String idTemp = rs.getString("MSSV");
                listStudentCode.add(idTemp);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return listStudentCode;
    }

    /**
     *
     * @param reg
     * @return
     * @throws Exception
     */
    public ArrayList<String> getRegistrationInfo(clsRegistration reg) throws Exception {//lấy chưa được thông tin các lớp học của một sinh viên
        ArrayList<String> result = new ArrayList<String>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select ClassName from dangkyhocphan.registry Where ");
            sql.append("MSSV = '").append(reg.getStudentCode()).append("' and Semester=");
            sql.append(reg.getSemester()).append(" and Year='");
            sql.append(reg.getYear()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs != null && rs.next()) {
                String idTemp = rs.getString("ClassName");
                result.add(idTemp);
            }
            return result;
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * 
     * @param reg
     * @return
     * @throws Exception 
     */
    public boolean checkPreSub(clsRegistration reg) throws Exception {
        clsMapperRule Rule = new clsMapperRule();
        clsMapperViewProgram mpv = new clsMapperViewProgram();
        float PassMark = Rule.getRuleInfo().getMarkPass();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select  PreSubCode From dangkyhocphan.subjectdetail where SubCode in(Select SubCode from dangkyhocphan.class where ClassName='");
            sql.append(reg.getClassName()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs == null) {
                return true;//môn học không có môn học tiên quyết
            } else {
                while (rs != null && rs.next()) {
                    if (mpv.getMark(reg.getStudentCode(), rs.getString("PreSubCode")) < PassMark) {
                        return false;//môn tiên quyết học chưa qua hay chưa học
                    }
                }
                return true;//đã học qua các môn học tiên quyết của môn học này
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * 
     * @param reg
     * @throws Exception
     */
    public void RegistrationInsert(clsRegistration reg) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.registry(MSSV,ClassName,Semester,Year) values('");
            sql.append(reg.getStudentCode()).append("','");
            sql.append(reg.getClassName()).append("',");
            sql.append(reg.getSemester()).append(",'");
            sql.append(reg.getYear()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 
     * @param ClassName
     * @return
     * @throws Exception 
     */
    private int GetNumOfStudent(String ClassName) throws Exception {
        int result = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select NumOfStudent from dangkyhocphan.class where classname='");
            sql.append(ClassName).append("' and semester=");
            sql.append(SystemProperities.Curentsemester);
            sql.append(" and Year='" + SystemProperities.CurentYear + "'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                result = Integer.parseInt(rs.getString("NumOfStudent"));
            }
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }

    /**
     * 
     * @param reg
     * @return
     * @throws Exception 
     */
    public String RegistrationInsertCheck(clsRegistration reg) throws Exception {
        if (GetNumOfStudent(reg.getClassName()) >= 120) {
            return reg.getClassName();
        } else if (checkPreSub(reg)) {
            try {
                StringBuffer sql = new StringBuffer();
                sql.append("Insert into dangkyhocphan.registry(MSSV,ClassName,Semester,Year) values('");
                sql.append(reg.getStudentCode()).append("','");
                sql.append(reg.getClassName()).append("',");
                sql.append(reg.getSemester()).append(",'");
                sql.append(reg.getYear()).append("')");
                PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
                stmt.execute();
                stmt.close();
                return "OK";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return reg.getClassName();//return tên lớp học
        }
    }

    /**
     * 
     * @param reg
     * @throws Exception
     */
    public void RegistrationDelete(clsRegistration reg) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("delete from dangkyhocphan.registry where MSSV='");
            sql.append(reg.getStudentCode()).append("' and ClassName='");
            sql.append(reg.getClassName()).append("' and Semester=");
            sql.append(reg.getSemester()).append(" and Year='");
            sql.append(reg.getYear()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * 
     * @param MSSV
     * @param semester
     * @param year
     * @throws Exception
     */
    public void DeleteAllRegistry(String MSSV, int semester, String year) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("delete from dangkyhocphan.registry where MSSV='");
            sql.append(MSSV).append("'  and Semester=");
            sql.append(semester).append(" and Year='");
            sql.append(year).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * 
     * @param mssv
     * @throws Exception 
     */
    public void RegistrationDeleteByStudentId(String mssv) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("delete from dangkyhocphan.registry where MSSV = '");
            sql.append(mssv).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * 
     * @param reg
     * @return
     * @throws Exception
     */
    public boolean RegistrationCheckExits(clsRegistration reg) throws Exception {
        boolean result = false;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.registry Where MSSV ='");
            sql.append(reg.getStudentCode()).append("' and ClassName='");
            sql.append(reg.getClassName()).append("' and Semester=");
            sql.append(reg.getSemester()).append(" and Year='");
            sql.append(reg.getYear()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if ((rs != null) && (rs.next())) {
                result = true;
            }
            stmt.close();
        } catch (Exception ex) {
            throw ex;
        }
        return result;
    }
    public void updateMark(clsRegistration cls) throws Exception{
             try {
            StringBuffer sql = new StringBuffer();
            sql.append("update dangkyhocphan.registry set Mark=");
            sql.append(cls.getMark()).append(" where MSSV='");
            sql.append(cls.getStudentCode()).append("' and classname='");
            sql.append(cls.getClassName()).append("' and Semester=");
            sql.append(cls.getSemester()).append(" and year='");
            sql.append(cls.getYear()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        } catch (Exception ex) {
            throw ex;
        }
}
}