package com.malay.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.malay.model.Products;
import com.malay.utils.SessionFactory;

/**
 * Servlet implementation class AddProduct
 */
@javax.servlet.annotation.WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		Products product= new Products();
		product.setProduct_name(request.getParameter("product_name"));
		product.setBrand_name(request.getParameter("brand_name"));
		product.setProduct_price(Double.parseDouble(request.getParameter("product_price")));
		
		org.hibernate.SessionFactory sf=SessionFactory.getSessionFactory();
		Session session= sf.openSession();
		
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}

}
