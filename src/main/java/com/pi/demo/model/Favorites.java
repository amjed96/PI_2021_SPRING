package com.pi.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.pi.demo.model.Announcement;

@Entity
public class Favorites implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // Clé primaire
	
	private String Name;
	private String Type;
  
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Announcement> annoucements;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String type) {
		Type = type;
	}
	
	
	public Set<Announcement> getAnnoucements() {
		return annoucements;
	}

	public void setAnnoucements(Set<Announcement> annoucements) {
		this.annoucements = annoucements;
	}

	public Favorites() {
		
	}
	
	public Favorites(long id, String name, String type) {
		super();
		this.id = id;
		Name = name;
		Type = type;
	}

}
