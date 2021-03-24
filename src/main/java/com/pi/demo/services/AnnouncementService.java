package com.pi.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.demo.model.Announcement;
import com.pi.demo.repository.IAnnouncementRepository;



@Service
public class AnnouncementService implements IAnnouncementService {
	@Autowired
	IAnnouncementRepository announcementRepository ;
	@Override
	public Announcement ajouterAnnounce(Announcement announcement) 
	{
		// TODO Auto-generated method stub
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
		return announcementRepository.countByType(type);
	}

}
