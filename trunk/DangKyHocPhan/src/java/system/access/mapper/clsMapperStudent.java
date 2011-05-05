

package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.clsStudent;
public class clsMapperStudent extends clsMapperDb{
public clsMapperStudent() throws Exception{
    super();
}
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
            student.setIsStuding(Integer.parseInt(rs.getString("IsStuding")));
            student.setCourse(Integer.parseInt(rs.getString("CourseCode")));

         }
     }
 public clsStudent getStudentInfoByCode(String MSSV) throws Exception{
     clsStudent student=new clsStudent();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.student Where ");
            sql.append("MSSV = '").append(MSSV).append("'");//có dấu tiếng việt thì chưa lấy được
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
  public void StudentInsert(clsStudent student) throws Exception{
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
            sql.append(student.getHome()).append("',");
            sql.append(student.getIsStuding()).append(",");
            sql.append(student.getCourse()).append(")");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
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
    public void StudentUpdate(clsStudent student) throws Exception{
      try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.lecturer set FullName = '").append(student.getFullname()).append("',");
            sql.append(" BirthDay='").append(student.getBirthDay()).append("',");
            sql.append(" Class='").append(student.getClasss()).append("',");
            sql.append(" Email='").append(student.getEmail()).append("',");
            sql.append(" Phone='").append(student.getPhone()).append("',");
            sql.append(" Address='").append(student.getAddress()).append("',");
            sql.append(" Home='").append(student.getHome()).append("',");
            sql.append(" IsStuding=").append(student.getIsStuding()).append(",");
            sql.append(" CourseCode=").append(student.getCourse());
            sql.append(" Where MSSV='").append(student.getCode()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
  }
}
