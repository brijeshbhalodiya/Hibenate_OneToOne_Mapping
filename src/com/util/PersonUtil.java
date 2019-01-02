package com.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Person;
import com.bean.PersonDetail;



public class PersonUtil {
	
	public static Session getConnection() {
		Session session=null;
		SessionFactory sf = null;
		
		sf= new Configuration()
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(PersonDetail.class)
				.configure()
				.buildSessionFactory();
		
		session = sf.openSession();
		return session;
	}

}
