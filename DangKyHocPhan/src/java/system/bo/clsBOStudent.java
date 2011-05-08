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
        clsMapperStudent student=new clsMapperStudent();
        return student.getStudentInfoByCode(MSSV);
     }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
     public clsStudent getStudentInfoByName(String name) throws Exception{
         clsMapperStudent student=new clsMapperStudent();
        return student.getStudentInfoByName(name);
     }
}
