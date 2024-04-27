/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DBConnection {
    public static Connection Connect(){
        Connection connect = null;

        //đăng ký drive 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=ManageStudent;user=sa;password=123456; encrypt=false; trustServerCertificate=true; characterEncoding=UTF-8";
            connect = DriverManager.getConnection(connectionURL);

        } catch (ClassNotFoundException  | SQLException e) {
             System.out.println(e.getMessage());
            e.getStackTrace();
        }
        return connect;
    }
//    public void disConnect(){
//        try {
//            connect.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public Connection getConnect(){
//        return this.connect;
//    }
    /**
     * @param args the command line arguments
     */

    
}
