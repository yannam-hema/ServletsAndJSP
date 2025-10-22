package HibernateManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateManager {

    private SessionFactory sessionFactory;

    public HibernateManager() {
        Configuration configure = new Configuration();
        configure.configure("hibernate.cfg.xml")
                 .addAnnotatedClass(Book.class)
                 .addAnnotatedClass(Publisher.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configure.getProperties())
                .build();

        sessionFactory = configure.buildSessionFactory(serviceRegistry);
        System.out.println("Hibernate SessionFactory created successfully!");
    }

    public void insertPublisher(Publisher p) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(p);
        t.commit();
        session.close();
        System.out.println("✅ Publisher and its books inserted successfully!");
    }

    public void close() {
        sessionFactory.close();
        System.out.println("🔒 SessionFactory closed.");
    }
}
