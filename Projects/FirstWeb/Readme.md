# First Web Application

In this project:- 
1. No java code is present.

2. Only 2 html files are present in the src/main "first.html" and "second.html".

<!-- first.html -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Page</title>
</head>
<body>
	<h1>Welcome to my First Web APP.</h1>
	<hr>
	<p>This is First Page.</p>
	<a href="second.html">Second Page</a>
</body>
</html>

<!-- second.html -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Second Page</title>
</head>
<body>
	<h1>Welcome to my First Web App</h1>
	<hr>
	<p>This is Second Page</p>
	<a href="first.html">First Page</a>
</body>
</html>


3. In the src/webapp/WEB-INF/web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app id="WebApp_ID" version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
	<display-name>FirstWeb</display-name>
	<welcome-file-list>
		<welcome-file>first.html</welcome-file>
		<welcome-file>first.htm</welcome-file>
		<welcome-file>first.jsp</welcome-file>
		<welcome-file>default.html</welcome-file>
		<welcome-file>default.htm</welcome-file>
		<welcome-file>default.jsp</welcome-file>
	</welcome-file-list>
</web-app>