package com.pi.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.pi.demo.model.Property;

@Entity
public class Furniture extends Property implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date date;
	private String title;
	
	public Furniture(Date date, String title, String type, State state) {
		super();
		this.date = date;
		this.title = title;
		this.type = type;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String type;
	@Enumerated(EnumType.STRING)
	private State state;
	
	
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



	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
