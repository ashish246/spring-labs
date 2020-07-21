package com.spring.orm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static final Logger logger = LoggerFactory
			.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details=" + p);
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for (Person p : personsList) {
			logger.info("Person List::" + p);
		}
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details=" + p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details=" + p);
	}

}