package com.pi.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.pi.demo.model.Customer;
import com.pi.demo.model.SubType;

@Entity
public class Subscription implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Primary Key
	private boolean renew;
	private Double price;
	private Date startDate;
	private Date endDate;
	
	@Enumerated(EnumType.STRING)
	SubType subType;
	
	@OneToOne(mappedBy="subscription")
	private Customer customer;
	
	public Subscription() {
		super();
	}

	public Subscription(long id, boolean renew, Double price, Date startDate, Date endDate, SubType subType,
			Customer customer) {
		super();
		this.id = id;
		this.renew = renew;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.subType = subType;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isRenew() {
		return renew;
	}

	public void setRenew(boolean renew) {
		this.renew = renew;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public SubType getSubType() {
		return subType;
	}

	public void setSubType(SubType subType) {
		this.subType = subType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
