

package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import system.dto.clsProgram;
public class clsMapperProgram extends clsMapperDb {
    public clsMapperProgram() throws Exception{
        super();
    }
public void IniProgramDTOFromRs(clsProgram prog, ResultSet rs) throws SQLException{
         if((rs!=null) && (prog!=null)){
            prog.setProgramCode(Integer.parseInt(rs.getString("ProCode")));
            prog.setSubjectCode(rs.getString("SubCode"));
            prog.setSemester(Integer.parseInt(rs.getString("Semester")));
            prog.setSubName(rs.getString("SubName"));

         }
     }
  public ArrayList<clsProgram> GetAllProByCode(int procode) throws Exception{
        ArrayList<clsProgram> listpro = new ArrayList<clsProgram>();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select ProCode, program.SubCode, SubName, Semester from dangkyhocphan.program, dangkyhocphan.subject where program.SubCode=subject.SubCode and ProCode=");
            sql.append(procode).append(" order by Semester");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsProgram pro = new clsProgram();
                IniProgramDTOFromRs(pro, rs);
                listpro.add(pro);
            }
        }catch(Exception ex){
            throw ex;
        }
        return listpro;
    }
 public ArrayList<Integer> GetAllProCode() throws Exception{
         ArrayList<Integer> listResult = new ArrayList<Integer>();
         try{
            StringBuffer sql = new StringBuffer();
            sql.append("select DISTINCT ProCode from dangkyhocphan.program");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                listResult.add(Integer.parseInt(rs.getString("Procode")));
            }
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
     }
public void ProgramInsert(clsProgram prog) throws Exception{
    try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.program values(");
            sql.append(prog.getProgramCode()).append(",'");
            sql.append(prog.getSubjectCode()).append("',");
            sql.append(prog.getSemester()).append(")");
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
