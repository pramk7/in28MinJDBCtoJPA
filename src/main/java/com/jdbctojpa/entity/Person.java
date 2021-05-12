package com.jdbctojpa.entity;

import java.time.LocalDateTime;

public class Person {
	private int id;
	private String name;
	private String location;
	private LocalDateTime birthDate;
	
	
	
	
	public Person() {
	}


	public Person(Integer id, String name, String location, LocalDateTime birthDate) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	
	
	



	@Override
	public String toString() {
		return "{'id':'" + id + "', 'name':'" + name + "', 'location':'" + location + "', 'birthDate':'" + birthDate + "'}";
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
