package com.pi.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.pi.demo.model.Property;

@Entity
public class Furniture extends Property implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date date;
	private String type;
	private String state;
	
	
	public Furniture() {
		super();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
