package com.malay.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String url="jdbc:mysql://localhost:3306/products";
	private String userID="root";
	private String password="root";
	
	private Connection connection;

	public DBConnection() {
		
		// Step 1: Register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2: Get Connection Object
			this.connection= DriverManager.getConnection(url, userID, password);
			
		} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		
		return this.connection;
	}
	
	
	
}
