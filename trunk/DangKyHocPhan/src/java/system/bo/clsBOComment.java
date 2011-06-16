

package system.bo;
import java.util.ArrayList;
import system.access.mapper.clsMapperComment;
import system.dto.clsComment;
public class clsBOComment {
public void CommnetInsert(clsComment commnet) throws Exception{
    clsMapperComment mpcoment=new clsMapperComment();
    mpcoment.CommentInsert(commnet);
}
public ArrayList<clsComment> getAllComment() throws Exception{
    clsMapperComment mpcoment=new clsMapperComment();
    return mpcoment.GetAllComment();
}
public void deleteComment(int Id) throws Exception{
    clsMapperComment MPC=new clsMapperComment();
    MPC.CommentDelete(Id);
}
public clsComment getCommentInfo(int Id) throws Exception{
     clsMapperComment MPC=new clsMapperComment();
    return MPC.getCommnetInfo(Id);
}
}
