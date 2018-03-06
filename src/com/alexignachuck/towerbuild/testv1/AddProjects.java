package com.alexignachuck.towerbuild.testv1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.alexignachuck.towerbuild.entity.Project;
import com.alexignachuck.towerbuild.entity.Tower;

public class AddProjects {

	public static void main(String[] args) {

		//create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Tower.class)
								.addAnnotatedClass(Project.class)
								.buildSessionFactory();
				
		//create a Session
		Session session = factory.getCurrentSession();
		
		
		try {	
			
						
			//being transaction
			session.beginTransaction();
			
			//get the tower from db
			int theId = 2;
			Tower tempTower = session.get(Tower.class, theId);
			
			//create some projects
			
			Project project1 = new Project("Sprint", 55454, "Black & Veatch", "Joe", "Schmoe", "jschmoe@bv.com");
			Project project2 = new Project("Catholic Radio Network", 77757, "Catholic Radio", "Edward", "Strange", "strange@godradio.com");
			Project project3 = new Project("AT&T", 5509333, "NB&C", "Tommy", "Wiseau", "tommy@nbcllc.com");
			
			//add projects to tower
			tempTower.add(project1);
			tempTower.add(project2);
			tempTower.add(project3);
			
			//save the projects
			
			session.save(project1);
			session.save(project2);
			session.save(project3);
		
			
			//commit the tranaction
			session.getTransaction().commit();
		
			
			
		} finally {
			
			//close the factory
			factory.close();
			
		}
				
	}

}
