package system.bo;

import java.util.ArrayList;
import system.access.mapper.clsMapperClass;
import system.dto.clsClass;
import system.dto.clsStudent;

/**
 *
 * @author ngloc_it
 */
public class clsBOClass {

    /**
     * Get all class were opened
     * @return
     * @throws Exception
     */
     public ArrayList<clsClass> GetAllClass(String strOrderBy) throws Exception{
         ArrayList<clsClass> listResult = new ArrayList<clsClass>();
         try{
            clsMapperClass mapper = new clsMapperClass();
            listResult = mapper.GetAllClass(strOrderBy);
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
     }
    public ArrayList<clsClass> GetAllClassByLecturer(String Leccode) throws Exception{
         ArrayList<clsClass> listResult = new ArrayList<clsClass>();
         try{
            clsMapperClass mapper = new clsMapperClass();
            listResult = mapper.GetAllClassByLecturer(Leccode);
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
     }
     public ArrayList<clsClass> GetAllClassBySub(String subcode) throws Exception{
         ArrayList<clsClass> listResult = new ArrayList<clsClass>();
         try{
            clsMapperClass mapper = new clsMapperClass();
            listResult = mapper.GetAllClassBySubname(subcode);
         }catch(Exception ex){
            throw ex;
         }
         return listResult;
     }

    /**
     * Get Class Object from class name
     * @param classname Class Name
     * @return Class Object which have name classname or NULL if not found
     * @throws Exception
     */
    public clsClass getClassinfo(String classname) throws Exception{
         try{
            clsMapperClass mapper = new clsMapperClass();
            return mapper.getClassinfo(classname);
        }catch(Exception e){
            throw e;
        }
     }

    /**
     * Get a class object from it's name
     * @param classId: name (code) of class
     * @return
     * @throws Exception
     */
    public clsClass getClassFromId(String classId) throws Exception{
         try{
            clsMapperClass mapper = new clsMapperClass();
            return mapper.getClassinfo(classId);
        }catch(Exception e){
            throw e;
        }
    }

    /**
     * Insert a new class into table class in database
     * @param classDTO Object to insert
     * @throws Exception
     */
     public int  ClassInsert(clsClass classDTO) throws Exception{
            clsMapperClass mapper = new clsMapperClass();
          return mapper.ClassInsert(classDTO);
       
     }

     /**
      * Check if one class existed in database
      * @param classname class name for check
      * @return true if this class is already existed and false for other
      * @throws Exception
      */
     public boolean ClassCheckExits(String classname) throws Exception{
         boolean result = false;
         try{
             clsMapperClass mapper = new clsMapperClass();
             result = mapper.ClassCheckExits(classname);
        }catch(Exception e){
            throw e;
        }
        return result;
     }

     /**
      * Delete a class in database by class name
      * @param classname which class will be delete
      * @throws Exception
      */
     public boolean  ClassDelete(String classname) throws Exception{
        try{
            clsMapperClass mapper = new clsMapperClass();
            mapper.ClassDelete(classname);
            return true;
        }catch(Exception e){
            return false;
        }
     }

     /**
      * Update data for ...
      * @param classDTO
      * @throws Exception
      */
     public void ClassUpdateInfo(clsClass classDTO) throws Exception{
      clsMapperClass mpc=new clsMapperClass();
      mpc.ClassUpdateInfo(classDTO);
     }
     public ArrayList<clsStudent> getAllStudentOfClass(String classname) throws Exception{
         clsMapperClass mpc=new clsMapperClass();
         return mpc.getAllStudentOfClass(classname);
     }
     public void UpdateTestTime(clsClass cls) throws Exception{
         clsMapperClass mpc=new clsMapperClass();
         mpc.ClassUpdateTest(cls);
     }
     public void resetTest(String Classname) throws Exception{
          clsMapperClass mpc=new clsMapperClass();
         mpc.ResetTest(Classname);
     }
     /**
      *
      * @param classname
      * @throws Exception
      */
     public void ClassUpdateStudent(String classname) throws Exception{

     }
}
