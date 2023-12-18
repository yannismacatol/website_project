package website_project_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import website_project_model.Users;

public class UsersDAO{
	
	//User Authentication.
	public boolean authenticateLogin(Users user) {
		Connection c = createConnection();
		PreparedStatement queryUsernamePassword = null;
		try(c) {
			queryUsernamePassword = c.prepareStatement("SELECT id FROM users_db.users WHERE username = ? AND password = ?");
			
			queryUsernamePassword.setString(1, user.getUsername());
			queryUsernamePassword.setString(2, user.getPassword());
			
			return queryUsernamePassword.executeQuery().next();
			
		} catch (SQLException e){
				e.printStackTrace();
				return false;	
		} finally {
			if(queryUsernamePassword != null)
				closePreparedStatement(queryUsernamePassword);
		}
	}
	
	//Register a new user into database.
	public boolean registerUser(Users user) {
		PreparedStatement addUser = null;
		try(Connection c = createConnection();) {
			
			if(checkUserExists(user, c)) {
				return false;
			}
			else {
				addUser = c.prepareStatement("INSERT INTO users_db.users(username, password) VALUES (?, ?)");
				addUser.setString(1, user.getUsername());
				addUser.setString(2, user.getPassword());
				
				addUser.executeUpdate();
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(addUser != null)
				closePreparedStatement(addUser);
		}
	}
	
	//Establish Connection
	private Connection createConnection() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","user","pass");
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	//Check if the username exists
	private boolean checkUserExists(Users user, Connection c) {
		PreparedStatement selectUsernamePassword = null;
		try(c) {
				selectUsernamePassword = c.prepareStatement("SELECT id FROM users_db.users WHERE username = ?");
				selectUsernamePassword.setString(1, user.getUsername());
				
				return selectUsernamePassword.executeQuery().next();
				
		} catch (SQLException e){
				e.printStackTrace();
				return false;	
		} finally {
			if(selectUsernamePassword != null)
				closePreparedStatement(selectUsernamePassword);
		}
	}
	
	//Close a prepared statement
	private void closePreparedStatement(PreparedStatement s) {
		try {
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	//Function to delete a duplicate from database.
	private void deleteDuplicate(Users user, Connection c) {
		PreparedStatement deleteDuplicate;
		try {
			deleteDuplicate = c.prepareStatement("DELETE FROM users_db.users WHERE username = ? AND password = ?");
			deleteDuplicate.setString(1, user.getUsername());
			deleteDuplicate.setString(2, user.getPassword());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
}
