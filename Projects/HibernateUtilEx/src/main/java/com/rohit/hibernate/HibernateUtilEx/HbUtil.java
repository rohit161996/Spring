package com.rohit.hibernate.HibernateUtilEx;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HbUtil {

    // Utility method to build and return a SessionFactory
    public static SessionFactory getSessionFactory() {

        // Step 1: Create Configuration instance
        Configuration cfg = new Configuration();

        // Step 2: Set Hibernate properties manually (instead of using hibernate.cfg.xml)
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); // MySQL JDBC driver
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db"); // DB connection URL
        properties.put(Environment.USER, "root"); // DB username
        properties.put(Environment.PASS, "Incapp@12"); // DB password

        // Hibernate dialect to use for MySQL 8+
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

        // Optional: Automatically update the schema based on entity mappings
        // "create" → drops and recreates the schema each time
        // "update" → updates the schema (non-destructive, preferred for dev)
        properties.put(Environment.HBM2DDL_AUTO, "update");

        // Optional: Show SQL queries in console
        properties.put(Environment.SHOW_SQL, true);

        // Set the properties into the configuration
        cfg.setProperties(properties);

        // Step 3: Add your annotated entity classes
        cfg.addAnnotatedClass(Book.class);

        // Step 4: Build the ServiceRegistry using settings from cfg
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(cfg.getProperties())
            .build();

        // Step 5: Build and return the SessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
