package com.pi.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.pi.demo.model.Appointment;

@Entity
public class House  extends Property implements Serializable {
	
	private String state;
	private Integer numPiece;
	private String material;
	
	public House() {
		super();
	}

	
	

	public House(long id, Float price, String picture, String address, String state,Integer numPiece,
			String material) {
		super(id, price, picture, address);
		// TODO Auto-generated constructor stub
		this.state = state;
		this.numPiece = numPiece;
		this.material = material;
	}



	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getNumPiece() {
		return numPiece;
	}

	public void setNumPiece(Integer numPiece) {
		this.numPiece = numPiece;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
}
