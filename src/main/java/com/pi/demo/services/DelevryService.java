package com.pi.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.demo.model.Commande;
import com.pi.demo.model.Delevry;
import com.pi.demo.model.DeliveryStatus;
import com.pi.demo.repository.DelevryRepository;
import com.pi.demo.repository.iCommandeRepository;

import java.util.Date;
import java.text.SimpleDateFormat;


import java.util.List;


@Service
public class DelevryService {
	
	@Autowired
	DelevryRepository dr;
	
	@Autowired
	iCommandeRepository cr;
	
	
	public Delevry addDelivery(Delevry d) {
		Commande c = (Commande)cr.findById(d.getCommande().getId()).orElse(null);
		d.setCommande(c);
		d.setEtat(DeliveryStatus.enAttente);
		dr.save(d);
		return d;
		
	}
	
	public void deleteDelivery(int idDelivery) {
		System.out.println(dr.findById(idDelivery)+"ee");
		dr.deleteById(idDelivery);
		
		
	}
	public  List<Delevry> getDelevry() {
		return (List<Delevry>) dr.findAll();
	}
	
	public void marquerEnAttente(int idDelivery) {
		Delevry d = (Delevry)dr.findById(idDelivery).orElse(null);
		System.out.println(d+"ee");
		d.setEtat(DeliveryStatus.enAttente);
		dr.save(d);
	}
	
	
	public void marquerEnCours(int idDelivery) {
		Delevry d = (Delevry)dr.findById(idDelivery).orElse(null);
		d.setEtat(DeliveryStatus.enCours);
		dr.save(d);
	}
	
	public void marquerDone(int idDelivery) {
		Delevry d = (Delevry)dr.findById(idDelivery).orElse(null);
		Date date = new Date();
		d.setDeliveryDate(date);
		d.setEtat(DeliveryStatus.done);
		dr.save(d);
	}
	
	public String getDeliveryStatus(int idDelivery ) {
		Delevry d = (Delevry)dr.findById(idDelivery).orElse(null);
		return d.getEtat().toString();
		
		
	}
//	
//	
	public List<Delevry> getCurrentDeliveriesForDeliveryMan(int idDeliveryMan)
	{
		return dr.getCurrentDeliveriesForDeliveryMan(DeliveryStatus.done,idDeliveryMan);
	}
	
	public List<Delevry> getCurrentDeliveries()
	{
		return dr.getCurrentDeliveries(DeliveryStatus.done);
	}
	
	public List<Delevry> getHistoryDeliveries()
	{
		return dr.getHistoryDeliveries(DeliveryStatus.done);
	}
	// partie metier:calcul de temps moyen ,duree totale de livraison fct mathematique
	public long getTempsAttenteDelivery(int idDelivery)
	{
		Delevry d = (Delevry)dr.findById(idDelivery).orElse(null);
		long duree = Math.abs(d.getDeliveryDate().getTime()-d.getCommande().getDateOrder().getTime());
		
		return duree;
	}
	
	public long getTempsAttenteMoyen()
	{
		long dureeTotale=0;
		for(Delevry d: getHistoryDeliveries() )
		{
			dureeTotale+=  Math.abs(d.getDeliveryDate().getTime()-d.getCommande().getDateOrder().getTime());
		}
		long moyenne=dureeTotale/getHistoryDeliveries().size();
		
		return moyenne;
	}
	
	

}

