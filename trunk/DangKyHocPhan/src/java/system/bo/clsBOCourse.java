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
     public boolean CourseInsert(clsCourse cls) throws Exception{
         clsMapperCourse mpc=new clsMapperCourse();
         return mpc.CourseInsert(cls);
     }
}
