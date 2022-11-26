package com.malay.dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private String url= "jdbc:mysql://localhost:3306/products";
	private String userID= "root";
	private String password= "root";
	
	Connection connection;

	public DBConnector() {
		// Step 1 : Register Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		// Step 2 :  get connection object
			
			this.connection=DriverManager.getConnection(url, userID, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
}
