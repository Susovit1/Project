package hrmanagementsystem;

import java.sql.*;

public class conn {
    
    Connection c;
    Statement s;
    
   public static void main(String[]args)
   {
       conn sc = new conn() ;
   }

    public conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hrmanagementsystem", "root", "");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
