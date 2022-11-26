package com.malay.utils;

import org.hibernate.cfg.Configuration;

import com.malay.model.Products;

public class SessionFactory {
	private static org.hibernate.SessionFactory sessionFactory;
	static {
		try {
			if (sessionFactory == null) {
				Configuration cfg = new Configuration().configure().addAnnotatedClass(Products.class);
				sessionFactory = cfg.buildSessionFactory();
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
