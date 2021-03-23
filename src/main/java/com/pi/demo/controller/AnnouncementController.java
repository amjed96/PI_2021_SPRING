package com.pi.demo.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pi.demo.model.Announcement;
import com.pi.demo.services.IAnnouncementService;



@RestController
public class AnnouncementController implements Serializable{
	@Autowired
	IAnnouncementService announcementService ;
	  // Ajouter Annonce : http://localhost:8085/SpringMVC/servlet/add-announcement
	  @PostMapping("/add-announcement")
	  @ResponseBody
	  public Announcement addAnnounce(@RequestBody Announcement announcement) { 
		  Announcement announcements = announcementService.ajouterAnnounce(announcement);
	  return announcements;
	  }
	//Afficher annonce http://localhost:8085/SpringMVC/servlet/getAll
		 @GetMapping("/getAll")
		 public List<Announcement> getAnnounce() {
		 List<Announcement> list = announcementService.getAllAnnounce();
		 return list;
		 }
	//supprimer annonce http://localhost:8081/SpringMVC/servlet/delete/{announce-id}
		   @DeleteMapping("/delete/{announce-id}")
		   @ResponseBody
		   public void delete(@PathVariable("announce-id") int id) {
		   announcementService.deleteAnnounce(id);
		   }
	//modifier annonce http://localhost:8085/SpringMVC/servlet/modify
		   @PutMapping("/modify")
		   @ResponseBody
		   public Announcement modifyAnnounce(@RequestBody Announcement announce) {
		   return announcementService.update(announce);
		   }
		// http://localhost:8081/SpringMVC/servlet/GetDetail/{announce-id}
			 @GetMapping("/GetDetail/{announce-id}")
			 @ResponseBody
			  public Announcement GetDetail(@PathVariable("announce-id") String id) 
			  {
			  return announcementService.GetId(id);
			  }
			 
			 @DeleteMapping("/delete")
			   @ResponseBody
			   public void deleteAll() {
			   announcementService.DeleteAll();
			   }
			/* @GetMapping("/find/{type}")
			 @ResponseBody
			  public  List<Announcement> find(@PathVariable("type") String type) 
			  {
			  return announcementService.FindByType(type);
			  }*/
}
