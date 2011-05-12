

package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import system.dto.clsStudent;





public class clsMapperStudent extends clsMapperDb{
    
    /**
     * Constructor
     * @throws Exception
     */
    public clsMapperStudent() throws Exception{
        super();
    }

    /**
     * Initial a student object from DTO data
     * @param student return value
     * @param rs source
     * @throws SQLException
     */
    public void IniStudentDTOFromRs(clsStudent student, ResultSet rs) throws SQLException{
         if((rs!=null) && (student!=null)){
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
    public clsStudent getStudentInfoByCode(String MSSV) throws Exception{
        clsStudent student=new clsStudent();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student Where ");
            sql.append("MSSV = '").append(MSSV).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniStudentDTOFromRs(student, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return student;
    }
    
    
    public clsStudent getStudentInfoByName(String name) throws Exception{
        clsStudent student=new clsStudent();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student Where ");
            sql.append("FullName = '").append(name).append("'");//có dấu tiếng việt thì chưa lấy được
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniStudentDTOFromRs(student, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return student;
    }

    /**
     * Get all student in database
     * @param strWhere search codition
     * @param strOrder order by codition
     * @return list of student found
     * @throws Exception
     */
    public ArrayList<clsStudent> GetAllStudent(String strOrder) throws Exception{
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student ");
            sql.append(" Order by ");
            sql.append(strOrder);

            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsStudent student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listStudent.add(student);
            }
        }catch(Exception ex){
            throw ex;
        }
        return listStudent;
    }

    /**
     * Get all student in database by class
     * @param clssName String for search
     * @param strOrder order condition
     * @return list of student found
     * @throws Exception
     */
    public ArrayList<clsStudent> GetStudentsByClass(String className, String strOrder) throws Exception{
        ArrayList<clsStudent> listStudent = new ArrayList<clsStudent>();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student Where Class = '");
            sql.append(className).append("'");
            sql.append(" Order by ");
            sql.append(strOrder);

            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsStudent student = new clsStudent();
                IniStudentDTOFromRs(student, rs);
                listStudent.add(student);
            }
        }catch(Exception ex){
            throw ex;
        }
        return listStudent;
    }
    
    public boolean StudentInsert(clsStudent student) throws Exception{
        boolean result = false;
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
            sql.append(student.getBacHoc()).append("',')");
            sql.append(student.getNote()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            result = stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
        return result;
    }



    public boolean StudentCheckExistCode(String code) throws Exception{
      boolean result = false;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student Where MSSV = '").append(code).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && (rs.next()))
                result = true;
            stmt.close();
        }catch(Exception ex){
                throw ex;
        }
        return result;
}
   public void LecturerDelete(String code) throws Exception{
        try{
    StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.student Where MSSV = '").append(code).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
  }
    public void StudentUpdateByAdmin(clsStudent student) throws Exception{
      try{
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
            sql.append(" Note=''");
            sql.append(" Where MSSV='").append(student.getCode()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
  }
     public void StudentUpdateByStudent(String info, String MSSV) throws Exception{
      try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.student set Note = '").append(info).append("'");
            sql.append(" Where MSSV='").append(MSSV).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
  }
}
