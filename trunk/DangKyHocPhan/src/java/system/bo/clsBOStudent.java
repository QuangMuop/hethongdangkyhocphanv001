package system.bo;

import java.util.ArrayList;
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

     public ArrayList<clsStudent> getStudentsByName(String name) throws Exception{
        clsMapperStudent mapper = new clsMapperStudent();
        return mapper.getStudentsByName(name);
    }

     /**
      * searh all student in database
      * @param strWhere search condition
      * @param strOrder order by codition
      * @return list of student found
      * @throws Exception
      */
    public ArrayList<clsStudent> GetAllStudent(String strOrder) throws Exception{
        clsMapperStudent mapper = new clsMapperStudent();
        return mapper.GetAllStudent(strOrder);
    }

    /**
     * Get all student in a class by name of class
     * @param className name of class for search
     * @param strOrder Order by condition
     * @return list of student in class
     * @throws Exception
     */
    public ArrayList<clsStudent> GetStudentsByClass(String className, String strOrder)throws Exception{
        clsMapperStudent mapper = new clsMapperStudent();
        return mapper.GetStudentsByClass(className, strOrder);
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

      /**
       * Delete a student by student id (mssv)
       * @param mssv
       * @throws Exception
       */
      public void Delete(String mssv) throws Exception{
        try{
            clsMapperStudent mapper = new clsMapperStudent();
            mapper.Delete(mssv);
        }catch(Exception ex){
            throw ex;
        }
      }


     public void updateStudentByStudent(String updateinfo, String code) throws Exception{
         clsMapperStudent mps=new clsMapperStudent();
         mps.StudentUpdateByStudent(updateinfo, code);
     }
}
