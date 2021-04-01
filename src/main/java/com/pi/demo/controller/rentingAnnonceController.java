package com.pi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.RentingAnnonce;
import tn.dari.services.AnnocceRentingImpl;
import tn.dari.services.IannonceRentingService;
import tn.dari.services.StripeService;

@RestController
@RequestMapping("/renting")
public class rentingAnnonceController {
	@Value("${stripe.key.public}")
	private String API_PUBLIC_KEY;
	private StripeService stripeService;
	
	public rentingAnnonceController(StripeService stripeService) {
		this.stripeService = stripeService;
	}
	@Autowired
	IannonceRentingService annoncerentingService;
	@Autowired
	AnnocceRentingImpl annr ;
	
	
	@GetMapping(value = "/retrieves-all-rentingannonce")
	@ResponseBody
	public List<RentingAnnonce> getAnnonce() {
		List<RentingAnnonce> list = annoncerentingService.retreiveAllRentingAnnonce();
		return list;
	}
	
	@PostMapping(value="save-renting-annonce")
	public RentingAnnonce saveProduct(@RequestBody RentingAnnonce ann) {
		annoncerentingService.addRentingAnnonce(ann);
		return ann;
	
	}
	  //creating a put  mapping that upgrade rent annonce
  	@PutMapping("/update-rentannonce/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentAnnonce(
  		@RequestBody RentingAnnonce rentannonce,@PathVariable("id")int id) {
  		annoncerentingService.updateRentingAnnonce(rentannonce,id);
  		return new ResponseEntity<String>("rent annonce updated successfully",HttpStatus.OK);
  		
  	}
	@DeleteMapping("/delete-rentingannonce/{id}")
  	@ResponseBody
  	public ResponseEntity<String>  deleteRentingannonce(
  		@RequestBody RentingAnnonce rentingannonce,@PathVariable("id")int id) {
		annoncerentingService.DeleteRentingAnnonce(id);
  	    return new ResponseEntity<String>("Renting annonce deleted successfully",HttpStatus.ACCEPTED);
  		
  	}
	@GetMapping(value = "/estimation/{roomNumber}")
	@ResponseBody
	public  double Prediction(@PathVariable("roomNumber") int roomNumber){
		 return annr.EstimationByRoomNumber(roomNumber);	
	}
	@GetMapping(value = "/priceOfRent/{price}/{nb_jours}")
	@ResponseBody
	public  long PriceOfRent(@PathVariable("price") long price,@PathVariable("nb_jours") int nb_jours){
		 return annr.priceofRent(price, nb_jours);	
	}
	
	@PutMapping("/update-annAccepted/{annId}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentannAccepted(@PathVariable("annId")int annId) {
		
		annoncerentingService.acceptAnnonceJPQL(annId);
  		return new ResponseEntity<String>("rent annonce updated successfully",HttpStatus.OK);
  		
  	}
	@PutMapping("/update-annDenied/{annId}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentannDenied(@PathVariable("annId")int annId) {
		
		annr.DeniedAnnonceJPQL(annId);
  		return new ResponseEntity<String>("rent annonce updated successfully",HttpStatus.OK);
  		
  	}
	@PutMapping("/favourite/{annId}")
  	@ResponseBody
  	public ResponseEntity<String> favourit(@PathVariable("annId")int annId) {
		
		annr.favouritAnnonceJPQL(annId);
  		return new ResponseEntity<String>("annoce added to favourite",HttpStatus.OK);
  		
  	}
	@GetMapping(value = "/Total/{id}")
	@ResponseBody
	public  long PriceOfRents(@PathVariable("id") int id){
		 return annr.TotalAPaye(id);	
	}
	@PostMapping(value = "/payement/{email}/{token}/{id}")
	public  String PayerRent(@PathVariable String email,@PathVariable String token,@PathVariable int id){
		int price = (int) PriceOfRents(id);
		return stripeService.createCharge(email, token,price);
	}
	@GetMapping(value = "/search/{keyword}")
     public List<RentingAnnonce> dynamicSearch(@PathVariable String keyword){
		return annr.DynamicSearch(keyword);
    	 
     }
	@GetMapping(value = "/latestRentingAnnonce")
    public List<RentingAnnonce> latestRentingAnnonce(){
		return annr.latestRentingAnnonce();
   	 
    }
	@GetMapping(value = "/BestReviewed")
    public List<RentingAnnonce> BestReviewed(){
		return annr.BestReviewed();
   	 
    }
}
