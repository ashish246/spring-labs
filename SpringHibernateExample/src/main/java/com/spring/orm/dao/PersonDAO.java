package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.model.Person;

public interface PersonDAO {

	public void save(Person p);

	public List<Person> list();

}