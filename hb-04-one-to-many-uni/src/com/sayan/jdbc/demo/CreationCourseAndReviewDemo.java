package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Course;
import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;
import com.sayan.jdbc.entity.Review;
import com.sayan.jdbc.entity.Student;

public class CreationCourseAndReviewDemo {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
		
			Course tempCourse = new Course("Pacman - How to score 100");
			
			tempCourse.add(new Review("Great Course - loevd it!!"));
			tempCourse.add(new Review("Cool Course - well done!!"));
			tempCourse.add(new Review("Dumb course!!!"));

			
			session.save(tempCourse);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
