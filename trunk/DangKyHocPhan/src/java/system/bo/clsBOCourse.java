package system.bo;

import java.util.ArrayList;
import system.access.mapper.clsMapperCourse;
import system.dto.clsCourse;

/**
 *
 * @author ngloc_it
 */
public class clsBOCourse {
    /**
     * Get list course in database
     * @return
     * @throws Exception
     */
     public ArrayList<clsCourse> GetAllCorse() throws Exception{
        try{
            clsMapperCourse mapper = new clsMapperCourse();
            return mapper.GetAllCorse();
        }catch(Exception ex){
            throw ex;
        }
    }
     public boolean CourseInsert(clsCourse cls, String Classname) throws Exception{
         clsMapperCourse mpc=new clsMapperCourse();
         return mpc.CourseInsert(cls,Classname);
     }
     public ArrayList<String> getAllClassName() throws Exception{
          clsMapperCourse mpc=new clsMapperCourse();
         return mpc.getAllClassName();
     }

}
