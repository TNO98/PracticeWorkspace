package com.malay.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.malay.dao.ProductDao;
import com.malay.model.Product;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDao pd ;
	
	public void init() {
		pd =new ProductDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-product.html").include(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String productname = request.getParameter("name");
		double productPrice = Double.parseDouble(request.getParameter("price"));
		String brandName = request.getParameter("brand");
		Product product = new Product();
		product.setpName(productname);
		product.setBrandName(brandName);
		product.setpPrice(productPrice);
		
		System.out.println("the product is " +product.toString());
		
		pd.saveProduct(product) ;
	}

}
