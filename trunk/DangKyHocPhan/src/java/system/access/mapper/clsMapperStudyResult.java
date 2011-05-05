
package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.clsStudyResult;

public class clsMapperStudyResult extends clsMapperDb {
   public clsMapperStudyResult() throws Exception{
    super();
}
public void IniStudyResultDTOFromRs(clsStudyResult studyresult, ResultSet rs) throws SQLException{
         if((rs!=null) && (studyresult!=null)){
            studyresult.setStudentCode(rs.getString("MSSV"));
            studyresult.setSubjectCode(rs.getString("SubCode"));
            studyresult.setMark(Float.parseFloat(rs.getString("Mark")));
         }
     }
public ResultSet getStudyResultInfoByCode(String MSSV) throws Exception{
     try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.studyresult Where ");
            sql.append("MSSV = '").append(MSSV).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            return rs;
        }catch(Exception ex){
            throw ex;
        }

}
public ResultSet getStudyResultInfoByName(String name) throws Exception{
     try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.studyresult Where ");
            sql.append("FullName = '").append(name).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            return rs;
        }catch(Exception ex){
            throw ex;
        }

}
 public void StudyResultnInsert(clsStudyResult studyresult) throws Exception{
       try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.studyresult values('");
            sql.append(studyresult.getStudentCode()).append("','");
            sql.append(studyresult.getSubjectCode()).append("',");
            sql.append(studyresult.getMark()).append(")");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
   }
  public void RegistrationDelete(clsStudyResult res) throws Exception{
       try{
    StringBuffer sql = new StringBuffer();
            sql.append("delete from dangkyhocphan.studyresult where MSSV='");
            sql.append(res.getStudentCode()).append("' and SubCode='");
            sql.append(res.getSubjectCode()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
}
  public boolean StudyResultCheckExits(clsStudyResult res) throws Exception{
     boolean result = false;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.studyresult Where MSSV ='");
            sql.append(res.getStudentCode()).append("' and ClassName='");
            sql.append(res.getSubjectCode()).append("'");
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
  public void StudyResultUpdateMark(clsStudyResult res) throws Exception{
      try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.studyresult set Mark =");
            sql.append(res.getMark()).append(" where MSSV='");
            sql.append(res.getStudentCode()).append("' and SubCode='");
            sql.append(res.getSubjectCode()).append("' ");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
  }
}
