package com.pi.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Announcement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	
	private String Title;
	private String Description;
	private boolean Available;
	private String Type;
	private Date StartDate;
	private Date EndDate;
	private Date Duration;
	@ManyToMany(mappedBy="annoucements", cascade = CascadeType.ALL)
	private Set<Favorites> favorites;
	
	@OneToOne
	private Property property;
	
	@ManyToOne
	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="announcement")
	private Set<Like> like;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="announcement")
	private Set<Dislike> dislike;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="announcement")
	private Set<Comment> comment;
	public Announcement() {
		super();
	}

	public Announcement(long id, String title, String description, boolean available, String type, Date startDate,
			Date endDate, Date duration, Set<Favorites> favorites, Property property, Customer customer, Set<Like> like,
			Set<Dislike> dislike) {
		super();
		this.id = id;
		Title = title;
		Description = description;
		Available = available;
		Type = type;
		StartDate = startDate;
		EndDate = endDate;
		Duration = duration;
		this.favorites = favorites;
		this.property = property;
		this.customer = customer;
		this.like = like;
		this.dislike = dislike;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public boolean isAvailable() {
		return Available;
	}
	public void setAvailable(boolean available) {
		Available = available;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Date getDuration() {
		return Duration;
	}
	public void setDuration(Date duration) {
		Duration = duration;
	}
	
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Favorites> getFavorites() {
		return favorites;
	}
	public void setFavorites(Set<Favorites> favorites) {
		this.favorites = favorites;
	}


	public Set<Like> getLike() {
		return like;
	}


	public void setLike(Set<Like> like) {
		this.like = like;
	}

	public Set<Dislike> getDislike() {
		return dislike;
	}

	public void setDislike(Set<Dislike> dislike) {
		this.dislike = dislike;
	}

	
	
}
	