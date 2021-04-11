package com.pi.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.pi.demo.model.Announcement;
import com.pi.demo.model.Appointment;
import com.pi.demo.model.Complaint;
import com.pi.demo.model.Favorites;
import com.pi.demo.model.GaranteeFolder;
import com.pi.demo.model.Subscription;

@Entity
public class Customer extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String picture;
	private String DescriptionBlock;
	private String Address;
	
	@OneToMany
	private Set<Favorites> favorites;
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private Set<Announcement> announcements;
	@OneToOne
	private Favorites Favori;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private Set<Complaint> complaints;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="customerr")
	private Set<Appointment> appointments;
 
	
	@OneToOne
	private Subscription subscription;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GaranteeFolder guarenteeFolder;

	@OneToMany(mappedBy = "customerr", cascade = CascadeType.ALL)
	private Set<Appointment> requests;
	
	public Customer() {
		super();
	}

	public Customer(String picture, String descriptionBlock, String address, Set<Favorites> favorites,
			Set<Announcement> announcements, Favorites favori, Set<Complaint> complaints, Set<Appointment> appointments,

			/*Basket basket,*/ Subscription subscription, GaranteeFolder guarenteeFolder) {


		super();
		this.picture = picture;
		DescriptionBlock = descriptionBlock;
		Address = address;
		this.favorites = favorites;
		this.announcements = announcements;
		Favori = favori;
		this.complaints = complaints;
		this.appointments = appointments;

		//this.basket = basket;
		this.subscription = subscription;

		this.guarenteeFolder = guarenteeFolder;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescriptionBlock() {
		return DescriptionBlock;
	}

	public void setDescriptionBlock(String descriptionBlock) {
		DescriptionBlock = descriptionBlock;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Set<Favorites> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<Favorites> favorites) {
		this.favorites = favorites;
	}

	public Set<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(Set<Announcement> announcements) {
		this.announcements = announcements;
	}

	public Favorites getFavori() {
		return Favori;
	}

	public void setFavori(Favorites favori) {
		Favori = favori;
	}

	public Set<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public GaranteeFolder getGuarenteeFolder() {
		return guarenteeFolder;
	}

	public void setGuarenteeFolder(GaranteeFolder guarenteeFolder) {
		this.guarenteeFolder = guarenteeFolder;
	}

	public Set<Appointment> getRequests() {
		return requests;
	}

	public void setRequests(Set<Appointment> requests) {
		this.requests = requests;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
			
}

