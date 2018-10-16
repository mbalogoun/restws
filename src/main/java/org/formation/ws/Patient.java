package org.formation.ws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {
	
	private long id;
	private String name;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
