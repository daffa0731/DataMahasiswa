/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pert3;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;


/**
 *
 * @author Daffa
 */
public class koneksi {
    static Connection c;
    
    public static Connection connection(){
         if(c==null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("mhs");
            data.setUser("root");
            data.setPassword("");
            try{
                c = (Connection) data.getConnection();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return c;
}
}
