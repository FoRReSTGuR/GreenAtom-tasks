package first_task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class select_data {
	
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
     * Select data using sql request
     *
     * Print selected data
     */
    public void selectAll() {
    	String sql = "SELECT surname FROM employees ORDER BY experience DESC LIMIT 1 OFFSET 1";
    	
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
				System.out.println(rs.getString("surname"));
			}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
 
    public static void main(String[] args) {    	
        select_data app = new select_data();
        app.selectAll();
    }
}


