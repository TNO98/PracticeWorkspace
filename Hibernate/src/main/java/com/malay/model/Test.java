package com.malay.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Products product=new Products();
		product.setProductName("Honor Holly");
		product.setProductPrice(6999);
		product.setBrandName("Huawei");
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Products.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(product);
		Products pro=session.load(Products.class, 3);
		tx.commit();
		System.out.println(pro);
	}

}
