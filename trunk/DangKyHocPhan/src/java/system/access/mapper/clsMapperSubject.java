package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ArrayList<clsSubject> GetListSubject()throws Exception{
        ArrayList<clsSubject> listResult = new ArrayList<clsSubject>();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.subject order by SubName");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsSubject subject = new clsSubject();
                IniSubjectDTOFromRs(subject, rs);
                listResult.add(subject);
            }
        }catch(Exception ex){
            throw ex;
        }
        return listResult;        
    }
    
    public clsSubject getSubjectinfoByCode(String subcode) throws Exception{
        clsSubject subject=new clsSubject();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.subject Where SubCode='");
            sql.append(subcode).append("'");
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
    public int getNumTCByClassName(String classname) throws Exception{
        int numTC=0;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("select NumTC from dangkyhocphan.subject, dangkyhocphan.class where dangkyhocphan.subject.SubCode=dangkyhocphan.class.SubCode and dangkyhocphan.class.ClassName='");
            sql.append(classname).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
               numTC=Integer.parseInt(rs.getString("NumTC"));
            }
        }catch(Exception ex){
            throw ex;
        }
        return numTC;
    }
    public int SubjectInsert(clsSubject subject) throws Exception{
        if(SubCheckExitsByName(subject.getSubName())) return 1;//subname already exist
        else if(SubCheckExitsByCode(subject.getSubCode())) return 2;// subcode already exist
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
            return 0;
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
    
    public boolean  SubjectDeleteByCode(String subcode) throws Exception{
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.subject Where SubCode = '").append(subcode).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            return true;
        }catch(Exception ex){
                return  false;
        }
    }
    public ArrayList<clsSubject> SearchSubjectByName(String subname) throws Exception{
         ArrayList<clsSubject> listResult = new ArrayList<clsSubject>();
         try{
            StringBuffer sql = new StringBuffer();
            sql.append("select * from dangkyhocphan.subject where dangkyhocphan.subject.SubName like '");
            sql.append(subname).append("%' order by SubName");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsSubject classTemp = new clsSubject();
                IniSubjectDTOFromRs(classTemp, rs);
                listResult.add(classTemp);
            }
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
     }
    
    public void SubjectUpdate(clsSubject subject) throws Exception{
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("update dangkyhocphan.subject set NumTC=");
            sql.append(subject.getNumTC()).append(", NumTCLT=");
            sql.append(subject.getTCLT()).append(", NumTCTH=");
            sql.append(subject.getTCTH()).append(" where SubCode='");
            sql.append(subject.getSubCode()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
}