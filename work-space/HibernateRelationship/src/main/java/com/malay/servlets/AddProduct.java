package com.malay.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.malay.model.PhoneNumber;
import com.malay.model.Student;
import com.malay.util.HibernateUtil;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddProduct() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("add-student.html").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = populateStudent(request);
		
		//Hibernate Operations
		SessionFactory sf =HibernateUtil.getSessionFactory();
		Session session= sf.openSession();
		Transaction tx= session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
		
		PrintWriter pw= response.getWriter();
		pw.append("<html> <body>");
		
		pw.println("Records are saved successfully");
		pw.append("</body></html> ");
		
	}

	/**
	 * @param request
	 * @return
	 */
	private Student populateStudent(HttpServletRequest request) {
		Student student= new Student();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");

		// phone 1
		String phoneNum1 = request.getParameter("phone_1");
		String phoneType1 = request.getParameter("type1");
		//make obj of phone number
		PhoneNumber phoneNumber1 = new PhoneNumber();
		phoneNumber1.setPhoneNumber(phoneNum1);
		phoneNumber1.setPhoneType(phoneType1);
		phoneNumber1.setStudent(student);

		// phone 2
		String phoneNum2 = request.getParameter("phone_2");
		String phoneType2 = request.getParameter("type2");
		//make obj of phone number
		PhoneNumber phoneNumber2 = new PhoneNumber();
		phoneNumber1.setPhoneNumber(phoneNum2);
		phoneNumber1.setPhoneType(phoneType2);
		phoneNumber2.setStudent(student);

		// phone 3
		String phoneNum3 = request.getParameter("phone_3");
		String phoneType3 = request.getParameter("type3");
		//make obj of phone number
		PhoneNumber phoneNumber3 = new PhoneNumber();
		phoneNumber3.setPhoneNumber(phoneNum3);
		phoneNumber3.setPhoneType(phoneType3);
		phoneNumber3.setStudent(student);
		
		List<PhoneNumber> phones =new ArrayList();
		phones.add(phoneNumber1);
		phones.add(phoneNumber2);
		phones.add(phoneNumber3);
		
		// make obj of Student
		
		student.setFname(fname);
		student.setLname(lname);
		student.setPhones(phones);
		return student;
	}

}
