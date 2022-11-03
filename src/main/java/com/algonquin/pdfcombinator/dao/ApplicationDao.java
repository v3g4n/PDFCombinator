package com.algonquin.pdfcombinator.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.algonquin.pdfcombinator.beans.User;

public class ApplicationDao {
	
	private final String COL_ID = "uuid"; // column 1
	private final String COL_FIRST_NAME = "first_name"; // column 2
	private final String COL_LAST_NAME = "last_name";
	private final String COL_USERNAME = "username";
	private final String COL_PASSWORD = "password";
	private final String COL_EMAIL = "email";
	private final String COL_ACTIVE	 = "is_active"; // column 7
	private final String COL_CODE = "code";
	private final String COL_NEW_EMAIL = "new_email";
	
	
	public int registerUser(User user, String code) {
		
		int rowsAffected = 0;
		
		try {
			//connect to DB
			Connection connection = DBConnection.connectToDB();
			
			//write insert query to DB
			String insertQuery = "INSERT INTO users (uuid, first_name, last_name, username, password, new_email, code ) VALUES(?,?,?,?,?,?,?)";
			
			//set parameters with PreparedStatement
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getID().toString());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getUserName());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmail());
			statement.setString(7, code);
	
			
			//execute statement
			rowsAffected = statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}
	
	
	public boolean verifyEmail(String id, String code) {
		boolean verified = false;
		
		// connect to DB
		Connection connection = DBConnection.connectToDB();
		
		// Query DB
		String query = "SELECT * FROM users WHERE uuid = ? AND code = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			statement.setString(2,  code);
			
			// retrieve result
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				verified = true;
			}
			

		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return verified;
	}
	
	
	
	public boolean isUsernameAvailable(String username) {
		boolean available = false;
		
		try {
			//connect to DB
			Connection connection = DBConnection.connectToDB();
			
			//write insert query to DB
			String query = "SELECT * FROM users WHERE username = ?";
			
			//set parameters with PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
					
			//execute statement
			ResultSet result = statement.executeQuery();
			if (!result.next()) {
				available = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return available;
	}

	public User getUserByUsername(String username) {
		
		User user = new User();
		
		// connect to DB
		Connection connection = DBConnection.connectToDB();
		
		// Query DB
		String query = "SELECT * FROM users WHERE username = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, username);
			
			// retrieve result
			ResultSet result = statement.executeQuery();
			result.first();
			String id = result.getString(COL_ID);
			String password = result.getString(COL_PASSWORD);
			String firstName = result.getString(COL_FIRST_NAME);
			String lastName = result.getString(COL_LAST_NAME);
			String email = result.getString(COL_EMAIL);
			
			// Load result into user bean
			user.setId(id);
			user.setUserName(username);
			user.setEmail(email);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPassword(password);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

		// Return user object
		return user;
	}
	
	public boolean activateAccount(String id) {
		boolean activated = false;
		
		//connect to DB
		Connection connection = DBConnection.connectToDB();
		
		//write insert query to DB
		String query = "UPDATE users SET is_active = 1 WHERE uuid = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 1) {
				activated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("User account activated: " + activated);
		
		return activated;
		
	}
	
	public boolean isActiveUser(String username) {
		boolean isActive = false;
		
		try {
			//connect to DB
			Connection connection = DBConnection.connectToDB();
			
			//write insert query to DB
			String query = "SELECT * FROM users WHERE username = ?";
			
			
			//set parameters with PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, username);
					
			//execute statement
			ResultSet result = statement.executeQuery();
			result.first();
			if (result.getInt(COL_ACTIVE) == 1) {
				isActive = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isActive;
		
	}
	
	public boolean validateUser(String username, String password) {
		boolean validated = false;
		
		// connect to DB
		Connection connection = DBConnection.connectToDB();
		
		// Query DB
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2,  password);
			
			// retrieve result
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				validated = true;
			}
			

		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return validated;
	}
	

	public boolean updateUsername(String oldUsername, String newUsername) {
		boolean success = false;
		if (isUsernameAvailable(newUsername)) {
			
			//connect to DB
			Connection connection = DBConnection.connectToDB();
			
			//write insert query to DB
			String query = "UPDATE users SET username = ? WHERE username = ?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, newUsername);
				statement.setString(2, oldUsername);
				
				int rowsAffected = statement.executeUpdate();
				if (rowsAffected == 1) {
					success = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
		
	}
	
	public boolean updateFirstName(String username, String newFirstName) {
		boolean success = false;
		//connect to DB
		Connection connection = DBConnection.connectToDB();
		
		//write insert query to DB
		String query = "UPDATE users SET first_name = ? WHERE username = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newFirstName);
			statement.setString(2, username);
			
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 1) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
		
	}
	
	public boolean updateLastName(String username, String newLastName) {
		boolean success = false;
		//connect to DB
		Connection connection = DBConnection.connectToDB();
		
		//write insert query to DB
		String query = "UPDATE users SET last_name = ? WHERE username = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newLastName);
			statement.setString(2, username);
			
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 1) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
		
	}
	
	public boolean updateEmail(String username, String newEmail) {
		boolean success = false;
		//connect to DB
		Connection connection = DBConnection.connectToDB();
		
		//write insert query to DB
		String query = "UPDATE users SET new_email = ? WHERE username = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, newEmail);
			statement.setString(2, username);
			
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 1) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;		
	}
	
	public boolean updateVerifiedEmail(String id, String code) {
		boolean success = false;
		//connect to DB
		Connection connection = DBConnection.connectToDB();
		
		// select query to retrieve new email
		
		String newEmail = "";
		String selectQuery = "SELECT new_email FROM users WHERE uuid = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(selectQuery);
			statement.setString(1, id);
			
			// retrieve result
			ResultSet set = statement.executeQuery();
			if (set.next()) {
				newEmail = set.getString("new_email");
				System.out.println("We retrieved the new email address: " + newEmail);
			}
			

		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		//write insert query to DB
		String updateQuery = "UPDATE users SET email = ?, new_email = NULL WHERE uuid = ? AND code = ?";
		
		try {
			PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
			updateStatement.setString(1, newEmail);
			updateStatement.setString(2, id);
			updateStatement.setString(3, code);
			
			int rowsAffected = updateStatement.executeUpdate();
			if (rowsAffected == 1) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.activateAccount(id);
		
		System.out.println("Updated verified email: " + success);
		return success;		
	}

	public boolean updateCode(String username, String code) {
		boolean success = false;
		//connect to DB
		Connection connection = DBConnection.connectToDB();
		
		//write insert query to DB
		String query = "UPDATE users SET code = ? WHERE username = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, code);
			statement.setString(2, username);
			
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 1) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return success;
		
	}
	
	
	
}
