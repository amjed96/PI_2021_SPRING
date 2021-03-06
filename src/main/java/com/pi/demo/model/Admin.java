package com.pi.demo.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
//@DiscriminatorValue(value = "Admin")
public class Admin extends User implements Serializable {
	
	private String name;
	private String area;

	public Admin() {
		super();

	}

	public Admin(String name, String area) {
		super();
		this.name = name;
		this.area = area;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
