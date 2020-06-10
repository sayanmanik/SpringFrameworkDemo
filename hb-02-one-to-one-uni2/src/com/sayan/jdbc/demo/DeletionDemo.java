package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;

public class DeletionDemo {

public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		int id = 1;
	
		try{
			
			session.beginTransaction();
			Instructor i = session.get(Instructor.class, id); 
			System.out.println("Deleteing id:"+id);
			session.delete(i);
			session.getTransaction().commit();
			System.out.println("Deleted");
		
		
		}finally{
			
		}

	}
			

}
