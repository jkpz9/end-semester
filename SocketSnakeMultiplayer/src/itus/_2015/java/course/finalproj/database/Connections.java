package itus._2015.java.course.finalproj.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connections {
    public static String DATABASE_NAME = "SnakeGameDB";
    public static String USERNAME = "hewittking";
    public static String PASSWORD = "password";
    public static String URL_MYSQL = "jdbc:mysql://localhost:3306/"+DATABASE_NAME + "?autoReconnect=true&useSSL=false";
     public static Connection Newconnect(){
        Connection conn = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL_MYSQL, USERNAME, PASSWORD);
            System.out.println("Connect successfull");
        } catch (SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
      
    }
     
     public static void main(String[] args)
     {
         Connection con = Connections.Newconnect();
         System.out.println(con != null);
     }
}
