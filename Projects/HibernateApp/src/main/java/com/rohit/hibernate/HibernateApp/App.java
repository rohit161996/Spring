package com.rohit.hibernate.HibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure("Rahul.xml"); // Can give your own name
        cfg.addAnnotatedClass(Book.class); // Create a Book table in Database
        SessionFactory factory = cfg.buildSessionFactory(); // Connected with data base
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();

        // Create Book Object to insert in DB
        Book b = new Book();
        b.setName("Java");
        b.setPrice(900);
        b.setAname("Rahul Chauhan");
        b.setPname("Incapp");
        session.save(b); // Insert Book data inside the Book Table of DB
        txn.commit(); // Commit to confirm the insertion in DB
        session.close();
    }
}
