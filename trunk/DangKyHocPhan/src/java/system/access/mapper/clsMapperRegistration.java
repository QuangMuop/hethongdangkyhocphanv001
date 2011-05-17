
package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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


     /**
      *
      * @param className
      * @return
      * @throws Exception
      */
     public ArrayList<String> getListStudentIdFromClassName(String className) throws Exception{
        ArrayList<String> listStudentCode = new ArrayList<String>();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.registry Where ");
            sql.append("ClassName = '").append(className);
            sql.append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while(rs!=null && rs.next()){
                String idTemp = rs.getString("MSSV");
                listStudentCode.add(idTemp);
            }
        }catch(Exception ex){
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
     public ArrayList<String> getRegistrationInfo(clsRegistration reg) throws Exception{//lấy chưa được thông tin các lớp học của một sinh viên
      ArrayList<String> result = new ArrayList<String>();
         try{
             StringBuffer sql = new StringBuffer();
             sql.append("Select ClassName from dangkyhocphan.registry Where ");
             sql.append("MSSV = '").append(reg.getStudentCode()).append("' and Semester=");
             sql.append(reg.getSemester()).append(" and Year='");
             sql.append(reg.getYear()).append("'");
             PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
             ResultSet rs = stmt.executeQuery();
               while(rs!=null && rs.next()){
                String idTemp = rs.getString("ClassName");
                result.add(idTemp);
            }
             return result;
         }catch(Exception ex){
             throw ex;
         }
     }
     
     
     /**
      * 
      * @param reg
      * @throws Exception
      */
     public void RegistrationInsert(clsRegistration reg) throws Exception{
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
         }catch (Exception e) {
             throw e;
         }
     }
     
     /**
      * 
      * @param reg
      * @throws Exception
      */
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
     /**
      * 
      * @param MSSV
      * @param semester
      * @param year
      * @throws Exception
      */
     public void DeleteAllRegistry(String MSSV, int semester, String year) throws Exception{
           try{
             StringBuffer sql = new StringBuffer();
             sql.append("delete from dangkyhocphan.registry where MSSV='");
             sql.append(MSSV).append("'  and Semester=");
             sql.append(semester).append(" and Year='");
             sql.append(year).append("'");
             PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
             stmt.execute();
         }catch(Exception ex){
             throw ex;
         }
     }

     /**
      * Delete all subject registed by a student
      * @param mssv id of student you want to delete registration
      * @throws Exception
      */
     public void RegistrationDeleteByStudentId(String mssv) throws Exception{
         try{
             StringBuffer sql = new StringBuffer();
             sql.append("delete from dangkyhocphan.registry where MSSV = '");
             sql.append(mssv).append("'");
             PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
             stmt.execute();
         }catch(Exception ex){
             throw ex;
         }
     }
     
     /**
      * 
      * @param reg
      * @return
      * @throws Exception
      */
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