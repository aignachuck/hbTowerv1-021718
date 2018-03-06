package com.alexignachuck.towerbuild.testv1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alexignachuck.towerbuild.entity.Tower;

public class AddTower {

	public static void main(String[] args) {

		//create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Tower.class)
								.buildSessionFactory();
				
		//create a Session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			//use factory to create database items
			System.out.println("Creating Towers.");
//			Tower tower1 = new Tower(1000, "Tower One", "Pelham", "NH");
//			Tower tower2 = new Tower(1001, "Tower Two", "Boston", "MA");
			Tower tower3 = new Tower(1002, "Tower Three", "Manchester", "NH");
			Tower tower4 = new Tower(1010, "Maynard DT", "Maynard", "MA");		
			
			
			
			//being transaction
			session.beginTransaction();
			
			//save items
			System.out.println("Saving Towers to the Database!");
//			session.save(tower1);
//			session.save(tower2);
			session.save(tower3);
			session.save(tower4);
			
			//commit the tranaction
			session.getTransaction().commit();
			System.out.println("Towers committed to Database.");
			
			
		} finally {
			
			//close the factory
			factory.close();
			
		}
				
	}

}
