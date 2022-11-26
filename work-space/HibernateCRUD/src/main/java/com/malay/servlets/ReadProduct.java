package com.malay.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.malay.dao.ProductDao;
import com.malay.model.Product;

/**
 * Servlet implementation class ReadProduct
 */
public class ReadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDao pd =new ProductDao();
		List<Product> products = pd.showAllProducts();
		
		PrintWriter pw = response.getWriter();
		pw.append("<html><body>");
		
		pw.append("<h1>Product List: </h1> <br>");
		pw.append("<table>");
		
		pw.append("<tr>");
		pw.append("<th>Product ID</th>");
		pw.append("<th>Product Name</th>");
		pw.append("<th>Product Price</th>");
		pw.append("<th>Product Brand</th>");
		
		pw.append("</tr>");
		
		for(Product product: products) {
			pw.println("<tr>");
			
			pw.println("<td>"+product.getProductID()+"</td>");
			pw.println("<td>"+product.getpName()+"</td>");
			pw.println("<td>"+product.getpPrice()+"</td>");
			pw.println("<td>"+product.getBrandName()+"</td>");
			
			pw.println("</tr>");
		}
		
		
		
		pw.append("</table>");
		
		
		
		
		
		
		pw.append("</body></html>");
	}

}
