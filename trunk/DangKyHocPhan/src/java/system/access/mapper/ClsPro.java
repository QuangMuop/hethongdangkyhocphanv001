/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.access.mapper;

import java.sql.PreparedStatement;

/**
 *
 * @author Ultimate
 */
public class ClsPro extends clsMapperDb {
    public ClsPro() throws Exception{
        super();
    }
public void ProInsert(int pro) throws Exception{
    try {
            StringBuffer sql = new StringBuffer();
            sql.append("Insert into dangkyhocphan.pro values(").append(pro).append(")");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.execute();
            stmt.close();
        }
        catch (Exception e) {
                throw e;
        }
}
}
