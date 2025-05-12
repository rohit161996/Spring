package com.rohit.hibernate.HibernateUtilEx;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
        // Step 1: Get the Hibernate SessionFactory (singleton instance)
        // HbUtil is a utility class that likely builds the SessionFactory using hibernate.cfg.xml
        SessionFactory sessionFactory = HbUtil.getSessionFactory();
        
        // Step 2: Open a new session (a single unit of work with the DB)
        Session session = sessionFactory.openSession();
        
        // Step 3: Begin a transaction - Hibernate requires transactions for data changes
        Transaction txn = session.beginTransaction();
        
        // Step 4: Create and populate a new Book object
        Book b1 = new Book();  // Book is a mapped @Entity class
        b1.setAuthName("Hasanand Ramchandani");                         // Set author name
        b1.setDop(new Date());                         // Set date of publication to current date
        b1.setName("Java");				               // Set book name
        b1.setPages(700);                              // Set page count (0 here as a placeholder)
        b1.setPrice(2000);                             // Set price (0 here as a placeholder)
        b1.setPubName("McGrawHill");                   // Set publisher name
        
        // Step 5: Save the book entity to the database
        session.save(b1);  // This schedules an INSERT operation

        // Step 6: Commit the transaction - this actually persists the changes to the DB
        txn.commit();

        // (Optional but recommended) Step 7: Close the session (not done in original code)
        session.close();
        
        // (Optional) Step 8: Close the SessionFactory when the application shuts down
        // sessionFactory.close(); // Only needed when the app is exiting fully
    }
}
