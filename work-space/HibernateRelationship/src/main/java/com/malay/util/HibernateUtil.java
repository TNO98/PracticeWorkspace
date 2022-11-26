package com.malay.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.malay.model.PhoneNumber;
import com.malay.model.Student;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory!=null) return sessionFactory;
		
		//STEP 1 : Creating config object and provideing db and mapping info
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(PhoneNumber.class);
		
		//Step 2 : Create session factory and return
		sessionFactory= cfg.buildSessionFactory();
		return sessionFactory;
	}

}
