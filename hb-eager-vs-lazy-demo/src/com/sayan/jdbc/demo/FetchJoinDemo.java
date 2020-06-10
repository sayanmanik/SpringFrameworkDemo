package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sayan.jdbc.entity.Course;
import com.sayan.jdbc.entity.Instructor;
import com.sayan.jdbc.entity.InstructorDetail;

public class FetchJoinDemo {

	
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

			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+"JOIN FETCH i.courses "
							+"where i.id=:id",
							Instructor.class);
			
			query.setParameter("id", id);
			Instructor temp = query.getSingleResult();
			
			System.out.println("Instructor :"+ temp.getFirstName()+" "+temp.getLastName()+" "+temp.getEmail());
			
			
			session.getTransaction().commit();
			session.close();
			
			
//			System.out.println(inst.getCourses());
			
//			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
//			session.close();
			factory.close();
		}
	}
}
