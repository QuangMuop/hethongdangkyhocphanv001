package system.bo;

import system.access.mapper.clsMapperLecturer;
import system.dto.clsLecturer;

/**
 *
 * @author ngloc_it
 */
public class clsBOLecturer {
    
    /**
     * Get a lecturer object from name of teacher
     * @param name name for search
     * @return an Lecturer object
     * @throws Exception
     */
    public clsLecturer getLecturerInfo(String name) throws Exception{
        clsLecturer lecturer = new clsLecturer();
        try{
            clsMapperLecturer mapper = new clsMapperLecturer();
            lecturer = mapper.getLecturerInfo(name);
        }catch(Exception e){
            throw e;
        }
        return lecturer;
    }

    /**
     * Get lecturer from his id
     * @param lecturerId id for search
     * @return lecturere object get from database or null if not found any instance
     * @throws Exception
     */
    public clsLecturer getLecturereByCode(String lecturerId) throws Exception{
        clsLecturer lecturer = new clsLecturer();
        try{
            clsMapperLecturer mapper = new clsMapperLecturer();
            lecturer = mapper.getLecturerInfoById(lecturerId);
        }catch(Exception e){
            throw e;
        }
        return lecturer;
    }

    /**
     * Insert a lecturer into database
     * @param lecturer Lecturer for insert
     * @throws Exception
     */
    public void LecturerInsert(clsLecturer lecturer) throws Exception{
         try{
            clsMapperLecturer mapper = new clsMapperLecturer();
            mapper.LecturerInsert(lecturer);
        }catch(Exception e){
            throw e;
        }
    }

    /**
     * Check if a lecturer existed in database by his name
     * @param name lecturer for check
     * @return true if existed and false if not
     * @throws Exception
     */
    public boolean LecturerCheckExistName(String name) throws Exception{
        boolean result = false;
        try{
            clsMapperLecturer mapper = new clsMapperLecturer();
            result = mapper.LecturerCheckExistName(name);
        }catch(Exception e){
            throw e;
        }
        return result;
    }

    /**
     * Get a name of a lecturer by his id
     * @param id id for search
     * @return name of lecturer with code is id or null if not found
     */
    public String LecturerGetLecturerNameFromId(String id) throws Exception{
        String result = "";
        try{
            clsMapperLecturer mapper = new clsMapperLecturer();
            clsLecturer lecture = mapper.getLecturerInfoById(id);
            result = lecture.getFullname();
        }catch(Exception e){
            throw e;
        }
        return result;
    }

    /**
     * Check if a lecturer existed in database by his id
     * @param code Id for check
     * @return tru if existed and false if not
     * @throws Exception
     */
    public boolean LecturerCheckExistCode(String code) throws Exception{
        boolean result = false;
        try{
            clsMapperLecturer mapper = new clsMapperLecturer();
            result = mapper.LecturerCheckExistCode(code);
        }catch(Exception e){
            throw e;
        }
        return result;
    }

    /**
     *
     * @param name
     * @throws Exception
     */
    public void LecturerDeleteByName(String name) throws Exception{
    
    }
    
    /**
     * 
     * @param code
     * @throws Exception
     */
    public void LecturerDeleteByCode(String code) throws Exception{
    
    }

    /**
     *
     * @param lecturer
     * @throws Exception
     */
    public void LecturerUpdate(clsLecturer lecturer) throws Exception{
    }
}
