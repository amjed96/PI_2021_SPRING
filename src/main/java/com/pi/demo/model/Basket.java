package com.pi.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.pi.demo.model.Customer;
import com.pi.demo.model.Furniture;

@Entity
public class Basket implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long idCus;
	private long idProperty;

	@OneToMany
	private Set<Furniture> furnitures;
	
    @OneToOne(mappedBy = "basket")
    private Customer customer;

	
    public Basket() {
		super();
	}

	public Basket(long id, long idCus, long idProperty, Set<Furniture> furnitures, Customer customer) {
		super();
		this.id = id;
		this.idCus = idCus;
		this.idProperty = idProperty;
		this.furnitures = furnitures;
		this.customer = customer;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCus() {
		return idCus;
	}

	public void setIdCus(long idCus) {
		this.idCus = idCus;
	}

	public long getIdProperty() {
		return idProperty;
	}

	public void setIdProperty(long idProperty) {
		this.idProperty = idProperty;
	}

	public Set<Furniture> getFurnitures() {
		return furnitures;
	}

	public void setFurnitures(Set<Furniture> furnitures) {
		this.furnitures = furnitures;
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
