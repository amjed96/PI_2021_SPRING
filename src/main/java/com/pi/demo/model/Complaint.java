package com.pi.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.pi.demo.model.Announcement;
import com.pi.demo.model.Customer;


@Entity
public class Complaint implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	
	private String title;
	private String content;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Announcement announcement;
	
	@ManyToOne
	Customer customer;

	
	public Complaint() {
		super();
	}

	public Complaint(long id, String title, String content, Announcement announcement, Customer customer) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.announcement = announcement;
		this.customer = customer;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
