package com.pi.demo.services;

import java.util.List;

import com.pi.demo.model.Announcement;

public interface IAnnouncementService
{
	Announcement ajouterAnnounce( Announcement announcement);
	public List<Announcement> getAllAnnounce();
	public void deleteAnnounce(long announceId);
	public Announcement update(Announcement announcement);
	public Announcement GetId(String id);
	void DeleteAll();
	List<Announcement>FindByType(String type);
	public long  CountAnnouncement() ;
	public long  CountAnnouncementByType(String type) ;
}
