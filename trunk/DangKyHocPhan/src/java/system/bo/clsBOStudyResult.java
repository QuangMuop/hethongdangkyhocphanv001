

package system.bo;

import java.util.ArrayList;
import system.access.mapper.clsMapperStudyResult;
import system.dto.clsStudyResult;

/**
 *
 * @author Ultimate
 */
public class clsBOStudyResult {

    public ArrayList<clsStudyResult> getYear(String MSSV) throws Exception{
        clsMapperStudyResult mps=new clsMapperStudyResult();
        return mps.getYear(MSSV);
    }

    public void Insert(clsStudyResult studyresult) throws Exception{
        clsMapperStudyResult mapper = new clsMapperStudyResult();
        mapper.StudyResultnInsert(studyresult);
    }
}
