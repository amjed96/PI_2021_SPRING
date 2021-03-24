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
@Table(name="likes") 
public class Like implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long id;
	@Column(name="NumLike")
	private int NumLike;
	@ManyToOne
	Announcement announcement;
	public Like() {
		super();
	}

	

	public Like(long id, int numLike, Announcement announcement) {
		super();
		this.id = id;
		NumLike = numLike;
		this.announcement = announcement;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getNumLike() {
		return NumLike;
	}



	public void setNumLike(int numLike) {
		NumLike = numLike;
	}



	public Announcement getAnnouncement() {
		return announcement;
	}



	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}



	
}
