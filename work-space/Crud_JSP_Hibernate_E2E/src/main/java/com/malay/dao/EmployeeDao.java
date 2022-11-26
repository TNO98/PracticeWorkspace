package com.malay.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.malay.entity.Employee;
import com.malay.util.HibernateUtil;

public class EmployeeDao {
	
	public static void addEmployee(Employee e) {
		Transaction tx=null;
		try (SessionFactory sf = HibernateUtil.getSessionFactory()){
			Session session= sf.openSession();
		    tx= session.beginTransaction();
			session.save(e);
			tx.commit();
			session.close();
		} catch (Exception e2) {
			if (tx != null) {
				tx.rollback();
			}
			e2.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Employee> listEmployees(){
		List<Employee> employees = null;
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		employees =session.createQuery("from Employee").list();
		
		session.close();
		
		
		return employees;
	}
	
	
 
}
