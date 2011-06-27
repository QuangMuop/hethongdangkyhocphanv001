package system.communication.database;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ngloc_it
 */
public class ConnectionServer {

    public static Connection getConnection() throws NamingException, SQLException {
        DataSource ds = (DataSource) new InitialContext().lookup("pooldangkyhocphan");
        Connection con = ds.getConnection();
        return con;
    }
}
