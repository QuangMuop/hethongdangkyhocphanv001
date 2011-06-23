
package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            studyresult.setYear(rs.getString("Year"));
            studyresult.setSemester(Integer.parseInt(rs.getString("Semester")));
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
            sql.append("Select * from dangkyhocphan.studyresult, dangkyhocphan.student Where dangkyhocphan.studyresult.MSSV=dangkyhocphan.student.MSSV and ");
            sql.append("dangkyhocphan.student.FullName = '").append(name).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            return rs;
        }catch(Exception ex){
            throw ex;
        }

}


    public ArrayList<clsStudyResult> GetListStudyResult(String mssv, String year) throws Exception{
        ArrayList<clsStudyResult> listResult = new ArrayList<clsStudyResult>();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.studyresult Where MSSV = '");
            sql.append(mssv).append("'");
            //sql.append(" And Year = '").append(year).append("'");
            //sql.append("order by Year");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();

            while((rs != null) && (rs.next())){
                clsStudyResult str = new clsStudyResult();
                IniStudyResultDTOFromRs(str, rs);
                listResult.add(str);
            }

        }catch(Exception ex){
            throw ex;
        }
        return listResult;
    }


      public void StudyResultnInsert(clsStudyResult studyresult) throws Exception{
         if(StudyResultCheckExits(studyresult)){
            StudyResultUpdateMark(studyresult);              
         }else{
         try {
             StringBuffer sql = new StringBuffer();
             sql.append("Insert into dangkyhocphan.studyresult values('");
             sql.append(studyresult.getStudentCode()).append("','");
             sql.append(studyresult.getSubjectCode()).append("',");
             sql.append(studyresult.getMark()).append(",'");
             sql.append(studyresult.getYear()).append("',");
             sql.append(studyresult.getSemester()).append(")");
             PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
             stmt.execute();
             stmt.close();
         }
         catch (Exception e) {
             throw e;
         }
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
            sql.append(res.getStudentCode()).append("' and SubCode='");
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
   private float getMark(clsStudyResult res) throws Exception{
     float mark=0;
     if(StudyResultCheckExits(res)){
         StringBuffer sql = new StringBuffer();
            sql.append("select Mark from dangkyhocphan.studyresult where MSSV='");
            sql.append(res.getStudentCode()).append("' and subcode='");
            sql.append(res.getSubjectCode()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && (rs.next()))
                mark = Float.parseFloat(rs.getString("Mark"));
            return mark;
     }
     else return mark;
 }
 public void StudyResultUpdateMark(clsStudyResult res) throws Exception{
      float curentMark=getMark(res);
      if(res.getMark()>curentMark){
      try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.studyresult set Mark =");
            sql.append(res.getMark()).append(", Semester=");
            sql.append(res.getSemester()).append(", Year='");
            sql.append(res.getYear()).append("' where MSSV='");
            sql.append(res.getStudentCode()).append("' and SubCode='");
            sql.append(res.getSubjectCode()).append("' ");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
      }
  }
  public ArrayList<clsStudyResult> getYear(String MSSV) throws Exception{
      ArrayList<clsStudyResult> sr=new ArrayList<clsStudyResult>();
      try{
            StringBuffer sql = new StringBuffer();
            sql.append("select DISTINCT Year from dangkyhocphan.studyresult where MSSV='");
            sql.append(MSSV).append("' ");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
             while((rs!=null) && rs.next()){
                clsStudyResult classTemp = new clsStudyResult();
               classTemp.setYear(rs.getString("Year"));
                sr.add(classTemp);
            }
           stmt.close();
        }catch(Exception ex){
                throw ex;
        }
      return sr;
  }
}
