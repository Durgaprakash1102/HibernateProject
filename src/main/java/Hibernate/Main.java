package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import Hibernate.entity.*;

public class Main {

	public static void main(String[] args) {
		
		//creating the objects for StandardServiceRegistry,Metadata,SessionFactory and Session
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("config.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sfactory=meta.buildSessionFactory();
		Session session=sfactory.openSession();
		
		//creating a transaction
		Transaction t=session.beginTransaction();
		try {
			States s=new States();
			s.setStateName("Arunachal Pradesh");
			
			States s1=new States();
			s1.setStateName("Andra pradesh");
			
			States s2=new States();
			s2.setStateName("Telangana");
			
			Country c=new Country();
			c.setCountrycode(91);
			c.setCountryName("India");
			
			c.getStates().add(s);
			c.getStates().add(s1);
			c.getStates().add(s2);
			
			s.setCountry(c);
			s1.setCountry(c);
			s2.setCountry(c);
			
			session.persist(c);
//			session.save(s);
//			session.save(s1);
//			session.save(s2);
			
			t.commit();
		}finally {
			sfactory.close();
			session.close();
		}
	}

}
