package DatabaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Companies";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root1234";
	
	
	public static Connection getConnection() throws SQLException {
	    try {
	        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	    } catch (SQLException e) {
	        throw new SQLException("Failed to establish a database connection: " + e.getMessage());
	    }
	}
	

	public static void closeConnection(Connection connection) {
	    if (connection != null) {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            
	        }
	    }
	}



}
