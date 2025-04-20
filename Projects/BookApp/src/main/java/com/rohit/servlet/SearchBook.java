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
import java.sql.ResultSet;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Book App</h1>");
		out.print("<hr>");
		
		String name=request.getParameter("name");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bookapp", "root", "Incapp@12");
			PreparedStatement p = c.prepareStatement("select * from book where name=?");
			p.setString(1, name);
			ResultSet rs= p.executeQuery();
			if(rs.next()) {
				String n=rs.getString("name");
				String an=rs.getString("aname");
				String pn=rs.getString("pname");
				int pr=rs.getInt("price");
				out.print("<div style='background-color:yellow; padding:10px;'>");
				out.print("<p>Name: <b> "+n+" </b> </p>");
				out.print("<p>Author Name: <b> "+an+" </b> </p>");
				out.print("<p>Publisher Name: <b> "+pn+" </b> </p>");
				out.print("<p>Price: <b> "+pr+" </b> </p>");
				out.print("</div>");
			}else {
				out.print("<p>Book Not Found !</p>");
			}
			
			c.close();
			
			
		} catch (Exception e) {
			out.print("<p>Exception Occured!</p>");
			out.print("<p>"+ e +"</p>");
		}
		out.print("</body>");
		out.print("</html>");
	}

}
