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
	    	// HQL query to find user by email and password
	    	Query query = session.createQuery("FROM UserDetails WHERE email = :email AND password = :password");
	    	query.setParameter("email", u.getEmail());
	    	query.setParameter("password", u.getPassword());
	    	List<UserDetails> list = query.list();

	    	// Check if matched record found
	    	if (!list.isEmpty()) {
	    	    UserDetails ud1 = list.get(0);
	    	    System.out.println("Login successful for: " + ud1.getUsername());
	    	    return true;
	    	} else {
	    	    System.out.println("Invalid email or password!");
	    	    return false;
	    	}
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
