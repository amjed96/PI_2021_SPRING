package com.pi.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	
	private Float Price;
	private String Picture;
    private String Address;
	
    
    public Property() {
		super();
	}

	public Property(long id, Float price, String picture, String address) {
		super();
		this.id = id;
		Price = price;
		Picture = picture;
		Address = address;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Float getPrice() {
		return Price;
	}


	public void setPrice(Float price) {
		Price = price;
	}


	public String getPicture() {
		return Picture;
	}


	public void setPicture(String picture) {
		Picture = picture;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
