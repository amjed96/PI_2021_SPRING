package com.pi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pi.demo.model.Delevry;
import com.pi.demo.services.DelevryService;

import java.util.List;



@RestController
public class DelevryController {
	
	@Autowired
	DelevryService ds;
//	
	@PostMapping("/addDelivery")
	@ResponseBody
	public Delevry addDelivery(@RequestBody Delevry  d ) {
		
		Delevry addedDelivery = ds.addDelivery(d);
		return addedDelivery;
	}
	
	
	
	@DeleteMapping("/deleteDelivery/{id}")
	@ResponseBody
	public void deleteDelivery(@PathVariable("id") int idDelivery) {
		ds.deleteDelivery(idDelivery);
	}
	
	
	@PutMapping("/enAttenteDelivery/{id}")
	@ResponseBody
	public void enAttenteDelivery(@PathVariable("id") int idDelivery) {
		ds.marquerEnAttente(idDelivery);
	}
//	
//	
	@PutMapping("/enCoursDelivery/{id}")
	@ResponseBody
	public void enCoursDelivery(@PathVariable("id") int idDelivery) {
		ds.marquerEnCours(idDelivery);
	}
//	
//	
	@PutMapping("/doneDelivery/{id}")
	@ResponseBody
	public void doneDelivery(@PathVariable("id") int idDelivery) {
		
		ds.marquerDone(idDelivery);
		/*String msg = "votre livraison done : "
		+ "http://localhost:8081/SpringMVC/servlet/getDeliveryStatus/";
msg = msg+d.getId();

NexmoClient client = NexmoClient.builder().apiKey("2a815647").apiSecret("AFM0bqq8YawybYOD").build();
  TextMessage message = new TextMessage("Livraison",
                   "+21654319018",
                    msg
            );
  
  try {
	  SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
	  if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
	    System.out.println("Message sent successfully.");
	} else {
	    System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
	}
  }
  catch(Exception e) {}*/
//
	}
//	
	@GetMapping("/getCurrentDeliveriesForDeliveryMan/{idDeliveryMan}")
	@ResponseBody
	public List<Delevry> getCurrentDeliveriesForDeliveryMan(@PathVariable("idDeliveryMan") int id){
		return ds.getCurrentDeliveriesForDeliveryMan(id);
	}
	
	
	@GetMapping("/getCurrentDeliveries")
	@ResponseBody
	public List<Delevry> getCurrentDeliveries(){
		return ds.getCurrentDeliveries();
	}
	
	
	@GetMapping("/getHistoryDeliveries")
	@ResponseBody
	public List<Delevry> getHistoryDeliveries(){
		return ds.getHistoryDeliveries();
	}
	
	
	@GetMapping("/getTempsAttenteDelivery/{idDelivery}")
	@ResponseBody
	public long getTempsAttenteDelivery(@PathVariable("idDelivery") int idDelivery){
		return ds.getTempsAttenteDelivery(idDelivery);
	}
	
	@GetMapping("/getTempsAttenteMoyen")
	@ResponseBody
	public long getTempsAttenteMoyen(){
		return ds.getTempsAttenteMoyen();
	}
//	
	@GetMapping("/getDeliveryStatus/{idDelivery}")
	@ResponseBody
	public String getDeliveryStatus(@PathVariable("idDelivery") int idDelivery){
		return ds.getDeliveryStatus(idDelivery);
	}
//	
	@GetMapping("/getDeliveries")
	@ResponseBody
	public List<Delevry> getDelevry(){
		return ds.getDelevry();
	}
	
	
	

}
