package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Course;
import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;
import com.sayan.jdbc.entity.Student;

public class DeleteCoursesDemo {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			int id = 15;
			session.beginTransaction();

			Course c1 = session.get(Course.class, id);
			
			session.delete(c1);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			id = 16;
			session.beginTransaction();

			Course c2 = session.get(Course.class,id);
			session.delete(c2);
			session.getTransaction().commit();
			
			
			System.out.println("Done!!!");
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
