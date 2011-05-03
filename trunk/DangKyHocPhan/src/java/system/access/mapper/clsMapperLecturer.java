
package system.access.mapper;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.clsLecturer;
public class clsMapperLecturer extends clsMapperDb {
    public clsMapperLecturer() throws Exception{
        super();
    }
 public void IniLecturerDTOFromRs(clsLecturer lecturer, ResultSet rs) throws SQLException{
         if((rs!=null) && (lecturer!=null)){
            lecturer.setFullName(rs.getString("FullName"));
            lecturer.setLecturerCode(rs.getString("LectuterCode"));
            lecturer.setBirthDay(rs.getString("BirthDay"));
            lecturer.setEmail(rs.getString("Email"));
            lecturer.setPhone(rs.getString("Phone"));
            lecturer.setAddress(rs.getString("Address"));
            lecturer.setHocHam(rs.getString("HocHam"));
            lecturer.setHocVi(rs.getString("Degree"));
         }
     }
 public clsLecturer getLecturerInfo(String name) throws Exception{
     clsLecturer lecturer=new clsLecturer();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.lecturer Where ");
            sql.append("FullName = '").append(name).append("'");//có dấu tiếng việt thì chưa lấy được
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniLecturerDTOFromRs(lecturer, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return lecturer;
 }
 public void LecturerInsert(clsLecturer lecturer) throws Exception{
     try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.lecturer values('");
            sql.append(lecturer.getLecturerCode()).append("','");
            sql.append(lecturer.getFullname()).append("','");
            sql.append(lecturer.getBirthDay()).append("','");
            sql.append(lecturer.getEmail()).append("',");
            sql.append(lecturer.getPhone()).append(",");
            sql.append(lecturer.getAddress()).append("','");
            sql.append(lecturer.getHocHam()).append("','");
            sql.append(lecturer.getHocVi()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
 }
 public boolean LecturerCheckExistName(String name) throws Exception{
      boolean result = false;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.lecturer Where FullName = '").append(name).append("'");
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
  public boolean LecturerCheckExistCode(String code) throws Exception{
      boolean result = false;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.lecturer Where LectuterCode = '").append(code).append("'");
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
  public void LecturerDelete(String name) throws Exception{
        try{
    StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.lecturer Where FullName = '").append(name).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
  }
  public void LecturerUpdate(clsLecturer lecturer) throws Exception{
      try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.lecturer set FullName = '").append(lecturer.getFullname()).append("',");
            sql.append("BirthDay='").append(lecturer.getBirthDay()).append("',");
            sql.append("Email='").append(lecturer.getEmail()).append("',");
            sql.append("Phone='").append(lecturer.getPhone()).append("',");
            sql.append("Address=").append(lecturer.getAddress()).append("");
            sql.append("HocHam='").append(lecturer.getHocHam()).append("'");
            sql.append("Degree='").append(lecturer.getHocVi()).append("'");
            sql.append("Where LectuterCode='").append(lecturer.getLecturerCode()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
  }
}
