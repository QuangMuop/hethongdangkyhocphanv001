package system.bo;

import java.util.ArrayList;
import system.access.mapper.clsMapperAccount;
import system.access.mapper.clsMapperProgram;
import system.dto.clsProgram;

public class clsBOProgram {

    public ArrayList<Integer> getAllProCode() throws Exception {
        clsMapperProgram MPP = new clsMapperProgram();
        return MPP.GetAllProCode();
    }

    public ArrayList<clsProgram> getAllProByCode(int Procode) throws Exception {
        clsMapperProgram MPP = new clsMapperProgram();
        return MPP.GetAllProByCode(Procode);
    }

    public void InsertPro(clsProgram pro) throws Exception {
        clsMapperProgram mpp = new clsMapperProgram();
        mpp.ProgramInsert(pro);
    }

    public void DeletePro(clsProgram pro) throws Exception {
        clsMapperProgram mpp = new clsMapperProgram();
        mpp.ProgramDelete(pro);
    }
}
