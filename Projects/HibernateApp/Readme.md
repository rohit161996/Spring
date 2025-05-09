# Project to create a table in MySQL
# using Hibernate without using the
# JDBC connection

1. Add Dependencies to the pom.xml for MySQL and Hibernate framework.
    <!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
	<dependency>
	    <groupId>com.mysql</groupId>
	    <artifactId>mysql-connector-j</artifactId>
	    <version>8.4.0</version>
	</dependency>
	
	<!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
    <dependency>
    	<groupId>org.hibernate.orm</groupId>
    	<artifactId>hibernate-core</artifactId>
    	<version>6.6.0.Final</version>
   	</dependency>

2. Create the configuration XML File in the source folder which contains the information regarding the 
database to which we have to map:-

In the folder src/main/java -> Right Click -> New -> Other -> XML File

<?xml version="1.0" encoding="UTF-8"?>

3. In the browser type Hybernate DTD get the hibernate dtd file and paste the content 
to XML File.

<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
    <session-factory>
        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name= "connection.url">jdbc:mysql://localhost:3306/hibernate_db</property>
        <property name="connection.username">root</property>
        <property name="connection.password">Incapp@12</property>
        <property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>
        <!-- Create new Tables for everytime -->
        <!-- <property name= "hbm2ddl.auto">create</property> -->
        <!-- Create new Tables if does not exist. -->
        <property name= "hbm2ddl.auto">update</property>
        <!-- To show sql query on cosole -->
        <property name="show_sql">true</property>
        <!-- To show sql query in formatted way -->
        <property name="format_sql">true</property>
    </session-factory>
</hibernate-configuration>

3. Add members to the Book.java file these are the members which will be the column name in 
   the database and create getter and setter methods in the Book.java file.

Description of the Hibernate Annotations:-
3.1. @Entity is for Table Name. 
	Compulsary annotation
	
3.2. @Id is for the Primary Key in the Table.
	Optional annotation

4. Add the main code in the App.java file.

5. Download the file from google hibernate-configuration-3.0.dtd and add the doctype tag to 
   the XML File created.

Hibernate itself creates the tables in the Database using class object mapping without using 
the SQL query. It is not the only one but it is most famous ORM (Object Relation Mapping) based 
application.
