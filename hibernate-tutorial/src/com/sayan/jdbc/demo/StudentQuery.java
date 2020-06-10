package com.sayan.jdbc.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Student;

public class StudentQuery {
	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			
			System.out.println("All the students--->>");
			List<Student> list = session
					.createQuery("from Student")
					.getResultList();
			
			display(list);
			
			
			System.out.println("\n");

			System.out.println("All the students whose last name is 'xyz'--->>");
			list = session
					.createQuery("from Student where lastName = 'xyz'")
					.getResultList();
			display(list);
			
			System.out.println("\n\n");

			System.out.println("All the students whose email consists of 'gmail.com'--->>");
			list = session
					.createQuery("from Student where email like '%gmail.com'")
					.getResultList();
			
			display(list);
			
			session.getTransaction().commit();
			
			System.out.println();
			System.out.println("Done!!!");
			
		}finally{
			factory.close();
		}
	}
	
	public static void display(List<Student> students){
		
		for(Student s:students){
			System.out.println(s);
		}
	}
	
}
