
package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.clsSubject;
public class clsMapperSubject extends clsMapperDb {
public clsMapperSubject() throws Exception{
    super();
}
public void IniSubjectDTOFromRs(clsSubject subject, ResultSet rs) throws SQLException{
         if((rs!=null) && (subject!=null)){
            subject.setSubName(rs.getString("SubName"));
            subject.setSubCode(rs.getString("SubCode"));
            subject.setNumTC(Integer.parseInt(rs.getString("NumTC")));
            subject.setTCLT(Integer.parseInt(rs.getString("NumTCLT")));
            subject.setTCTH(Integer.parseInt(rs.getString("NumTCTH")));
        }
     }
public clsSubject getSubjectinfoByName(String subname) throws Exception{
         clsSubject subject=new clsSubject();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.subject Where");
            sql.append(" SubName = '").append(subname).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniSubjectDTOFromRs(subject, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return subject;
     }
public clsSubject getSubjectinfoByCode(String subcode) throws Exception{
         clsSubject subject=new clsSubject();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.subject Where");
            sql.append(" SubCode = '").append(subcode).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniSubjectDTOFromRs(subject, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return subject;
     }
 public void SubjectInsert(clsSubject subject) throws Exception{
         try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.subject values('");
            sql.append(subject.getSubName()).append("','");
            sql.append(subject.getSubCode()).append("',");
            sql.append(subject.getNumTC()).append(",");
            sql.append(subject.getTCLT()).append(",");
            sql.append(subject.getTCTH()).append(")");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
     }
  public boolean SubCheckExitsByName(String subname) throws Exception{
         boolean result = false;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.subject Where SubName = '").append(subname).append("'");
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
  public boolean SubCheckExitsByCode(String subcode) throws Exception{
         boolean result = false;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.subject Where SubCode = '").append(subcode).append("'");
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
  public void SubjectDeleteByName(String subname) throws Exception{
          try{
    StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.subject Where subname = '").append(subname).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
   public void SubjectDeleteByCode(String subcode) throws Exception{
          try{
    StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.subject Where subcode = '").append(subcode).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
   public void SubjectUpdateByName(clsSubject subject) throws Exception{
           try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.subject set SubCode = '").append(subject.getSubCode()).append("',");
            sql.append(" NumTC=").append(subject.getNumTC()).append(",");
            sql.append(" NumTCLT=").append(subject.getTCLT()).append(",");
            sql.append(" NumTCTH=").append(subject.getTCTH()).append(",");
            sql.append(" where SubName='").append(subject.getSubName()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
    public void SubjectUpdateByCode(clsSubject subject) throws Exception{
           try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.subject set SubName = '").append(subject.getSubName()).append("',");
            sql.append(" NumTC=").append(subject.getNumTC()).append(",");
            sql.append(" NumTCLT=").append(subject.getTCLT()).append(",");
            sql.append(" NumTCTH=").append(subject.getTCTH()).append(",");
            sql.append(" where SubCode='").append(subject.getSubCode()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
}
