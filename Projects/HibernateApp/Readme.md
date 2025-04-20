# Project to create a table in MySQL 
# using Hibernate without using the 
# JDBC connection

1. Dependencies Added 
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

2. XML File for configuration created
<?xml version="1.0" encoding="UTF-8"?>

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

3. Add getter and setter method in the Book.java file.

4. Add the main code in the App.java file.



5. Download the file from google hibernate-configuration-3.0.dtd and add the doctype tag to 
   the XML File created.


