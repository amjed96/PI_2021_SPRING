package com.pi.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.pi.demo.model.Message;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id; // Clé primaire
	private String firstName;
	private String lastName;
	private String password;
	private Double idC;
	private Double number;
	private String email;
	
	@OneToMany(mappedBy = "recieverUser")
	private Set<Message> recievedMessage;
	@OneToMany(mappedBy = "sendUser")
	private Set<Message> sendMessage;
	
	
	public User() {
		super();
	}

	public User(long id, String firstName, String lastName, String password, Double idC, Double number, String email,
			Set<Message> recievedMessage, Set<Message> sendMessage) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.idC = idC;
		this.number = number;
		this.email = email;
		this.recievedMessage = recievedMessage;
		this.sendMessage = sendMessage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getIdC() {
		return idC;
	}

	public void setIdC(Double idC) {
		this.idC = idC;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Message> getRecievedMessage() {
		return recievedMessage;
	}

	public void setRecievedMessage(Set<Message> recievedMessage) {
		this.recievedMessage = recievedMessage;
	}

	public Set<Message> getSendMessage() {
		return sendMessage;
	}

	public void setSendMessage(Set<Message> sendMessage) {
		this.sendMessage = sendMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
