package system.bo;

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
}
