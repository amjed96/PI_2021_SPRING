package com.pi.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.pi.demo.model.User;

@Entity
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	
	private String title;
	private String contents;
	
	@ManyToOne
	private User recieverUser;
	
	@ManyToOne
	private User sendUser;

	
	public Message() {
		super();
	}

	public Message(long id, String title, String contents, User recieverUser, User sendUser) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.recieverUser = recieverUser;
		this.sendUser = sendUser;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public User getRecieverUser() {
		return recieverUser;
	}

	public void setRecieverUser(User recieverUser) {
		this.recieverUser = recieverUser;
	}

	public User getSendUser() {
		return sendUser;
	}

	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
