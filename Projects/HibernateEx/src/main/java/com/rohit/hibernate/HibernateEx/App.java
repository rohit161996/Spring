package com.rohit.hibernate.HibernateEx;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Main class to demonstrate CRUD operations using Hibernate
 */
public class App 
{
    public static void main( String[] args )
    {
        // Print a welcome message
    	System.out.println("Hello World");

        // Create a Configuration object and load configuration from Rohit.xml
        Configuration cfg = new Configuration();
        cfg.configure("Rohit.xml"); // Hibernate config file (can have any name)

        // Add the annotated entity class to the configuration
        cfg.addAnnotatedClass(Library.class); // Maps Library entity to DB table

        // Build the SessionFactory which provides DB sessions (singleton, thread-safe)
        SessionFactory factory = cfg.buildSessionFactory(); // Connects with DB

        // Open a session (represents a unit of work with the DB)
        Session session = factory.openSession();

        // Begin a new database transaction
        Transaction txn = session.beginTransaction();      

        // ------------------- Create Operation -------------------
//        Library l = new Library();
//        l.setCost(150000);
//        l.setLaname("LA LA LA LA");
//        l.setLib_id(1);
//        l.setLpname("Perfect");
//        session.save(l); // Insert the new Library record into the DB        
//        txn.commit(); // Finalize insertion by committing the transaction

        // ------------------- Read Operation -------------------
//        Library l = session.get(Library.class, 2); // Fetch Library record with ID = 2
//        System.out.println(l); // Print the fetched object

        // ------------------- Delete Operation -------------------
//        Library l = session.get(Library.class, 1); // Fetch record with ID = 1
//        session.delete(l); // Delete the fetched record
//        txn.commit(); // Finalize deletion by committing the transaction

        // ------------------- Update Operation -------------------
        Library l = session.get(Library.class, 2); // Fetch Library record with ID = 2
        l.setLpname("Yo Yo Yo Yo"); // Modify publisher name
        l.setCost(3200000);    // Modify cost
        session.update(l);    // Apply the updates to the DB
        txn.commit();         // Finalize update by committing the transaction

        // Close the session to release the DB connection
        session.close();
    }
}
