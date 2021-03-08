package com.pi.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credit implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	
	private Double toBeBorrowed;
	private Double propertyPrice;
	private Integer duration;
	private float creditAmount;
	
	
	public Credit() {
		super();
	}

	public Credit(long id, Double toBeBorrowed, Double propertyPrice, Integer duration, float creditAmount) {
		super();
		this.id = id;
		this.toBeBorrowed = toBeBorrowed;
		this.propertyPrice = propertyPrice;
		this.duration = duration;
		this.creditAmount = creditAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getToBeBorrowed() {
		return toBeBorrowed;
	}

	public void setToBeBorrowed(Double toBeBorrowed) {
		this.toBeBorrowed = toBeBorrowed;
	}

	public Double getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(Double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public float getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(float creditAmount) {
		this.creditAmount = creditAmount;
	}

}
