package com.pi.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="dislikes") 
public class Dislike implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long id;
	@Column(name="NumDilike")
	private int NumDislike;
	@ManyToOne
	Announcement announcement;
	
	public Dislike() {
		super();
	}

	public Dislike(long id, int numDislike, Announcement announcement) {
		super();
		this.id = id;
		NumDislike = numDislike;
		this.announcement = announcement;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumDislike() {
		return NumDislike;
	}

	public void setNumDislike(int numDislike) {
		NumDislike = numDislike;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	
	
}
