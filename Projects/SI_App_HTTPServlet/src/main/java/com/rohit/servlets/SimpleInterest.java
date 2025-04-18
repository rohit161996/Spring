package com.rohit.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SimpleInterest
 */
@WebServlet("/si")
public class SimpleInterest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int p=Integer.parseInt(request.getParameter("p"));
//		double r=Double.parseDouble(request.getParameter("r"));
//		int t=Integer.parseInt(request.getParameter("t"));
//		double si=p*r*t/100;
//		PrintWriter out=response.getWriter();
//		out.print("<html>");
//		out.print("<body>");
//		out.print("<h1>Welcome to Simple Interest App</h1>");
//		out.print("<hr>");
//		out.print("<p> Simple Interest = "+si+" </p>");
//		out.print("</body>");
//		out.print("</html>");
//		out.close();
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p=Integer.parseInt(request.getParameter("p"));
		double r=Double.parseDouble(request.getParameter("r"));
		int t=Integer.parseInt(request.getParameter("t"));
		double si=p*r*t/100;
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Welcome to Simple Interest App</h1>");
		out.print("<hr>");
		out.print("<p> Simple Interest = "+si+" by doGET</p>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p=Integer.parseInt(request.getParameter("p"));
		double r=Double.parseDouble(request.getParameter("r"));
		int t=Integer.parseInt(request.getParameter("t"));
		double si=p*r*t/100;
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Welcome to Simple Interest App</h1>");
		out.print("<hr>");
		out.print("<p> Simple Interest = "+si+" by doPOST</p>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
