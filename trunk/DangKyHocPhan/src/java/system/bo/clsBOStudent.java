package system.bo;

import java.util.logging.Level;
import java.util.logging.Logger;
import system.access.mapper.clsMapperStudent;
import system.dto.clsStudent;

/**
 *
 * @author ngloc_it
 */
public class clsBOStudent {

    /**
     * 
     * @param MSSV
     * @return
     * @throws Exception
     */
    public clsStudent getStudentInfoByCode(String MSSV) throws Exception{
        try{
            clsMapperStudent mapper = new clsMapperStudent();
            return mapper.getStudentInfoByCode(MSSV);
        }catch(Exception ex){
            throw ex;
        }        
     }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
     public clsStudent getStudentInfoByName(String name) throws Exception{
         clsStudent student=new clsStudent();
            try{
                clsMapperStudent mapper = new clsMapperStudent();
                return mapper.getStudentInfoByName(name);
            }catch(Exception ex){
                throw ex;
         }
    }
     

     /**
      * Insert infomation of a student into database
      * @param student data for insert into databse
      * @return true if insert successfull, false for othewise
      * @throws Exception
      */
      public boolean Insert(clsStudent student) throws Exception{
          boolean result = false;
          clsMapperStudent mapper = new clsMapperStudent();
          result = mapper.StudentInsert(student);
          return result;
      }

      /**
       *
       * @param MSSV
       * @return
       * @throws Exception
       */
      public boolean CheckExistedCode(String MSSV) throws Exception{
          clsMapperStudent mapper = new clsMapperStudent();
          return mapper.StudentCheckExistCode(MSSV);                
      }
     public void updateStudentByStudent(String updateinfo, String code) throws Exception{
         clsMapperStudent mps=new clsMapperStudent();
         mps.StudentUpdateByStudent(updateinfo, code);
     }
}
