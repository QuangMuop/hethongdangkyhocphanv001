package system.bo;

import java.util.ArrayList;
import system.access.mapper.clsMapperRegistration;

/**
 *
 * @author ngloc_it
 */
public class clsBORegistration {
    /**
      *
      * @param className
      * @return
      * @throws Exception
      */
     public ArrayList<String> getListStudentIdFromClassName(String className) throws Exception{
        try{
            clsMapperRegistration mapper = new clsMapperRegistration();
            return mapper.getListStudentIdFromClassName(className);
        }catch(Exception ex){
            throw ex;
        }
     }
}
