package com.malay.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.malay.entity.Employee;



public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory!=null) return sessionFactory;
		
		//STEP 1: Creating Configuaration object and providing DB and mapping info
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		
		//STEP 2 : CREATE SESSION FACTORY OBJECT AND RETURN
		sessionFactory=cfg.buildSessionFactory();
		return sessionFactory;
		
	}
	
}
