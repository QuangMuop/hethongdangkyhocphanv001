

package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.*;
public class clsMapperDetailSubject extends clsMapperDb {
    public clsMapperDetailSubject() throws Exception{
        super();
    }
     public void IniClassDTOFromRs(clsDetailSubject detailsubject, ResultSet rs) throws SQLException{
         if((rs!=null) && (detailsubject!=null)){
            detailsubject.setSubjectCode(rs.getString("SubCode"));
            detailsubject.setPreSubjectCode(rs.getString("PreSubCode"));
         }
     }
public clsDetailSubject getDetailSubjectInfo(String SubjectCode) throws Exception{
 clsDetailSubject detailsubjectDTO=new clsDetailSubject();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.subjectdetail Where");
            sql.append(" SubCode = '").append(SubjectCode).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniClassDTOFromRs(detailsubjectDTO, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return detailsubjectDTO;
}
public void DetailSubjectInsert(clsDetailSubject detailsubjectDTO) throws Exception{
    try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.subjectdetail values('");
            sql.append(detailsubjectDTO.getSubjectCode()).append("','");
            sql.append(detailsubjectDTO.getPreSubjectCode()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
}
public void DetailSubjectDelete(String subjectdetail) throws Exception{
      try{
    StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.subjectdetail Where SubCode = '").append(subjectdetail).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
}
public boolean DetailSubjectCheckExits(String subcode) throws Exception{
     boolean result = false;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.subjectdetail Where SubCode = '").append(subcode).append("'");
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
