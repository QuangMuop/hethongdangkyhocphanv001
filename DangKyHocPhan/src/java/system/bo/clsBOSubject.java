package system.bo;

import system.access.mapper.clsMapperSubject;
import system.dto.clsSubject;

/**
 *
 * @author ngloc_it
 */
public class clsBOSubject {

    /**
     * Get an Subject object by it's name
     * @param subname Name for search
     * @return Subject found or null
     * @throws Exception
     */
    public clsSubject getSubjectinfoByName(String subname) throws Exception{        
        try{
            clsMapperSubject mapper = new clsMapperSubject();
            return mapper.getSubjectinfoByName(subname);
        }catch(Exception ex){
            throw ex;
        }        
     }

    /**
     * Get an Subject object by it's Id
     * @param subcode Id for search
     * @return Subject found or null
     * @throws Exception
     */
    public clsSubject getSubjectinfoByCode(String subcode) throws Exception{
        try{
            clsMapperSubject mapper = new clsMapperSubject();
            return mapper.getSubjectinfoByCode(subcode);
        }catch(Exception ex){
            throw ex;
        }
     }

    /**
     * Get name of a subject with it's code
     * @param subcode
     * @return
     * @throws Exception
     */
    public String getSubjectNameByCode(String subcode) throws Exception{
        String result = "";
        try{
            clsMapperSubject mapper = new clsMapperSubject();
            clsSubject subject = mapper.getSubjectinfoByCode(subcode);
            result = subject.getSubName();
        }catch(Exception ex){
            throw ex;
        }
        return result;
    }

    /**
     *
     * @param subject
     * @throws Exception
     */
    public void SubjectInsert(clsSubject subject) throws Exception{

     }

    /**
     * Check if one subject's name is already existed in databse
     * @param subname Name for test
     * @return true if existed and false for other
     * @throws Exception
     */
    public boolean SubCheckExitsByName(String subname) throws Exception{
        boolean result = false;
         try{
            clsMapperSubject mapper = new clsMapperSubject();
            result = mapper.SubCheckExitsByName(subname);
        }catch(Exception ex){
            throw ex;
        }
        return result;
     }
    
    /**
     * Check if one subject's id is already existed in database
     * @param subcode id for test
     * @return true if existed and false for other
     * @throws Exception
     */
    public boolean SubCheckExitsByCode(String subcode) throws Exception{
        boolean result = false;
         try{
            clsMapperSubject mapper = new clsMapperSubject();
            result = mapper.SubCheckExitsByCode(subcode);
        }catch(Exception ex){
            throw ex;
        }
        return result;
     }

    /**
     *
     * @param subname
     * @throws Exception
     */
    public void SubjectDeleteByName(String subname) throws Exception{
    }

    /**
     *
     * @param subcode
     * @throws Exception
     */
    public void SubjectDeleteByCode(String subcode) throws Exception{
    }


    /**
     *
     * @param subject
     * @throws Exception
     */
    public void SubjectUpdateByName(clsSubject subject) throws Exception{
    }


    /**
     *
     * @param subject
     * @throws Exception
     */
    public void SubjectUpdateByCode(clsSubject subject) throws Exception{
    }
}
