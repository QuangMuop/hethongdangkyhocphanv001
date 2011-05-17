
package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import system.dto.clsViewProgram;
public class clsMapperViewProgram extends clsMapperDb{
public clsMapperViewProgram() throws Exception{
    super();
}
public void IniViewProgramDTOFromRs(clsViewProgram program, ResultSet rs, String mssv) throws SQLException, Exception{
         if((rs!=null) && (program!=null)){
             program.setSubCode(rs.getString("SubCode"));
            program.setSubName(rs.getString("SubName"));
            program.setNumTC(Integer.parseInt(rs.getString("NumTC")));
            program.setNumTCLT(Integer.parseInt(rs.getString("NumTCLT")));
            program.setNumTCTH(Integer.parseInt(rs.getString("NumTCLT")));
            program.setSemester(Integer.parseInt(rs.getString("Semester")));
            program.setMark(getMark(mssv, rs.getString("SubCode")));
         }
     }
public float getMark(String mssv, String subcode) throws Exception{
    float result = 0;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("select Mark from dangkyhocphan.studyresult where MSSV='");
            sql.append(mssv).append("' and SubCode='").append(subcode).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && (rs.next())){
                result = Float.parseFloat(rs.getString("Mark"));
           }
            stmt.close();
        }catch(Exception ex){
                throw ex;
        }
        return result;
}
public ArrayList<clsViewProgram> getProgramByCode(String mssv) throws Exception{
       ArrayList<clsViewProgram> pro=new ArrayList<clsViewProgram>();
     try{
            StringBuffer sql = new StringBuffer();
            sql.append("select DISTINCT dangkyhocphan.program.Semester, dangkyhocphan.subject.SubCode, SubName, NumTC, NumTCLT, NumTCLT from dangkyhocphan.subject, dangkyhocphan.course, dangkyhocphan.student,dangkyhocphan.program, dangkyhocphan.studyresult where subject.SubCode=program.SubCode and course.ProCode=program.ProCode and student.CourseCode=course.CourseCode and student.MSSV='");
            sql.append(mssv).append("' order by dangkyhocphan.program.Semester ASC");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsViewProgram classTemp = new clsViewProgram();
                IniViewProgramDTOFromRs(classTemp, rs, mssv);
                pro.add(classTemp);
                
           }
        }catch(Exception ex){
            throw ex;
        }
    return pro;
}
}
