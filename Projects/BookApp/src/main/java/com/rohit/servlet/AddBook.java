package com.rohit.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Book App</h1>");
		out.print("<hr>");
		
		String name = request.getParameter("name");
		String aname = request.getParameter("aname");
		String pname = request.getParameter("pname");
		int price= Integer.parseInt(request.getParameter("price"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookapp", "root", "Incapp@12");
			PreparedStatement p = c.prepareStatement("insert into book (name, aname, pname, price) values (?, ?, ?, ?)");
			p.setString(1, name);
			p.setString(2, aname);
			p.setString(3, pname);
			p.setInt(4, price);			
			p.executeUpdate();
			out.print("<p> Book Added Successfully!!! </p>");
			
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			out.print("<p> Book Already Exists!!! </p>");
		} catch (Exception e) {
		    if (e.getMessage().contains("Access denied for user")) {
		        out.print("<p>Database login failed: Incorrect username or password.</p>");
		    } else {
		        out.print("<p>Exception Occurred: " + e + "</p>");
		    }
		}
		out.print("</body>");
		out.print("</html>");
	}

}
