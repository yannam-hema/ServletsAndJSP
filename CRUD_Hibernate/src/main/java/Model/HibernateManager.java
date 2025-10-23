package Model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import Utils.UserDetails;

public class HibernateManager {
	 private static Session session;

	    public HibernateManager() {
	    	Configuration configure = new Configuration().
					configure("hibernate.cfg.xml");
			ServiceRegistryBuilder builder = new ServiceRegistryBuilder().
					applySettings(configure.getProperties());
			SessionFactory sessionFactory = 
					configure.buildSessionFactory
					(builder.buildServiceRegistry());
			session = sessionFactory.openSession();

	        System.out.println("Session is created and connected to DB");
	    }
	    //Create
	    public boolean insertData(UserDetails u) {
	    	try {
	    	 Transaction transaction = session.beginTransaction();
	         session.save(u);
	         transaction.commit();
	         return true;
	    	}catch (Exception e) {
				return false;
			}
	    }
	    //read
	    public boolean  readData(UserDetails u) {
	    	try {
	    	Transaction beginTransaction = session.beginTransaction();
			Query query = session.createQuery("From UserDetails");
			List list = query.list();
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				UserDetails ud1 = (UserDetails) iterator.next();
				System.out.println(ud1.getId()+"->"+ud1.getUsername());
				System.out.println("...............");
			}
			return true;
	    	}catch (Exception e) {
				return false;
			}
	    }
	    //update
	    public boolean updateData(UserDetails u , int id ,String name) {
	    	try {
	    	Transaction beginTransaction = session.beginTransaction();
			UserDetails ud = (UserDetails)session.get(UserDetails.class, id);
			session.update(ud);
			ud.setUsername(name);
			beginTransaction.commit();
			return true;
	    	}
	    	catch (Exception e) {
				return false;
			}
	         
	    }
	    //delete
	    public boolean  deleteUser(UserDetails u , int id ) {
	    	try {
	    	Transaction beginTransaction = session.beginTransaction();
			UserDetails ud = (UserDetails)session.get(UserDetails.class, id);
	    	session.delete(ud);
	    	beginTransaction.commit();
	    	return true;
	    }catch (Exception e) {
			return false;
		}
	    }
}
