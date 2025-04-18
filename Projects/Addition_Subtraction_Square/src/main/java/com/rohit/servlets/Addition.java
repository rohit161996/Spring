package com.rohit.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Addition implements Servlet {

	private ServletConfig config;
	
	@Override
	public void destroy() {
		System.out.println("Bye Servlet");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "This servlet is performing addition.";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		System.out.println("Hello Servlet");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		int n1=Integer.parseInt(arg0.getParameter("num1"));
		int n2=Integer.parseInt(arg0.getParameter("num2"));
		int r=n1+n2;
		PrintWriter out=arg1.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Welcome to my App</h1>");
		out.print("<hr>");
		out.print("<p>"+getServletInfo()+"</p>");
		ServletConfig cfg=getServletConfig();
		out.print("<p> Sum of "+n1+" and "+n2+" = "+r+" </p>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
	
}

