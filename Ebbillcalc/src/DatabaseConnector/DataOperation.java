package DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DataOperation {

	
		// TODO Auto-generated method stub
		public static void addData() {
	        try (Connection conn = DatabaseConnector.getConnection()) {
	            String insertQuery = "INSERT INTO login (id, username, password) VALUES (?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(insertQuery);
	            Scanner sc = new Scanner(System.in);

	            System.out.print("Enter ID: ");
	            int id = sc.nextInt();
	            sc.nextLine(); // Consume the newline character
	            System.out.print("Enter Username: ");
	            String username = sc.nextLine();
	            System.out.print("Enter Password: ");
	            String password = sc.nextLine();

	            statement.setInt(1, id);
	            statement.setString(2, username);
	            statement.setString(3, password);

	            int rowsInserted = statement.executeUpdate();
	           

	            if (rowsInserted > 0) {
	                System.out.println("Record added successfully.");
	            } else {
	                System.out.println("Failed to add record.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    
	    public static void viewData() {
	        try (Connection conn = DatabaseConnector.getConnection()) {
	            String selectQuery = "SELECT id, username, password FROM login";
	            PreparedStatement statement = conn.prepareStatement(selectQuery);

	            ResultSet resultSet = statement.executeQuery();

	            System.out.println("ID\tUsername\tPassword");

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String username = resultSet.getString("username");
	                String password = resultSet.getString("password");
	                System.out.println(id + "\t" + username + "\t" + password);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    public static void updateData() {
	        try (Connection conn = DatabaseConnector.getConnection()) {
	            String updateQuery = "UPDATE login SET username = ?, password = ? WHERE id = ?";
	            PreparedStatement statement = conn.prepareStatement(updateQuery);

	            Scanner sc = new Scanner(System.in);

	            System.out.print("Enter ID to update: ");
	            int id = sc.nextInt();
	            sc.nextLine(); // Consume the newline character
	            System.out.print("Enter new Username: ");
	            String newUsername = sc.nextLine();
	            System.out.print("Enter new Password: ");
	            String newPassword = sc.nextLine();

	            statement.setString(1, newUsername);
	            statement.setString(2, newPassword);
	            statement.setInt(3, id);

	            int rowsUpdated = statement.executeUpdate();

	            if (rowsUpdated > 0) {
	                System.out.println("Record updated successfully.");
	            } else {
	                System.out.println("No records updated. ID not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    public static void deleteData() {
	        try (Connection conn = DatabaseConnector.getConnection()) {
	            String deleteQuery = "DELETE FROM login WHERE id = ?";
	            PreparedStatement statement = conn.prepareStatement(deleteQuery);

	            Scanner sc = new Scanner(System.in);

	            System.out.print("Enter ID to delete: ");
	            int id = sc.nextInt();

	            statement.setInt(1, id);

	            int rowsDeleted = statement.executeUpdate();

	            if (rowsDeleted > 0) {
	                System.out.println("Record deleted successfully.");
	            } else {
	                System.out.println("No records deleted. ID not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}

