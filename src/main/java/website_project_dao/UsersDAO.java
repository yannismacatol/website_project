package website_project_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import website_project_model.Users;

public class UsersDAO{
	
	//Establish Connection
	/*private Connection createConnection() {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","user","pass");
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	//User Authentication
	public boolean authenticateLogin(Users user) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","user","pass");){
				
				PreparedStatement statement = c.prepareStatement("SELECT id FROM users_db.users WHERE username = ? AND password = ?");
				
				statement.setString(1, user.getUsername());
				statement.setString(2, user.getPassword());
				
				boolean r =  statement.executeQuery().isBeforeFirst();
				
				System.out.println(statement.executeQuery().isBeforeFirst());
				System.out.println(statement.executeQuery().next());
				return r;
				
			} catch (SQLException e){
				e.printStackTrace();
				return false;	
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;	
		}
	
	}
}
