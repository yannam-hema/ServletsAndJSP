package Student;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp {
	private static Session session;

	public static void main(String[] args) {
		StudentOne s = new StudentOne();
		s.setId(4);
		s.setName("satrugnudu");
		
		Configuration configure = new Configuration().
				configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().
				applySettings(configure.getProperties());
		SessionFactory sessionFactory = 
				configure.buildSessionFactory
				(builder.buildServiceRegistry());
		session = sessionFactory.openSession();
		System.out.println("Session is created.... & connected to DB");
		
//		Transaction beginTransaction = session.beginTransaction();
//		session.save(s);
//		beginTransaction.commit();
//		session.close();
//		
//		Transaction beginTransaction = session.beginTransaction();
//		Query query = session.createQuery("From Student");
//		List list = query.list();
//		Iterator iterator = list.iterator();
//		while (iterator.hasNext()) {
//			Student s1 = (Student) iterator.next();
//			System.out.println(s1.getId()+"--------"+s1.getName());
//			System.out.println("==============");
//		}
		
		
//		Student s1 = (Student)session.get(Student.class, 1);
//		System.out.println(s1.getId()+"--------"+s1.getName());
//		System.out.println("==============");
		
//		Student s1 = (Student)session.get(Student.class, 1);
//		s1.setName("Ram");
//		session.update(s1);
		
//		Student s1 = (Student)session.get(Student.class, 1);
//		session.delete(s1);
//		beginTransaction.commit();
	}
}





