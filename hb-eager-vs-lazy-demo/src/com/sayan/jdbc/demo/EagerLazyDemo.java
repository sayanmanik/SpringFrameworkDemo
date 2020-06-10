package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Course;
import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;
import com.sayan.jdbc.entity.Student;

public class EagerLazyDemo {

	
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

			Instructor inst = session.get(Instructor.class, id);
			//System.out.println(inst.getId()+" "+inst.getFirstName()+" "+inst.getLastName()+" "+inst.getEmail());
			System.out.println("inst: "+inst);
			
			System.out.println(inst.getCourses());
			
			session.getTransaction().commit();
//			session.close();
			
//			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
//			session.close();
			factory.close();
		}
	}
}
