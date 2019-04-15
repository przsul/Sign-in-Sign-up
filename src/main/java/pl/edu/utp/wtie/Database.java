package pl.edu.utp.wtie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Database {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/SignInSignUp?useTimezone=true&serverTimezone=UTC";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "projektbazy";
	
	Connection conn = null;
    PreparedStatement stmt = null;
    
    public void connect() {
    	try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void registerUser(String name, String lastName, String login,
    		String pass, String email) {
    	
    	if(name.isEmpty())
    		name = null;
    	if(lastName.isEmpty())
    		lastName = null;
    	if(login.isEmpty())
    		login = null;
    	if(pass.isEmpty())
    		pass = null;
    	if(email.isEmpty())
    		email = null;
    	
		try {
			String sql = "INSERT INTO persons VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, DEFAULT)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, lastName);
			stmt.setString(3, login);
			stmt.setString(4, pass);
			stmt.setString(5, email);
			stmt.setString(6, "User");
			stmt.executeUpdate(); 
			System.out.println("Registering user...");
		} catch (SQLIntegrityConstraintViolationException e) {
			Alert alert = new Alert(AlertType.ERROR, "You need to fulfil every field.", ButtonType.OK);
			alert.showAndWait();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
	public void getData() {
		try {
			System.out.println("Creating statement...");
			String sql;
			sql = "SELECT Login, Password FROM persons";
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);
			
			String login = null;
			String pass = null;
			
			while(rs.next()) {
				login = rs.getString("Login");
				pass = rs.getString("Password");
			}
			
			System.out.println(login + "/" + pass);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
