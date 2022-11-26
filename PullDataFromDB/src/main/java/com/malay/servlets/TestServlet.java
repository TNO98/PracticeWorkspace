package com.malay.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.malay.dbconnector.DBConnector;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBConnector conn=new DBConnector();
		Connection connection = conn.getConnection();
		
		//Step 3 : Create Statement obj 
		
		try {
			Statement stmt = connection.createStatement();
			
			//step 4 : Execute query
			
			ResultSet rs= stmt.executeQuery("select * from products");
			
			PrintWriter pw = response.getWriter();
			pw.println("<html> <body>");
			
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String productName = rs.getString("product_name");
				Double productPrice = rs.getDouble("product_price");
				String companyName = rs.getString("company_name");
				
				pw.println(id+" "+ productName+ " "+ productPrice+ " "+ companyName);
				pw.println("<br>");
			}
			
			pw.println("</body></html>");
			
			//Step 5 : Close the Connection
			connection.close();
			pw.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
