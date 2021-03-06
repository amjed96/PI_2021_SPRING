package com.pi.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
//@DiscriminatorValue(value = "Consultant")
public class Consultant extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String domain;
	private Double salary;
	
	
	public Consultant() {
		super();
	}

	
	public Consultant(long id, String firstName, String lastName, String password, Double idC, Double number,
			String email, Set<Message> recievedMessage, Set<Message> sendMessage, String domain, Double salary) {
		super(id, firstName, lastName, password, idC, number, email, recievedMessage, sendMessage);
		// TODO Auto-generated constructor stub
		this.domain = domain;
		this.salary = salary;
	}


	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		domain = domain;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		salary = salary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
