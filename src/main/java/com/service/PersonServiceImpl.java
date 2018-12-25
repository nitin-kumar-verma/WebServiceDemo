package com.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.model.Person;
import com.model.Response;

public class PersonServiceImpl implements PersonService {
	
	private static Map<Integer,Person> persons = new HashMap<Integer,Person>();

	@Override
	@POST
    @Path("/add")
	public Response addPerson(Person person) {
		Response response=new Response();
		if(persons.get(person.getId())!=null) {
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}
		persons.put(person.getId(), person);
		response.setStatus(true);
		response.setMessage("Successfully Added Person");
		return response;
	}

	@Override
	@GET
    @Path("/{id}/delete")
	public Response deletePerson(@PathParam("id")  int id) {
		Response response=new Response();
		if(persons.get(id) == null) {
			response.setMessage("Person Does not exist");
			response.setStatus(false);
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Deleted successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/get")
	public Person getPerson(int id) {
		return persons.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Person getDummyPerson(@PathParam("id") int id) {
		Person person=new Person();
		person.setAge(99);
		person.setName("Dummy");
		person.setId(id);
		return person;
	}

	@Override
	@GET
	@Path("/getAll")
	public Person[] getAllPersons() {
		Set<Integer> ids=persons.keySet();
		Person[] p=new Person[ids.size()];
		int i=0;
		for(Integer id:ids) {
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

}
