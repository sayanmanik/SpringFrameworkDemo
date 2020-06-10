package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Course;
import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;
import com.sayan.jdbc.entity.Review;
import com.sayan.jdbc.entity.Student;

public class GetCoursesForSayanDemo {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			int id = 4;
			session.beginTransaction();
			
			Student s = session.get(Student.class,id);
			System.out.println("Student:"+s);
			System.out.println("Student Courses:"+s.getCourses());
			
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
