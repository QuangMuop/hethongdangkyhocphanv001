

package system.access.mapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.dto.clsNews;

public class clsMapperNews extends clsMapperDb {
    public clsMapperNews() throws Exception{
        super();
    }
   public void IniNewsDTOFromRs(clsNews news, ResultSet rs) throws SQLException{
         if((rs!=null) && (news!=null)){
            news.setId(Integer.parseInt(rs.getString("ID")));
            news.setContent(rs.getString("Content"));
            news.setAuthor(rs.getString("Author"));
            news.setDate(rs.getString("Date"));
         }
     }
   public clsNews getNewsInfo(int id) throws Exception{
       clsNews news=new clsNews();
        try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.news Where ");
            sql.append("Id = ").append(id);
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && rs.next()){
                IniNewsDTOFromRs(news, rs);
            }
        }catch(Exception ex){
            throw ex;
        }
        return news;
   }
   public void NewsInsert(clsNews news) throws Exception{
       try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.news values(");
            sql.append(news.getId()).append(",'");
            sql.append(news.getContent()).append("','");
            sql.append(news.getAuthor()).append("','");
            sql.append(news.getDate()).append("')");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
   }
   public boolean NewCheckExits(int id) throws Exception{
       boolean result = false;
       try{
            StringBuffer sql = new StringBuffer();
            sql.append("Select * from dangkyhocphan.news Where Id = ").append(id);
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            ResultSet rs = stmt.executeQuery();
            if((rs!=null) && (rs.next()))
                result = true;
            stmt.close();
        }catch(Exception ex){
                throw ex;
        }
        return result;
   }
   public void NewsDelete(int id) throws Exception{
        try{
    StringBuffer sql = new StringBuffer();
            sql.append("Delete from dangkyhocphan.news Where Id = ").append(id);
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
        }catch(Exception ex){
                throw ex;
        }
   }
}
