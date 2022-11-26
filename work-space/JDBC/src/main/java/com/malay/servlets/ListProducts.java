package com.malay.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.malay.util.DBConnection;


public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListProducts() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBConnection dbconnection= new DBConnection();
		Connection connection = dbconnection.getConnection();
		
		
		
		try {
			//step 3 = Create Statement Object
			java.sql.Statement stmt= connection.createStatement();
			
			// Step 4: execute query
			ResultSet rs = stmt.executeQuery("select * from products");
			
			PrintWriter pw = response.getWriter();
			pw.println("<html><body>");
			
			while(rs.next()) {
				
				Integer id= rs.getInt("id");
				String productName= rs.getString("product_name");
				Double productPrice= rs.getDouble("product_price");
				String companyName= rs.getString("company_name");
				
				pw.println(id + " " + productName+" " + productPrice+ " "+ companyName);
				pw.println("<br>");
			}
			
			pw.println("</body></html>");
			
			//Step 5 : Close the Conncetion
			connection.close();
			rs.close();
			pw.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
