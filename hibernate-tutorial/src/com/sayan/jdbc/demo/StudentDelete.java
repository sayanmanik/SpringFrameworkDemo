package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Student;

public class StudentDelete {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		int id = 1;
		
		try{
			
			System.out.println("Deleting a particular student...");
			
			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, id);
			
			System.out.println("Deleting...");
			session.delete(theStudent);
			
			session.getTransaction().commit();
			
			
			System.out.println("\n\n");
			
			System.out.println("Deleting students via alternate way...");
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("delete Student where id=2")
				.executeUpdate();
				
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}finally{
			factory.close();
		}
	}
}
