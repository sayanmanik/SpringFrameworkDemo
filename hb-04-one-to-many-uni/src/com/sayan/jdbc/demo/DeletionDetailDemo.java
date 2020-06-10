package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;
import com.sayan.jdbc.entity.Student;

public class DeletionDetailDemo {

	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		int id=3;
		
		try{
			
			session.beginTransaction();
			System.out.println("Getting details of id:"+id);

			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			System.out.println(detail.getId()+"");
			
			detail.getInstructor().setInstructorDetail(null);
			
			System.out.println("Deleting details:"+detail);
			session.delete(detail);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
			factory.close();
			
		}
	}
}
