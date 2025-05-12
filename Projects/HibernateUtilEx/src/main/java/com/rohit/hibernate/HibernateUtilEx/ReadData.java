 package com.rohit.hibernate.HibernateUtilEx;

import java.util.Date;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ReadData 
{
    public static void main( String[] args )
    {
        // Step 1: Get the Hibernate SessionFactory (singleton instance)
        // HbUtil is a utility class that likely builds the SessionFactory using hibernate.cfg.xml
        SessionFactory sessionFactory = HbUtil.getSessionFactory();
        
        // Step 2: Open a new session (a single unit of work with the DB)
        Session session = sessionFactory.openSession();
        
        // Read Data By ID 
        // @parameter 1 - Class type
        // @parameter 2 - Object Id
        // EagerLoading - get() fires query on object creation and calling the function
        // LazyLoading - load() does not fire the query on object creation, it fires on printing the object
        // Hibernate: select b1_0.id,b1_0.authName,b1_0.content,b1_0.dop,b1_0.image,b1_0.name,b1_0.price,b1_0.pubName from Book b1_0 where b1_0.id=?
        Book b = session.get(Book.class, 1);
        System.out.println(b+"\n");
        
        Book b1 = session.get(Book.class, 2);
        System.out.println(b1 + "\n");
        
        // Read Data By ID 
        // EagerLoading - If ID does'nt exist get() will give NULL
        // LazyLoading - If ID does'nt exist load() will generate the Exception
        try{
        	Book b2 = session.load(Book.class, 30);
            System.out.println(b2 + "\n");
        }catch(ObjectNotFoundException e) {
        	System.out.println("The Book Object with Id does not exist");
        }

        // Read Data By ID 
        // EagerLoading - If ID does'nt exist get() will give NULL
        // LazyLoading - If ID does'nt exist load() will generate the Exception
    	Book b3 = session.get(Book.class, 40);
        System.out.println(b3 + "\n");
        
        
        // -------------------------------------------------------------------------------------------------------------------------------------- //
        
        /*
         * Now we will get the entire table of Books from the database, we will 
         * get it in the form of the list
         * 
         * Create a List of type Book and get session and createQuery like 
         * the query given below
         * 
         * This will be EagerLoading as LazyLoading is depricrated.
         */
        List<Book> book = session.createQuery("from Book",Book.class).list();
        // System.out.println(book);
        for(Book it : book) {
        	System.out.println(it + "\n");
        }
        System.out.println();
   
        
        /*
         * Getting only some of the values from the table like Author Name and Price
         * 
         * */
        List<Book> allBooks = session.createQuery("from Book",Book.class).list();
        // System.out.println(book);
        for(Book bk : allBooks) {
        	System.out.println(bk.getAuthName() + " " + bk.getPrice());
        }
        System.out.println();
        
        
        
        /*
         * Where clause in getting all the books
         * For table name we will write the class name not the name of the table in the database
         * 
         * Book.class is added as a parameter in the session.createQuery
         * 
         * */
        List<Book> someBooks = session.createQuery("select b from Book b where b.price > :price", Book.class)
        		.setParameter("price", 500)
        		.list();
        // System.out.println(book);
        for(Book bk : someBooks) {
        	System.out.println(bk);
        }
        System.out.println();
        
        
        /*
         * Where clause in getting all the books
         * For table name we will write the class name not the name of the table in the database
         * 
         * Book.class is added as a parameter in the session.createQuery
         * 
         * */
        List<Book> someBooks1 = session.createQuery("select b from Book b where b.name = :name", Book.class)
        		.setParameter("name", "java")
        		.list();
        // System.out.println(book);
        for(Book bk : someBooks1) {
        	System.out.println(bk);
        }
        System.out.println();
        
        
        /*
         * Where clause in getting all the books
         * For table name we will write the class name not the name of the table in the database
         * 
         * Book.class is added as a parameter in the session.createQuery
         * 
         * */
        List<Book> someBooks2 = session.createQuery("select b from Book b where b.name like :name", Book.class)
        		.setParameter("name", "%a%")
        		.list();
        // System.out.println(book);
        for(Book bk : someBooks2) {
        	System.out.println(bk);
        }
        System.out.println();
        
        /*
         * Where clause in getting all the books
         * For table name we will write the class name not the name of the table in the database
         * 
         * Book.class is added as a parameter in the session.createQuery
         * 
         * */
        List<Book> someBooks3 = session.createQuery("select b from Book b where b.name like :name and b.price > :price", Book.class)
        		.setParameter("name", "%a%")
        		.setParameter("price", "1000")
        		.list();
        // System.out.println(book);
        for(Book bk : someBooks3) {
        	System.out.println(bk);
        }
        
        
        
        // (Optional but recommended) Step 7: Close the session (not done in original code) 
        session.close();
        
        // (Optional) Step 8: Close the SessionFactory when the application shuts down
        // sessionFactory.close(); // Only needed when the app is exiting fully
    }
}
