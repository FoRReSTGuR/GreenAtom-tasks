package first_task;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class create_db {

	//Delete table in database if exists to avoid repeats
	public static void deleteTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:test.db";	
        
        // SQL statement for deleting a table
        String sql = "DROP TABLE IF EXISTS employees";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // delete table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	
    /**
     * Create database
     * 
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    //Create table in database
 	public static void createNewTable() {
         // SQLite connection string
         String url = "jdbc:sqlite:test.db";
         
         // SQL statement for creating a new table
         String sql = "CREATE TABLE IF NOT EXISTS employees (\n"
                 + "	id integer PRIMARY KEY,\n"
                 + "	surname varchar NOT NULL,\n"
                 + "	experience number \n"
                 + ");";
         
         try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
             // create a new table
             stmt.execute(sql);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
    
 	
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String surname, int experience) {
        String sql = "INSERT INTO employees(surname,experience) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, surname);
            pstmt.setInt(2, experience);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
    	deleteTable();
    	createNewDatabase("test.db");	
    	createNewTable();
    	
        create_db app = new create_db();
        // insert three new rows
        app.insert("Иванов", 10);
        app.insert("Петров", 12);
        app.insert("Сидоров", 14);
    }
}


