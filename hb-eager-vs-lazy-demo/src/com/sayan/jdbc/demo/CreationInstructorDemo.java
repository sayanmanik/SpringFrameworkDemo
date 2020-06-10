package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Course;
import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;
import com.sayan.jdbc.entity.Student;

public class CreationInstructorDemo {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			int id = 3;
			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class,id);
			
			Course c1 = new Course("Air Guitar - The ultimate Guide");
			Course c2 = new Course("The Pinball Masterclass");
			
			
			
			instructor.add(c1);
			instructor.add(c2);
			
			session.save(c1);
			session.save(c2);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
