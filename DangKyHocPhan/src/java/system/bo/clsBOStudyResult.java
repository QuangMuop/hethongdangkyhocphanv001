

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

    /**
     * Get result of student
     * @param mssv id of student whom getting result
     * @return list result order by year
     * @throws Exception
     */
    public ArrayList<clsStudyResult> GetListStudyResult(String mssv, String year) throws Exception{
        try{
            clsMapperStudyResult mapper = new clsMapperStudyResult();
            return mapper.GetListStudyResult(mssv, year);
        }catch(Exception ex){
            throw ex;
        }
    }
}
