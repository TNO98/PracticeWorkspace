package com.malay.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.malay.model.Product;
import com.malay.utils.HibernateUtil;

public class ProductDao {
	
//	//STEP 3 : LOAD SESSION FACTORY OBJECT
//    SessionFactory sf = HibernateUtil.getSessionFactory();
//    
//    //Step 4 : Get Session Object
//    Session session = sf.openSession();
//    
//    
    
//    public void saveProduct(Product product) {
//    	
//    	Transaction transaction = session.beginTransaction();
//    	session.save(product);
//    	transaction.commit();
//    	
//    	session.close();
//    	
//    }
    
    
	public void saveProduct(Product product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(product);
			// commit transaction
			transaction.commit();
			
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> showAllProducts(){
		Transaction transaction = null;
		List<Product> listOfProducts =null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			//Start a transaction
			transaction =session.beginTransaction();
			
			//the product object
			listOfProducts=session.createQuery("from Product").list();
			
			//commit the transaction
			transaction.commit();
			session.close();
		}
		catch (Exception e) {
			if(transaction!=null) transaction.rollback();
			e.printStackTrace();
		}				
		
		return listOfProducts;
	}
}
