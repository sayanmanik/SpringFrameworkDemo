package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Student;

public class StudentUpdate {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		int id = 1;
		
		try{
			
			System.out.println("Updating a particular student...");
			
			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, id);
			
			theStudent.setLastName("qwerty");
			
			session.getTransaction().commit();
			
			
			System.out.println("\n\n");
			
			System.out.println("Updating email of all students...");
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'")
				.executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}finally{
			factory.close();
		}
	}
}
