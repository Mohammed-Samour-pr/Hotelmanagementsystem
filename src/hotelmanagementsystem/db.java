/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author USER
 */
import java.sql.*;
import javax.swing.*;

public class db {

    Connection conn = null;

    public static Connection java_db() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:hotel_db.sqlite");
            JOptionPane.showMessageDialog(null, "Connection to database is successful");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Connection get_Connection() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:hotel_db.sqlite");
            JOptionPane.showMessageDialog(null, "Connection to database is successful");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
