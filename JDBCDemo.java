/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemo;

/**
 *
 * @author ajay
 */
import java.sql.*;


public class JDBCDemo {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{ 
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
        try{
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test5", "app", "app");
        Statement stmt = con.createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM APP.CUSTOMER where customer_id=1");
        
        while (rs.next()) {
        String s = rs.getString("Name");
        float n = rs.getFloat("zip");
        System.out.println(s + "   " + n);
    }
        }catch(SQLException e){
            System.err.println(e);
        }                 
     
      }

}