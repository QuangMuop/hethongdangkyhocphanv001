
package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.clsRegistration;
public class clsMapperRegistration extends clsMapperDb{
public clsMapperRegistration() throws Exception{
    super();
}
 public void IniRegistrationDTOFromRs(clsRegistration reg, ResultSet rs) throws SQLException{
         if((rs!=null) && (reg!=null)){
            reg.setStudentCode(rs.getString("MSSV"));
            reg.setClassName(rs.getString("ClassName"));
            reg.setSemester(Integer.parseInt(rs.getString("Semester")));
            reg.setYear(rs.getString("Year"));
            reg.setMark(Float.parseFloat(rs.getString("Mark")));
         }
     }
public ResultSet getRegistrationInfo(clsRegistration reg) throws Exception{//lấy chưa được thông tin các lớp học của một sinh viên
     try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select ClassName from dangkyhocphan.registry Where ");
            sql.append("MSSV = '").append(reg.getStudentCode()).append("' and Semester=");
            sql.append(reg.getSemester()).append(" and Year='");
            sql.append(reg.getYear()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            return rs;
        }catch(Exception ex){
            throw ex;
        }
        
}
 public void RegistrationInsert(clsRegistration reg) throws Exception{
       try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.registry values('");
            sql.append(reg.getStudentCode()).append("','");
            sql.append(reg.getClassName()).append("',");
            sql.append(reg.getSemester()).append(",'");
            sql.append(reg.getYear()).append("',");
            sql.append(reg.getMark()).append(")");
            
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
   }
 public void RegistrationDelete(clsRegistration reg) throws Exception{
       try{
    StringBuffer sql = new StringBuffer();
            sql.append("delete from dangkyhocphan.registry where MSSV='");
            sql.append(reg.getStudentCode()).append("' and ClassName='");
            sql.append(reg.getClassName()).append("' and Semester=");
            sql.append(reg.getSemester()).append(" and Year='");
            sql.append(reg.getYear()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
}
 public boolean RegistrationCheckExits(clsRegistration reg) throws Exception{
     boolean result = false;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.registry Where MSSV ='");
            sql.append(reg.getStudentCode()).append("' and ClassName='");
            sql.append(reg.getClassName()).append("' and Semester=");
            sql.append(reg.getSemester()).append(" and Year='");
            sql.append(reg.getYear()).append("'");
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
}
