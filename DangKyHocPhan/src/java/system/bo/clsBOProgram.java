package system.bo;

import java.util.ArrayList;
import system.access.mapper.clsMapperAccount;
import system.access.mapper.clsMapperProgram;

/**
 *
 * @author ngloc_it
 */
public class clsBOProgram {
public ArrayList<Integer> getAllProCode() throws Exception{
    clsMapperProgram MPP=new clsMapperProgram();
    return MPP.GetAllProCode();
}
}
