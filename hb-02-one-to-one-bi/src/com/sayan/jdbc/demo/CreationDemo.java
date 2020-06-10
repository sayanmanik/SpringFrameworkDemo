package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;
import com.sayan.jdbc.entity.Student;

public class CreationDemo {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
//			Instructor instructor = new Instructor("Sayan","Manik","sayanmanik.sm@gmail.com");
//			
//			InstructorDetail detail = new InstructorDetail("www.google.com","nothing");
//			
			
			Instructor instructor = new Instructor("prabhas","manik","prabhas.manik@gmail.com");
			
			InstructorDetail detail = new InstructorDetail("www.google.com","nothing");
			
			instructor.setInstructorDetail(detail);
			
			session.beginTransaction();
			
			System.out.println("Saving the instructor...");
			session.save(instructor);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
			factory.close();
		}
	}
}
