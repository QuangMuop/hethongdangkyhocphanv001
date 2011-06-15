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
      public ArrayList<clsStudent> getStudentsByCode(String Code) throws Exception{
        clsMapperStudent mapper = new clsMapperStudent();
        return mapper.getStudentsByCode(Code);
    }
     /**
      *
      * @return
      * @throws Exception
      */

    public ArrayList<clsStudent> GetAllStudent() throws Exception{
        clsMapperStudent mapper = new clsMapperStudent();
        return mapper.GetAllStudent();
    }
       /**
     * Get all student in a class by name of class
     * @param className name of class for search
     * @param strOrder Order by condition
     * @return list of student in class
     * @throws Exception
     */
    public ArrayList<clsStudent> GetStudentsByClass(String className)throws Exception{
        clsMapperStudent mapper = new clsMapperStudent();
        return mapper.GetStudentsByClass(className);
    }

     /**
      *
      * @param student
      * @return
      * @throws Exception
      */
      public boolean Insert(clsStudent student) throws Exception{
           clsMapperStudent mapper = new clsMapperStudent();
          return  mapper.StudentInsert(student);
         
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
      public boolean Delete(String mssv) throws Exception{
          clsMapperStudent mapper = new clsMapperStudent();
           return mapper.Delete(mssv);
        
      }


     public void updateStudentByStudent(String updateinfo, String code) throws Exception{
         clsMapperStudent mps=new clsMapperStudent();
         mps.StudentUpdateByStudent(updateinfo, code);
     }
     public void updateStudentByAmin(clsStudent cls) throws Exception{
         clsMapperStudent mps=new clsMapperStudent();
         mps.StudentUpdateByAdmin(cls);
     }
}
