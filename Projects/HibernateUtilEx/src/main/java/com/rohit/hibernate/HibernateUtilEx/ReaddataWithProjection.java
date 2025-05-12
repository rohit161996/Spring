package com.rohit.hibernate.HibernateUtilEx;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReaddataWithProjection
{
   public static void main( String[] args )
   {
       // Step 1: Get the Hibernate SessionFactory (singleton instance)
       // HbUtil is a utility class that likely builds the SessionFactory using hibernate.cfg.xml
       SessionFactory sessionFactory = HbUtil.getSessionFactory();
       
       // Step 2: Open a new session (a single unit of work with the DB)
       Session session = sessionFactory.openSession();
       
       /*
        * Taking the Limited values from the database using the BookLimitedData Class 
        * and changing the query, the values placed in the query should have the same 
        * order as of the values in the constructor.
        *  
        * Projection or DTO (Data Transfer Object) instead of fetching entire Book entities
        * 
        * */
       List<BookLimitedData> book = session.createQuery("select new com.rohit.hibernate.HibernateUtilEx.BookLimitedData(b.id, b.name, b.price, b.authName) from Book b where b.price > :price",BookLimitedData.class)
    		   .setParameter("price", 500)
    		   .list();
       for(BookLimitedData it : book) {
       	System.out.println(it);
       }
       System.out.println();
       
       // (Optional but recommended) Step 7: Close the session (not done in original code) 
       session.close();
       
       // (Optional) Step 8: Close the SessionFactory when the application shuts down
       // sessionFactory.close(); // Only needed when the app is exiting fully
   }
   
}










