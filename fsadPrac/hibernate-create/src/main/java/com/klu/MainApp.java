package com.klu;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class MainApp {

	public static void main(String[] args) {
		//Load Configuration & Create the SessionFactory
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		//Open session
		Session session=factory.openSession();
		
		//Begin Transaction
		Transaction tx=session.beginTransaction();
		
		//Create the table/object
		
		Student s = new Student("Ravi");
		
		// save the data / object
		session.save(s);
		
		//commit
		tx.commit();
		
		//close the connection
		session.close();
		factory.close();
		
		System.out.println("Student data inserted Successfully");
		

	}

}