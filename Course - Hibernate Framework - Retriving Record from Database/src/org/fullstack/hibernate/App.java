package org.fullstack.hibernate;

import org.fullstack.hibernate.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;





public class App {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Users.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			//Create object of entity class type
			Users user = new Users();
			// Start transaction
			session.beginTransaction();
			//Perform Operation
			user = session.get(Users.class, 2);
			// Commit the Transaction
			session.getTransaction().commit();
			System.out.println("User Search:" + user);
			
			
			
		} finally {
			session.close();
			factory.close();
		}	
		
	}

}
