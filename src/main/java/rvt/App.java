package rvt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class App {
    public static void main(String[] args) {
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:data.db");
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("create table todo (id integer, task string)");
        } catch (SQLException e) {
           
        }
    }
}
