package com.pi.demo.model;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.pi.demo.model.Customer;
import com.pi.demo.model.House;

@Entity
public class Appointment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	
	private Timestamp dateA;
	private String address;
	private Boolean confirmation;
	
	@ManyToOne
	Customer customerr;
	
	@ManyToOne
	Customer owner;

	
	public Appointment() {
		super();
	}

	public Appointment(Timestamp dateA, String address, Boolean confirmation, Customer customerr,Customer owner) {
		super();
		//this.id = id;
		this.dateA = dateA;
		this.address = address;
		this.confirmation = confirmation;
		this.customerr = customerr;
		this.owner = owner;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDateA() {
		return dateA;
	}

	public void setDateA(Timestamp dateA) {
		this.dateA = dateA;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Boolean confirmation) {
		this.confirmation = confirmation;
	}

	public Customer getCustomerr() {
		return customerr;
	}

	public void setCustomerr(Customer customerr) {
		this.customerr = customerr;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
