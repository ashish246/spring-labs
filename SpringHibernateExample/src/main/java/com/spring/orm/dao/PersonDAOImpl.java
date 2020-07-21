package com.spring.orm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.orm.model.Person;

/**
 * Notice that this is the only place where we are using Hibernate related
 * classes. This pattern makes our implementation flexible and easy to migrate
 * from one technology to another. For example, if we want to use iBatis ORM
 * framework, all we need is to provide a DAO implementation for iBatis and then
 * change the spring bean configuration file.
 * 
 * In above example, I am using Hibernate session transaction management. But we
 * can also use Spring declarative transaction management using @Transactional
 * annotation.
 * 
 * @author Administrator
 *
 */
public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}

}