

package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.clsComment;
public class clsMapperComment extends clsMapperDb{
public clsMapperComment() throws Exception{
    super();
}
 public void IniCommnetDTOFromRs(clsComment comment, ResultSet rs) throws SQLException{
         if((rs!=null) && (comment!=null)){
            comment.setId(Integer.parseInt(rs.getString("Id")));
            comment.setContent(rs.getString("Content"));
            comment.setAuthor(rs.getString("Author"));
            comment.setEmail(rs.getString("Email"));
            comment.setDate(rs.getString("Date"));
          }
     }
  public clsComment getCommnetInfo(int id) throws Exception{
         clsComment comment=new clsComment();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.comment Where");
            sql.append(" Id = ").append(id);
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniCommnetDTOFromRs(comment, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return comment;
     }
  public void CommentInsert(clsComment commnet) throws Exception{
       try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.comment values(");
            sql.append(commnet.getId()).append(",'");
            sql.append(commnet.getContent()).append("','");
            sql.append(commnet.getAuthor()).append("','");
            sql.append(commnet.getEmail()).append("','");
            sql.append(commnet.getDate()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
  }
 public void CommentDelete(int id) throws Exception{
          try{
    StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.comment Where Id = ").append(id);
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
     }
 public int getMaxId() throws SQLException{
     String a="";
    StringBuffer sql = new StringBuffer();
            sql.append("Select Max(Id) from dangkyhocphan.comment ");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                a=rs.getString("Max(Id)");
            }
      return Integer.parseInt(a);
 }
}
