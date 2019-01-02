package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Person;
import com.bean.PersonDetail;
import com.util.PersonUtil;

public class PersonDao {

	public static void insertPersonDetail(PersonDetail pd) {
		Session session = PersonUtil.getConnection();
		Transaction tr = session.beginTransaction();
		session.save(pd);
		tr.commit();
		session.close();
	}

	public static void insertPersonDetail(Person p) {
		Session session = PersonUtil.getConnection();
		Transaction tr = session.beginTransaction();
		session.save(p);
		tr.commit();
		session.close();
		
	}
	
	
	public static List<Person> getAll() {
		Session session = PersonUtil.getConnection();
		List<Person> list = session.createQuery("from Person").list();
		session.close();
		return list;
	}

	public static Person findById(int pid) {
		Person p = null;
		Session session = PersonUtil.getConnection();
		p = (Person)session.get(Person.class, pid);
		session.close();
		return p;
	}

	public static void doUpdatePerson(Person p) {
		Session session = PersonUtil.getConnection();
		Transaction tr = session.beginTransaction();
		session.update(p);
		tr.commit();
		session.close();
	}
	
	public static void doUpdatePersonDetail(PersonDetail pd) {
		Session session = PersonUtil.getConnection();
		Transaction tr = session.beginTransaction();
		session.update(pd);
		tr.commit();
		session.close();
	}

	public static void deletePerson(int pid) {
		Person p = findById(pid);
		PersonDetail pd = p.getpDetail();
		Session session = PersonUtil.getConnection();
		Transaction tr = session.beginTransaction();
		session.delete(p);
		session.delete(pd);
		tr.commit();
		session.close();
	}
}
