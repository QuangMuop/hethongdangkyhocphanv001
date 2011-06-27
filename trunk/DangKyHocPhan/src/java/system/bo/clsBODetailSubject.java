package system.bo;

import java.util.ArrayList;
import system.access.mapper.clsMapperDetailSubject;
import system.dto.clsDetailSubject;

/**
 *
 * @author ngloc_it
 */
public class clsBODetailSubject {

    public ArrayList<clsDetailSubject> getListDetailSub() throws Exception {
        clsMapperDetailSubject mpd = new clsMapperDetailSubject();
        return mpd.GetListDetailSubject();
    }

    public void insertDetailSub(clsDetailSubject cls) throws Exception {
        clsMapperDetailSubject mpd = new clsMapperDetailSubject();
        mpd.DetailSubjectInsert(cls);
    }
    public void DeleteDetailSub(clsDetailSubject cls) throws Exception {
        clsMapperDetailSubject mpd = new clsMapperDetailSubject();
        mpd.DetailSubjectDelete(cls);
    }
}
