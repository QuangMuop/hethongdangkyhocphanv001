/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package system.access.mapper;

import java.sql.Connection;
import system.communication.database.ConnectionServer;

/**
 *
 * @author Ultimate
 */
public class clsMapperDb {
  private Connection connection;

    public clsMapperDb()throws Exception{
        try{
            connection = ConnectionServer.getConnection();
        }catch(Exception e){
            System.out.println(e.toString());
            throw e;
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection() throws Exception{
        try{
            getConnection().close();
        }catch(Exception e){
            System.out.println(e.toString());
            throw e;
        }
    }
}
