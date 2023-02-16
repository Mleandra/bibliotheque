package UTILS;

import entities.Book;
import entities.Category;
import entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CONFIG {
    public static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public static void configHibernate() {
        try {

            // Initialize the hibernate configuration.
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Book.class);

            // Build a service registry from the properties of the configuration
            // This is new in Hibernate 4 !
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            // Build the SessionFactory !
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
