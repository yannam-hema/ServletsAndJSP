package HibernateOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateManager {
    private static Session session;

    public HibernateManager() {
    	Configuration configure = new Configuration();
    	configure.configure("hibernate.cfg.xml")
    	         .addAnnotatedClass(Employee.class)
    	         .addAnnotatedClass(Address.class);


        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configure.getProperties())
                .build();

        SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        System.out.println("Session is created... & connected to DB");
    }

    public void insertData(Employee e) {
        Transaction transaction = session.beginTransaction();
        session.save(e);
        transaction.commit();
        session.close();
    }
}
