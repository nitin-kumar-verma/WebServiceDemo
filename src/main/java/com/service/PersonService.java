package com.service;

import com.model.Person;
import com.model.Response;

public interface PersonService {
	
	public Response addPerson(Person person);
	
	public Response deletePerson(int id);
	
	public Person getPerson(int id);
	
	public Person[] getAllPersons();
}
