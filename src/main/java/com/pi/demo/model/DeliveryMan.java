package com.pi.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
	@DiscriminatorValue("DeliveryMan")
	public class DeliveryMan extends User implements Serializable  {
		
		
		@OneToMany(mappedBy="livreur")
		private List<Delevry> livraisons;
		
		@Enumerated(EnumType.STRING)
		private DeliveryManStatus etat;
		
		public DeliveryMan()
		{
			super();
		}
		
		
		public DeliveryMan(int id)
		{
			super();
		}
		
		
}
