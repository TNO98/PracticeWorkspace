package com.malay.dashboard;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DashboardCookie
 */
public class DashboardCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		out.println("<html><body>");
		
		//getting allthe cookies for request obj
		Cookie[] cookies=request.getCookies();
		String userName =null;
		
		for (Cookie cookie:cookies) {
			if(cookie.getName().equals("userName")) {
				userName=cookie.getValue();
			}
		}
		if(userName!=null){
			out.println("Hello"+ userName);
		}
		else {
			out.println("please login First");
		}
		out.println("</body></html>");
	}

}
