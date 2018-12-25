package com.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement (name="person")
@Data
public class Person {
	
	private String name;
	
	private int id;
	private int age;
	
}
