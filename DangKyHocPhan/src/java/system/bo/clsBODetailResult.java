

package system.bo;

import java.util.ArrayList;
import system.access.mapper.clsMapperDetailResult;
import system.dto.clsDetailResult;


public class clsBODetailResult {
public ArrayList<clsDetailResult> getResult(String MSSV,String year, int semester) throws Exception{
    clsMapperDetailResult mpdr=new clsMapperDetailResult();
    return mpdr.getResult(MSSV, year, semester);
}
}
