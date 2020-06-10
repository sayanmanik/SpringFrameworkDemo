package com.sayan.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sayan.jdbc.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			System.out.println("Creating a new Student object...");
			Student s1 = new Student("abc","xyz","abc@gmail.com");
			Student s2 = new Student("pqr","mno","pqr@gmail.com");
			Student s3 = new Student("rst","efg","rst@gmail.com");
			
			
			session.beginTransaction();
			
			System.out.println("Saving the student...");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
		}finally{
			factory.close();
		}


	}

}
