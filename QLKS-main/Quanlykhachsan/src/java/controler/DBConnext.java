/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DBConnext {
    
    protected Connection conn = null;

    public DBConnext() {
        try {
            String dbURL = "jdbc:sqlserver://TRUONG\\TRUONG:1433;DatabaseName=Quan_ly_khach_san1;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String pass = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, user, pass);
        }
        catch (SQLException | ClassNotFoundException ex){
            System.out.println(ex);
        }
       
    }
}
