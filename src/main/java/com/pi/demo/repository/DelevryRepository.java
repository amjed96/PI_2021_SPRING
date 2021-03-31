package com.pi.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pi.demo.model.Delevry;
import com.pi.demo.model.DeliveryStatus;

import java.util.List;

import org.springframework.data.repository.query.Param;

@Repository
public interface DelevryRepository extends CrudRepository<Delevry, Integer>{
	
	
	@Query("select d from Delevry d where d.etat != :done and d.livreur.id=:idLivreur ")
	List<Delevry> getCurrentDeliveriesForDeliveryMan(@Param("done") DeliveryStatus etat, @Param("idLivreur") int id);
	 
	
	@Query("select d from Delevry d where d.etat != :done")
	List<Delevry> getCurrentDeliveries(@Param("done") DeliveryStatus etat);
	
	
	@Query("select d from Delevry d where d.etat = :done")
	List<Delevry> getHistoryDeliveries(@Param("done") DeliveryStatus etat);
}
	
	
	

