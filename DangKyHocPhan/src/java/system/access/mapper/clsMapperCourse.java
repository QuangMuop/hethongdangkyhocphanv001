
package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import system.dto.*;
public class clsMapperCourse extends clsMapperDb {
    public clsMapperCourse() throws Exception{
        super();
    }
    
    public void IniCourseDTOFromRs(clsCourse course, ResultSet rs) throws SQLException{
        if((rs!=null) && (course!=null)){
            course.SetCourseCode(Integer.parseInt(rs.getString("CourseCode")));
            course.setYearIn(Integer.parseInt(rs.getString("YearIn")));
            course.setYearOut(Integer.parseInt(rs.getString("YearOut")));
            course.setNumOfStudent(Integer.parseInt(rs.getString("NumOfStudent")));
            course.setProgramCode(Integer.parseInt(rs.getString("ProCode")));
        }
    }
    
    
    public clsCourse getCourseInfo(int  coursecode) throws Exception{
        clsCourse courseDTO=new clsCourse();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.Course Where");
            sql.append(" CourseCode = ").append(coursecode).append("");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniCourseDTOFromRs(courseDTO, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return courseDTO;
    }

    public ArrayList<clsCourse> GetAllCorse() throws Exception{
        ArrayList<clsCourse> listCourse = new ArrayList<clsCourse>();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.Course");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            while((rs!=null) && rs.next()){
                clsCourse course = new clsCourse();
                IniCourseDTOFromRs(course, rs);
                listCourse.add(course);
            }
        }catch(Exception ex){
            throw ex;
        }
        return listCourse;
    }
    
    public void CourseInsert(clsCourse courseDTO) throws Exception{
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.Course values(");
            sql.append(courseDTO.getCourseCode()).append(",");
            sql.append(courseDTO.getYearIn()).append(",");
            sql.append(courseDTO.getYearOut()).append(",");
            sql.append(courseDTO.getNumOfStudent()).append(",");
            sql.append(courseDTO.getProgramCode()).append(") ");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
    }
    
    public boolean CourseCheckExits(int coursecode) throws Exception{
        boolean result = false;
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.course Where coursecode = ").append(coursecode).append("");
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
    
    public void CourseDelete(int coursecode) throws Exception{
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.course Where CourseCode = ").append(coursecode).append("");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
    }
    
    public void CourseUpdate(clsCourse courseDTO) throws Exception{
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Update dangkyhocphan.course set YearOut = ").append(courseDTO.getYearOut()).append(",");
            sql.append("NumOfStudent=").append(courseDTO.getNumOfStudent()).append(",");
            sql.append("ProCode=").append(courseDTO.getProgramCode()).append(",");
            sql.append("where CourseCode=").append(courseDTO.getCourseCode()).append("");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
    }
}
