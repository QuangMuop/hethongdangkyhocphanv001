

package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.clsClass;
public class clsMapperClass extends clsMapperDb{
     public clsMapperClass() throws Exception{
        super();
}
     public void IniClassDTOFromRs(clsClass classs, ResultSet rs) throws SQLException{
         if((rs!=null) && (classs!=null)){
            classs.setClassName(rs.getString("ClassName"));
            classs.setSubCode(rs.getString("SubCode"));
            classs.setLecturer(rs.getString("LectuerCode"));
            classs.setDate(rs.getString("DateOfWeek"));
            classs.setRoom(rs.getString("Room"));
            classs.setNumOfStudent(Integer.parseInt(rs.getString("NumOfStudent")));
            classs.setShift(Integer.parseInt(rs.getString("Time")));
         }
     }
     public clsClass getClassinfo(String classname) throws Exception{
         clsClass classDTO=new clsClass();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.class Where");
            sql.append(" ClassName = '").append(classname).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniClassDTOFromRs(classDTO, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return classDTO;
     }
     public void ClassInsert(clsClass classDTO) throws Exception{
         try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.class values('");
            sql.append(classDTO.getClassName()).append("','");
            sql.append(classDTO.getSubCode()).append("','");
            sql.append(classDTO.getLectureCode()).append("','");
            sql.append(classDTO.getDate()).append("','");
            sql.append(classDTO.getRoom()).append("',");
            sql.append(classDTO.getNumOfStudent()).append(",");
            sql.append(classDTO.getShift()).append(" ) ");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
     }
     public boolean ClassCheckExits(String classname) throws Exception{
         boolean result = false;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.class Where ClassName = '").append(classname).append("'");
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
     public void ClassDelete(String classname) throws Exception{
          try{
    StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.class Where ClassName = '").append(classname).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
     public void ClassUpdate(clsClass classDTO) throws Exception{
           try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.class set SubCode = '").append(classDTO.getSubCode()).append("',");
            sql.append("LectuerCode='").append(classDTO.getLectureCode()).append("',");
            sql.append("DateOfWeek='").append(classDTO.getDate()).append("',");
            sql.append("Room='").append(classDTO.getRoom()).append("',");
            sql.append("Time=").append(classDTO.getShift()).append("");
            sql.append("where ClassName='").append(classDTO.getClassName()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
     public void ClassUpdateStudent(String classname) throws Exception{
         try{
    StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.class set NumOfStudent=NumOfStudent+1 where ClassName='").append(classname).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
}