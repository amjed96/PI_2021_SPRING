package com.pi.demo.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.lowagie.text.DocumentException;
import com.pi.demo.model.Announcement;
import com.pi.demo.services.IAnnouncementService;
import com.pi.demo.services.PDFExporterService;
import com.pi.demo.services.SsePushNotificationService;



@RestController
@CrossOrigin(origins = "*")
public class AnnouncementController implements Serializable{
	@Autowired
	IAnnouncementService announcementService ;
	@Autowired
	SsePushNotificationService service;
	final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
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
			@GetMapping("/find/{type}")
			 @ResponseBody
			  public  List<Announcement> find(@PathVariable("type") String type) 
			  {
			  return announcementService.FindByType(type);
			  }
			@GetMapping("/count")
			 @ResponseBody
			  public long Count() 
			  {
			  return announcementService.CountAnnouncement();
			  }
			@GetMapping("/count/{type}")
			 @ResponseBody
			  public long CountByType(@PathVariable("type") String type) 
			  {
			  return announcementService.CountAnnouncementByType(type);
			  }
			@PutMapping("/affect/{idF}/{idA}")
			 @ResponseBody
			  public void affecter(@PathVariable("idF") int idF ,@PathVariable("idA") int idA) 
			  {
			       announcementService.affecterAnnouncementtoFavorites(idA, idF);
			  }
			
	      @GetMapping("/annonce/export/pdf")
			    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
			        response.setContentType("application/pdf");
			        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			        String currentDateTime = dateFormatter.format(new Date());
			         
			        String headerKey = "Content-Disposition";
			        String headerValue = "attachment; filename=annoucement_" + currentDateTime + ".pdf";
			        response.setHeader(headerKey, headerValue);
			         
			        List<Announcement> a = announcementService.getAllAnnounce();
			         
			        PDFExporterService exporter = new PDFExporterService(a);
			        exporter.export(response);
			         
			    }
	     

	  	@PostMapping("/notification")
	  	public ResponseEntity<SseEmitter> doNotify(@RequestBody Announcement announcement) throws InterruptedException, IOException {
	  	  Announcement announcements = announcementService.ajouterAnnounce(announcement);
	  		final SseEmitter emitter = new SseEmitter();
	  		service.addEmitter(emitter);
	  		service.doNotify();
	  		emitter.onCompletion(() -> service.removeEmitter(emitter));
	  		emitter.onTimeout(() -> service.removeEmitter(emitter));
	  		return new ResponseEntity<>(emitter, HttpStatus.OK);
	  	}

			
}
