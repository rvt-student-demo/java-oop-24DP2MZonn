package rvt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rvt.Diagrams.C;
public class TodoDB {
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public TodoDB(){
        initshema();
    }
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void initshema(){
        String sql = "CREATE TABLE IF NOT EXISTS todo" + " (id integer PRIMARY KEY, task TEXT NOT NULL) STRICT";
        try(Connection conn = connect(); Statement stmt = conn.createStatement();) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
           throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }
    
    public List<Strings> tasks findAll(){}

    public void addTask(String task) {

        String sql1 = "INSERT INTO todo(task) VALUES(task)";
        try(Connection conn = connect(); Statement stmt = conn.createStatement();) {
            stmt.executeUpdate(sql1);
        } catch (SQLException e) {
           throw new RuntimeException("Schema init failed: " + e.getMessage());
        }
    }
    public
    }


