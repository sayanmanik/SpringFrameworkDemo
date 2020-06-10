package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Course;
import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;
import com.sayan.jdbc.entity.Review;
import com.sayan.jdbc.entity.Student;

public class CreationCourseAndStudentDemo {

	
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
			
			session.beginTransaction();
		
			Course tempCourse = new Course("Pacman - How to score 100");
			
			Student s1 = new Student("Sayan","Manik","sayanmanik.sm@gmail.com");
			Student s2 = new Student("Prabhas","Manik","prabhas.manik@gmail.com");
			
			tempCourse.addStudent(s1);
			tempCourse.addStudent(s2);
			
			session.save(s1);
			session.save(s2);
			
			session.save(tempCourse);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
			session.close();
			factory.close();
		}
	}
}
