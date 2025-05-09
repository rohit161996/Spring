package com.rohit.hibernate.HibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Entry point for the Hibernate application.
 */

/*
 * Configuration, SessionFactory, Session and Transaction are
 * core objects of the hibernate framework.
 * 
 */

public class App 
{
    public static void main( String[] args )
    {
        // Create Configuration object and load settings from configuration file (e.g., Rahul.xml)
        Configuration cfg = new Configuration();
        
        // Load Hibernate configuration (can be renamed from default hibernate.cfg.xml)
        // Can give your own name
        cfg.configure("Rahul.xml");
        
        // Add the annotated Book class so Hibernate knows about the entity and can map it to a table
        // Create a Book table in Database
        cfg.addAnnotatedClass(Book.class);  // Register Book entity
        
        // Build the SessionFactory (singleton), which manages DB connections
        // Connected with data base
        // Creating the session object for CRUD operations
        // Creating a single object is necessary since creating the object of session factory is necessary
        SessionFactory factory = cfg.buildSessionFactory();
        
        // Open a new session (a lightweight, short-lived object used for DB operations)
        Session session = factory.openSession();
        
        // Begin a transaction to ensure atomicity of DB operations
        Transaction txn = session.beginTransaction();

        // Create and populate a Book object to be inserted into the database
        Book b = new Book();
        b.setName("Java");
        b.setPrice(900);
        b.setAname("Rahul Chauhan");
        b.setPname("Incapp");

        // Save the Book object into the database (INSERT operation)
        // Insert Book data inside the Book Table of DB
        session.save(b);
        
        // Commit to confirm the insertion in DB
        txn.commit();
        
        // Close the session to release resources
        session.close();
    }
}


