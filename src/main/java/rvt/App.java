package rvt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class App {
    public static void main(String[] args) {
        
        try(
        Connection conn = DriverManager.getConnection("jdbc:sqlite:todo.db"); 
        Statement stmt = conn.createStatement();) {
            
            
            String sql = "CREATE TABLE IF NOT EXISTS todo" + " (id integer PRIMARY KEY, task TEXT NOT NULL) STRICT";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
}
