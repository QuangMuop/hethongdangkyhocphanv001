

package system.bo;
import system.access.mapper.clsMapperComment;
import system.dto.clsComment;
public class clsBOComment {
public void CommnetInsert(clsComment commnet) throws Exception{
    clsMapperComment mpcoment=new clsMapperComment();
    mpcoment.CommentInsert(commnet);
}
}
