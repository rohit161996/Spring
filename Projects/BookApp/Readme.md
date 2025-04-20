# Steps to create the project

1. This application consists of HTTP Servlet which connects with the Application with the database.

2. Create a schema in the mysql workbench.

3. Create a table named book [name, aname, content, image, pname, price].
							 [varchar, varchar, longblob, longblob, varchar, int]
							 
CREATE TABLE `bookapp`.`book` (
  `name` VARCHAR(255) NOT NULL,
  `aname` VARCHAR(255) NULL,
  `content` LONGBLOB NULL,
  `image` LONGBLOB NULL,
  `pname` VARCHAR(255) NULL,
  `price` INT NULL,
  PRIMARY KEY (`name`));
  
4. Create an HTML Page named index.html and create a form in it.

5. Make the field required which are required in the database.

6. Create the Servlet in the src folder.

7. Uncheck the constructor, doGet and doPost method.

8. request object is used to get the values from the form in the web page.

9. Add the "mysql-connector-j-8.4.0.jar" file to the web-inf/lib/

10. 