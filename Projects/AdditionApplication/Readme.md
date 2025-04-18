Servlet Program
- File -> New -> Other... -> Dynamic Web Project -> Enter Project Name -> Finish

 
--- Servlet based Web Application
	- Server is a software that gives structure to the Java Program on the Server side, which 
	  is not provided in the case of JVM, JVM gives the structure to run the normal java program.

	- Servlet program takes the request from the Front End or Client and builds the dynamic web page
	  and returns the dynamic web page in return.
	
	- Servlet invokes the JVM internally to run the program.
	
	- Server has created an interface called ServletInterface.
	  - Server program needs to inherit the Servlet Interface, so it has to override 5 methods to run 
	    the server application.
	  
	  - The web pages will be present in the src/main/webapp directory e.g. src/main/webapp/index.html
  	    <!DOCTYPE html>
		<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		</head>
		<body>
			<h1>Welcome to my App</h1>
			<hr>
			<form action="sum">
				<label>1st No:</label>
				<input type="number" name="num1" required />
				<br><br>
				
				<label>2nd No:</label>
				<input type="number" name="num2" required />
				<br><br>
				
				<button>Add</button>
			</form>
		</body>
		</html>
		
      - The server is getting the request of name "sum" present in the form action.
	  - Unitll we make a java server program to handle the request we will get error 404 page not found.
	  - Now the servlet will be created in the class in the in the package named "com.rohit.servlet" 
	    src/main/java/Addition.java which will take the request from the form and create the dynamic web 
		page and revert it.
		Step 1. 
		import jakarta.servlet.Servlet;
		public class Addition implements Servlet{
		}
		
		Step 2.
		Hover to the Addition class click on "Add unimplemented method".
		-> Addition Class is loaded.
		-> Object for Addition Class is created.
		-> Object is passed in the init()
		
		1. Init method:-
		-> One object is passed in the init().
		-> This methods is run only once for as many number of clients.
		init(ServletConfig config){
			
		}
	    
		2. Service method:-
		-> Two Objects are created in the service method ServletRequest and ServletResponse.
		service(ServletRequest arg0, ServletResponse arg1){
			int n1=Integer.parseInt(arg0.getParameter("num1"));
			int n2=Integer.parseInt(arg0.getParameter("num2"));
			int r=n1+n2;
			PrintWriter out=arg1.getWriter();
			out.print("<html>");
			out.print("<body>");
			out.print("<h1>Welcome to my App</h1>");
			out.print("<hr>");
			out.print("<p> Sum of "+n1+" and "+n2+" = "+r+" </p>");
			out.print("</body>");
			out.print("</html>");
			out.close();
		}
		NOTE:
		-> We will get values from the "ServletRequest arg0" only.
		-> We will get the values from the website in the string format, so we will have to parse 
		   it in integer using Integer.parseInt() function, it is a wrapper class chile of number class
		   which is a child of object class.
		
		3. Destroy method:-
		-> If we want to remove our application from the server then we will call the destroy().
		
      - Configure the web.xml file with the following tags.
	      <servlet>
			<servlet-name>xyz</servlet-name>
			<servlet-class>com.rohit.servlet.Addition</servlet-class>
		  </servlet>
		  
		  <servlet-mapping>
			<servlet-name>xyz</servlet-name>
			<url-pattern>/sum</url-pattern>
		  </servlet-mapping>
		  
NOTE:-
To run the program go to html file and then right click and click on "Run as -> Run as Server".
