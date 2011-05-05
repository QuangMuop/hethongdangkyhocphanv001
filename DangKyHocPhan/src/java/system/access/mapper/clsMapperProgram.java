

package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.clsProgram;
public class clsMapperProgram extends clsMapperDb {
    public clsMapperProgram() throws Exception{
        super();
    }
public void IniProgramDTOFromRs(clsProgram prog, ResultSet rs) throws SQLException{
         if((rs!=null) && (prog!=null)){
            prog.setProgramCode(Integer.parseInt(rs.getString("ProCode")));
            prog.setSubjectCode(rs.getString("SubCode"));

         }
     }
public ResultSet getProgramInfo(int procode) throws Exception{//lấy chưa được thông tin các môn học của mỗi chương trình
    try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select SubCode from dangkyhocphan.program Where ");
            sql.append("ProCode = ").append(procode);
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            return rs;
        }catch(Exception ex){
            throw ex;
        }
 }
public void ProgramInsert(clsProgram prog) throws Exception{
    try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.program values(");
            sql.append(prog.getProgramCode()).append(",'");
            sql.append(prog.getSubjectCode()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
}
public void ProgramDelete(clsProgram prog) throws Exception{
       try{
    StringBuffer sql = new StringBuffer();
            sql.append("delete from dangkyhocphan.program where ProCode=");
            sql.append(prog.getProgramCode()).append(" and SubCode='");
            sql.append(prog.getSubjectCode()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
}
public boolean ProgramCheckExits(clsProgram prog) throws Exception{
     boolean result = false;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.program Where ProCode =");
            sql.append(prog.getProgramCode()).append(" and SubCode='");
            sql.append(prog.getSubjectCode()).append("'");
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