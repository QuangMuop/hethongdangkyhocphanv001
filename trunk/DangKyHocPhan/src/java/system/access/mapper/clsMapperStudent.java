package system.access.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import system.dto.clsStudent;

public class clsMapperStudent extends clsMapperDb {

    /**
     * Constructor
     * @throws Exception
     */
    public clsMapperStudent() throws Exception {
        super();
    }

    /**
     * Initial a student object from DTO data
     * @param student return value
     * @param rs source
     * @throws SQLException
     */
    public void IniStudentDTOFromRs(clsStudent student, ResultSet rs) throws SQLException {
        if ((rs != null) && (student != null)) {
            student.setFullName(rs.getString("FullName"));
            student.setCode(rs.getString("MSSV"));
            student.setBirthDay(rs.getString("BirthDay"));
            student.setClass(rs.getString("Class"));
            student.setEmail(rs.getString("Email"));
            student.setPhone(rs.getString("Phone"));
            student.setAddress(rs.getString("Address"));
            student.setHome(rs.getString("Home"));
            student.setIsStuding(rs.getString("IsStuding"));
            student.setCourse(Integer.parseInt(rs.getString("CourseCode")));
            student.setGender(rs.getString("Gender"));
            student.setCMND(rs.getString("CMND"));
            student.setType(rs.getString("Type"));
            student.setBacHoc(rs.getString("BacHoc"));
            student.setNote(rs.getString("Note"));
            student.setNhapHoc(rs.getString("NhapHoc"));
        }
    }

    /**
     * 
     * @param MSSV
     * @return
     * @throws Exception
     */
    public clsStudent getStudentInfoByCode(String MSSV) throws Exception {
        clsStudent student = new clsStudent();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student Where ");
            sql.append("MSSV = '").append(MSSV).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if ((rs != null) && rs.next()) {
                IniStudentDTOFromRs(student, rs);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return student;
    }

    /**
     * 
     * @param name
     * @return
     * @throws Exception 
     */
    public clsStudent getStudentInfoByName(String name) throws Exception {
        clsStudent student = new clsStudent();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student Where ");
            sql.append("FullName = '").append(name).append("'");//có dấu tiếng việt thì chưa lấy được
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if ((rs != null) && rs.next()) {
                IniStudentDTOFromRs(student, rs);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return student;
    }

    /**
     * 
     * @param name
     * @return
     * @throws Exception 
     */
    public ArrayList<clsStudent> getStudentsByName(String name) throws Exception {
        ArrayList<clsStudent> listResult = new ArrayList<clsStudent>();
        clsStudent student = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from dangkyhocphan.student where FullName like '");
            sql.append(name).append("%' Order by MSSV");//có dấu tiếng việt thì chưa lấy được
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listResult.add(student);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return listResult;
    }

    /**
     * 
     * @param name
     * @param start
     * @param limit
     * @return
     * @throws Exception 
     */
    public ArrayList<clsStudent> getStudentsByNameWithLimmit(String name, int start, int limit) throws Exception {
        ArrayList<clsStudent> listResult = new ArrayList<clsStudent>();
        clsStudent student = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from dangkyhocphan.student where FullName like '");
            sql.append(name).append("%' Order by MSSV ASC LIMIT " + start + "," + limit + "");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listResult.add(student);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return listResult;
    }

    /**
     * 
     * @param name
     * @return
     * @throws Exception 
     */
    public int CountStudentsByName(String name) throws Exception {
        int Result = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select COUNT(MSSV) as Num from dangkyhocphan.student where FullName like '");
            sql.append(name).append("%'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                Result = Integer.parseInt(rs.getString("Num"));
            }
        } catch (Exception ex) {
            throw ex;
        }
        return Result;
    }

    /**
     * 
     * @param code
     * @return
     * @throws Exception 
     */
    public ArrayList<clsStudent> getStudentsByCode(String code) throws Exception {
        ArrayList<clsStudent> listResult = new ArrayList<clsStudent>();
        clsStudent student = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from dangkyhocphan.student where MSSV like '");
            sql.append(code).append("%' Order by MSSV");//có dấu tiếng việt thì chưa lấy được
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listResult.add(student);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return listResult;
    }

    /**
     * 
     * @param code
     * @param start
     * @param limit
     * @return
     * @throws Exception 
     */
    public ArrayList<clsStudent> getStudentsByCodeWithLimit(String code, int start, int limit) throws Exception {
        ArrayList<clsStudent> listResult = new ArrayList<clsStudent>();
        clsStudent student = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from dangkyhocphan.student where MSSV like '");
            sql.append(code).append("%' Order by MSSV ASC LIMIT " + start + "," + limit + "");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listResult.add(student);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return listResult;
    }

    /**
     * 
     * @param Code
     * @return
     * @throws Exception 
     */
    public int CountStudentsByCode(String Code) throws Exception {
        int Result = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select COUNT(MSSV) as Num from dangkyhocphan.student where MSSV like '");
            sql.append(Code).append("%'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                Result = Integer.parseInt(rs.getString("Num"));
            }
        } catch (Exception ex) {
            throw ex;
        }
        return Result;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public ArrayList<clsStudent> GetAllStudent() throws Exception {
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student ");
            sql.append(" Order by MSSV");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                clsStudent student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listStudent.add(student);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return listStudent;
    }

    /**
     * 
     * @param name
     * @return
     * @throws Exception 
     */
    public int CountAllStudents() throws Exception {
        int Result = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select COUNT(MSSV) as Num from dangkyhocphan.student");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                Result = Integer.parseInt(rs.getString("Num"));
            }
        } catch (Exception ex) {
            throw ex;
        }
        return Result;
    }

    /**
     * 
     * @param start
     * @param limit
     * @return
     * @throws Exception 
     */
    public ArrayList<clsStudent> GetAllStudentWithLimit(int start, int limit) throws Exception {
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student ");
            sql.append(" Order by MSSV ASC LIMIT " + start + "," + limit + "");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                clsStudent student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listStudent.add(student);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return listStudent;
    }

    /**
     *
     * @param className
     * @return
     * @throws Exception
     */
    public ArrayList<clsStudent> GetStudentsByClass(String className) throws Exception {
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from dangkyhocphan.student where Class = '");
            sql.append(className).append("' Order by MSSV");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                clsStudent student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listStudent.add(student);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return listStudent;
    }

    /**
     * 
     * @param className
     * @param start
     * @param limit
     * @return
     * @throws Exception 
     */
    public ArrayList<clsStudent> GetStudentsByClassWithLimmit(String className, int start, int limit) throws Exception {
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from dangkyhocphan.student where Class = '");
            sql.append(className).append("'Order by MSSV ASC LIMIT " + start + "," + limit + "");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                clsStudent student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listStudent.add(student);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return listStudent;
    }

    /**
     * 
     * @param className
     * @return
     * @throws Exception 
     */
    public int CountStudentsByClass(String className) throws Exception {
        int Result = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select COUNT(MSSV) as Num from dangkyhocphan.student where Class= '").append(className).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while ((rs != null) && rs.next()) {
                Result = Integer.parseInt(rs.getString("Num"));
            }
        } catch (Exception ex) {
            throw ex;
        }
        return Result;
    }

    public boolean StudentInsert(clsStudent student) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.student values('");
            sql.append(student.getFullname()).append("','");
            sql.append(student.getCode()).append("','");
            sql.append(student.getBirthDay()).append("','");
            sql.append(student.getClasss()).append("','");
            sql.append(student.getEmail()).append("','");
            sql.append(student.getPhone()).append("','");
            sql.append(student.getAddress()).append("','");
            sql.append(student.getHome()).append("','");
            sql.append(student.getIsStuding()).append("',");
            sql.append(student.getCourse()).append(",'");
            sql.append(student.getNhaphoc()).append("','");
            sql.append(student.getGender()).append("','");
            sql.append(student.getCMND()).append("','");
            sql.append(student.getType()).append("','");
            sql.append(student.getBacHoc()).append("','");
            sql.append(student.getNote()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean StudentCheckExistCode(String code) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student Where MSSV = '").append(code).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if ((rs != null) && (rs.next())) {
                return true;
            }
            stmt.close();
        } catch (Exception ex) {
            throw ex;
        }
        return false;
    }

    /**
     * Delte a student by student id (mssv)
     * @param mssv
     * @throws Exception
     */
    public boolean Delete(String mssv) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.student Where MSSV = '").append(mssv).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void StudentUpdateByAdmin(clsStudent student) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.student set FullName = '").append(student.getFullname()).append("',");
            sql.append(" BirthDay='").append(student.getBirthDay()).append("',");
            sql.append(" Class='").append(student.getClasss()).append("',");
            sql.append(" Email='").append(student.getEmail()).append("',");
            sql.append(" Phone='").append(student.getPhone()).append("',");
            sql.append(" Address='").append(student.getAddress()).append("',");
            sql.append(" Home='").append(student.getHome()).append("',");
            sql.append(" IsStuding='").append(student.getIsStuding()).append("',");
            sql.append(" CourseCode=").append(student.getCourse()).append(",");
            sql.append(" Gender='").append(student.getGender()).append("',");
            sql.append(" CMND='").append(student.getCMND()).append("',");
            sql.append(" Type='").append(student.getType()).append("',");
            sql.append(" BacHoc='").append(student.getBacHoc()).append("', ");
            sql.append(" NhapHoc='").append(student.getNhaphoc()).append("', ");
            sql.append(" Note='Null'");
            sql.append(" Where MSSV='").append(student.getCode()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void StudentUpdateByStudent(String info, String MSSV) throws Exception {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.student set Note = '").append(info).append("'");
            sql.append(" Where MSSV='").append(MSSV).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
