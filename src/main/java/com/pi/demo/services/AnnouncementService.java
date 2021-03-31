package com.pi.demo.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.demo.model.Announcement;
import com.pi.demo.model.Favorites;
import com.pi.demo.repository.IAnnouncementRepository;
import com.pi.demo.repository.IFavoritesRepository;
import com.sun.el.parser.ParseException;



@Service
public class AnnouncementService implements IAnnouncementService {
	@Autowired
	IAnnouncementRepository announcementRepository ;
	@Autowired
	IFavoritesRepository favoriteRepository;
	@Override
	public Announcement ajouterAnnounce(Announcement announcement) 
	{
// TODO Auto-generated method stub
		//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	   long diffInMillies = Math.abs(announcement.getEndDate().getTime() - announcement.getStartDate().getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    announcement.setDuration(diff);
	   // System.out.println(diff);
	    //System.out.println(diff);
		return announcementRepository.save(announcement);
	}

	@Override
	public List<Announcement> getAllAnnounce() {
		// TODO Auto-generated method stub
		return  (List<Announcement>)announcementRepository.findAll();
	}

	@Override
	public void deleteAnnounce(long announceId) {
		// TODO Auto-generated method stub
		announcementRepository.deleteById(announceId);
		
	}

	@Override
	public Announcement update(Announcement announcement) {
		// TODO Auto-generated method stub
		return announcementRepository.save(announcement);
	}

	@Override
	public Announcement GetId(String id) {
		// TODO Auto-generated method stub
		return announcementRepository.findById((long) Long.parseLong(id)).orElse(null);
	}

	@Override
	public void DeleteAll() {
		// TODO Auto-generated method stub
		announcementRepository.deleteAll();
		
	}

	@Override
	public List<Announcement> FindByType(String type) {
		// TODO Auto-generated method stub
		return (List<Announcement>)announcementRepository.findByType(type);
	}
	
	@Override
	public long  CountAnnouncement() {
		// TODO Auto-generated method stub
		return announcementRepository.count();
	}

	@Override
	public long CountAnnouncementByType(String type) {
		// TODO Auto-generated method stub
		System.out.println("Number of annoucements are :");
		return announcementRepository.countByType(type);
	}

	@Override
	public void affecterAnnouncementtoFavorites(int idA, int idF)
	{
		Favorites favorites =favoriteRepository.findById((long)idF).orElse(null);
		Announcement announcement = announcementRepository.findById((long)idA).orElse(null);
		favorites.getAnnoucements().add(announcement);
		if(announcement.getFavorites() == null) {
			Set<Favorites> setFavo = new HashSet<Favorites>();
			setFavo.add(favorites);
			announcement.setFavorites(setFavo); //update
		}
		else {
			announcement.getFavorites().add(favorites);//affecta annoce f favoris
		}
		favoriteRepository.save(favorites);
		announcementRepository.save(announcement); //ajout
  }

	@Override
	public    List<Announcement> getPdf(long id) {
		// TODO Auto-generated method stub
		return announcementRepository.pdf(id);
	}
	
	@Override
	public List<Announcement> FindByTitle(String title) {
		// TODO Auto-generated method stub
		return (List<Announcement>)announcementRepository.findByTitle(title);
	}

	@Override
	public List<Announcement> orderByDate() {
		// TODO Auto-generated method stub
		return (List<Announcement>)announcementRepository.orderByDate();
	}
	

}
