package HibernateOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateManager {
	private static Session session;
public HibernateManager() {
	Configuration configure = new Configuration().
			configure("hibernate.cfg.xml").build();
	BootstrapServiceRegistryBuilder builder = new BootstrapServiceRegistryBuilder().
			applySettings(configure.getProperties());
	SessionFactory sessionFactory = 
			configure.buildSessionFactory
			(builder.buildServiceRegistry());
	session = sessionFactory.openSession();
	System.out.println("Session is created.... & connected to DB");
}
public void insertData(Employee e) {
	Transaction beginTransaction = session.beginTransaction();
	session.save(e);
	beginTransaction.commit();
	session.close();
}
}
