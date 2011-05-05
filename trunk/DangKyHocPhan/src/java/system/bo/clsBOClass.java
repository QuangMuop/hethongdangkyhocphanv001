package system.bo;

import system.access.mapper.clsMapperClass;
import system.dto.clsClass;

/**
 *
 * @author ngloc_it
 */
public class clsBOClass {
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
     * Insert a new class into table class in database
     * @param classDTO Object to insert
     * @throws Exception
     */
     public void ClassInsert(clsClass classDTO) throws Exception{
        try{
            clsMapperClass mapper = new clsMapperClass();
            mapper.ClassInsert(classDTO);
        }catch(Exception e){
            throw e;
        }
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
     public void ClassDelete(String classname) throws Exception{
        try{
            clsMapperClass mapper = new clsMapperClass();
            mapper.ClassDelete(classname);
        }catch(Exception e){
            throw e;
        }
     }

     /**
      * Update data for ...
      * @param classDTO
      * @throws Exception
      */
     public void ClassUpdate(clsClass classDTO) throws Exception{

     }

     /**
      *
      * @param classname
      * @throws Exception
      */
     public void ClassUpdateStudent(String classname) throws Exception{

     }
}
