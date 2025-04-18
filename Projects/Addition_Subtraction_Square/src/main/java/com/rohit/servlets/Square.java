package com.rohit.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class Square extends HttpServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		int n=Integer.parseInt(arg0.getParameter("num"));
		int r=n*n;
		PrintWriter out=arg1.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Welcome to my App</h1>");
		out.print("<hr>");
		out.print("<p> Square of "+n+" = "+r+" </p>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
