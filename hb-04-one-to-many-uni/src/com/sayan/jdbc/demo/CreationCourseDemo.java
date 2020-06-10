package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Course;
import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;
import com.sayan.jdbc.entity.Student;

public class CreationCourseDemo {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
//			Instructor instructor = new Instructor("Sayan","Manik","sayanmanik.sm@gmail.com");
//			
//			InstructorDetail detail = new InstructorDetail("www.google.com","nothing");
//			
			
			Instructor instructor = new Instructor("sayan","manik","sayanmanik.sm@gmail.com");
			
			InstructorDetail detail = new InstructorDetail("www.google.com","nothing");
			
			instructor.setInstructorDetail(detail);
			
			session.beginTransaction();
			
			System.out.println("Saving the instructor...");
			session.save(instructor);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
