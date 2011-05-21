

package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import system.dto.clsClass;
import system.dto.clsStudent;
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
            classs.setNumTC(Integer.parseInt(rs.getString("NumTC")));
            classs.setTestDate(rs.getString("TestDate"));
            classs.setTestTime(rs.getString("TestTime"));
            classs.setTestRoom(rs.getString("TestRoom"));
            classs.setSubName(rs.getString("SubName"));
            classs.setLectureName(rs.getString("FullName"));
         }
     }
     
    
     public ArrayList<clsClass> GetAllClass(String strOrderBy) throws Exception{
         ArrayList<clsClass> listResult = new ArrayList<clsClass>();
         try{
            StringBuffer sql = new StringBuffer();
            sql.append("select ClassName,dangkyhocphan.class.SubCode,FullName,SubName,NumTC, LectuerCode, DateOfWeek, Room, NumOfStudent, Time, TestDate, TestTime, TestRoom from dangkyhocphan.class, dangkyhocphan.subject, dangkyhocphan.lecturer where class.SubCode=subject.SubCode and dangkyhocphan.class.LectuerCode=dangkyhocphan.lecturer.LectuterCode order by ");
           // sql.append("select * from dangkyhocphan.class order by ");
            sql.append(strOrderBy);
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsClass classTemp = new clsClass();
                IniClassDTOFromRs(classTemp, rs);
                listResult.add(classTemp);
            }
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
     }

    
     public clsClass getClassinfo(String classname) throws Exception{
         clsClass classDTO=new clsClass();
        try{
            StringBuffer sql = new StringBuffer();
           sql.append("select ClassName,dangkyhocphan.class.SubCode,FullName, SubName,NumTC, LectuerCode, DateOfWeek, Room, NumOfStudent, Time, TestDate, TestTime, TestRoom from dangkyhocphan.class, dangkyhocphan.subject, dangkyhocphan.lecturer where class.SubCode=subject.SubCode and dangkyhocphan.class.LectuerCode=dangkyhocphan.lecturer.LectuterCode and ");
            sql.append(" Classname = '").append(classname).append("'");
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
private boolean  CheckDateRoomTime(clsClass classDTO) throws Exception{
     try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.class Where DateOfWeek = '");
            sql.append(classDTO.getDate()).append("' and Room='");
            sql.append(classDTO.getRoom()).append("' and Time=");
            sql.append(classDTO.getShift()).append("");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && (rs.next()))
                return true;
            stmt.close();
        }catch(Exception ex){
                throw ex;
        }
    return false;
}
private boolean  CheckLecDateTime(clsClass classDTO) throws Exception{
   try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.class Where DateOfWeek = '");
            sql.append(classDTO.getDate()).append("' and LectuerCode='");
            sql.append(classDTO.getLectureCode()).append("' and Time=");
            sql.append(classDTO.getShift()).append("");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && (rs.next()))
                return true;
            stmt.close();
        }catch(Exception ex){
                throw ex;
        }
    return false;
}
     /**
      *
      * @param classDTO
      * @return: 1 ton tai, 2 trung phong-ngay-ca, 3 trung Gv-Ngay-Ca
      * @throws Exception
      */
     public int ClassInsert(clsClass classDTO) throws Exception{
         if(ClassCheckExits(classDTO.getClassName())) return 1;
         else if(CheckDateRoomTime(classDTO)) return 2;
         else if(CheckLecDateTime(classDTO)) return 3;
         else{
           try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.class values('");
            sql.append(classDTO.getClassName()).append("','");
            sql.append(classDTO.getSubCode()).append("','");
            sql.append(classDTO.getLectureCode()).append("','");
            sql.append(classDTO.getDate()).append("','");
            sql.append(classDTO.getRoom()).append("',");
            sql.append(classDTO.getNumOfStudent()).append(",");
            sql.append(classDTO.getShift()).append(",'");
            sql.append(classDTO.getTestDate()).append("','");
            sql.append(classDTO.getTestTime()).append("','");
            sql.append(classDTO.getTestRoom()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
            return 0;
        }
        catch (Exception e) {
                throw e;
        }
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
     public void ClassUpdateInfo(clsClass classDTO) throws Exception{
           try{
            StringBuffer sql = new StringBuffer();
            sql.append(" Update dangkyhocphan.class set LectuerCode='");
            sql.append(classDTO.getLectureCode()).append("',");
            sql.append(" DateOfWeek='").append(classDTO.getDate()).append("',");
            sql.append(" Room='").append(classDTO.getRoom()).append("',");
            sql.append(" Time=").append(classDTO.getShift());
            sql.append(" where ClassName='").append(classDTO.getClassName()).append("'");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
      public void ClassUpdateTest(clsClass classDTO) throws Exception{
           try{
            StringBuffer sql = new StringBuffer();
            sql.append(" Update dangkyhocphan.class set TestDate='");
            sql.append(classDTO.getTestDate()).append("',");
            sql.append(" TestTime='").append(classDTO.getTestTime()).append("',");
            sql.append(" TestRoom='").append(classDTO.getTestRoom()).append("'");
            sql.append(" where ClassName='").append(classDTO.getClassName()).append("'");
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
     public ArrayList<clsStudent> getAllStudentOfClass(String Classname) throws Exception{
          ArrayList<clsStudent> listResult = new ArrayList<clsStudent>();
         try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select dangkyhocphan.student.MSSV,FullName,Class from dangkyhocphan.student, dangkyhocphan.registry where dangkyhocphan.student.MSSV=dangkyhocphan.registry.MSSV and dangkyhocphan.registry.ClassName='");
            sql.append(Classname).append("' ");
             PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsStudent classTemp = new clsStudent();
                classTemp.setCode(rs.getString("MSSV"));
                classTemp.setFullName(rs.getString("FullName"));
                classTemp.setClass(rs.getString("Class"));
                listResult.add(classTemp);
            }
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
     }
}
