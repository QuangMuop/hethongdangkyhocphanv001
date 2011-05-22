package system.bo;

import java.util.ArrayList;
import system.access.mapper.clsMapperSubject;
import system.dto.clsSubject;

/**
 *
 * @author ngloc_it
 */
public class clsBOSubject {

    /**
     * Get all subject in dsatabse
     * @return list result
     * @throws Exception
     */
    public ArrayList<clsSubject> GetListSubject()throws Exception{
        try{
            clsMapperSubject mapper = new clsMapperSubject();
            return mapper.GetListSubject();
        }catch(Exception ex){
            throw ex;
        }
    }
     public ArrayList<clsSubject> SearchSubjectByName(String subname)throws Exception{
        try{
            clsMapperSubject mapper = new clsMapperSubject();
            return mapper.SearchSubjectByName(subname);
        }catch(Exception ex){
            throw ex;
        }
    }

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
public void updateSubject(clsSubject subject) throws Exception{
    clsMapperSubject mps=new clsMapperSubject();
    mps.SubjectUpdate(subject);
}
    /**
     * Get an Subject object by it's Id
     * @param subcode Id for search
     * @return Subject found or null
     * @throws Exception
     */
public int getNumTCByClassName(String Classname) throws Exception{
     clsMapperSubject mapper = new clsMapperSubject();
     return mapper.getNumTCByClassName(Classname);
}
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
     * @return
     * @throws Exception
     */
    public int SubjectInsert(clsSubject subject) throws Exception{
        clsMapperSubject mps=new clsMapperSubject();
        return mps.SubjectInsert(subject);
     }

    /**
     *
     * @param subname
     * @return
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
    public boolean  SubjectDeleteByCode(String subcode) throws Exception{
        clsMapperSubject mps=new clsMapperSubject();
        return mps.SubjectDeleteByCode(subcode);
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
