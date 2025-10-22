package hibernateManyToMany;

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
                 .addAnnotatedClass(Student.class)
                 .addAnnotatedClass(Course.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configure.getProperties())
                .build();

        sessionFactory = configure.buildSessionFactory(serviceRegistry);
        System.out.println("✅ Hibernate SessionFactory created successfully!");
    }

    public void insertStudent(Student s) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.save(s);
        t.commit();
        session.close();
        System.out.println("✅ Student and associated courses saved successfully!");
    }

    public void close() {
        sessionFactory.close();
        System.out.println("🔒 SessionFactory closed.");
    }
}
