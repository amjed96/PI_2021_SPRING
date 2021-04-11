package com.pi.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pi.demo.model.Subscription;
import com.pi.demo.services.ISubscriptionService;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

	@Autowired
	ISubscriptionService isubscriptionService;
	
	@GetMapping("/getall")
	@ResponseBody
	public List<Subscription> getSubscription() {
	List<Subscription> list = isubscriptionService.retrieveAllSubscriptions();
	return list;
	}
	
	@GetMapping("/get/{subscription-id}")
	@ResponseBody
	public Subscription retrieveSubscription(@PathVariable("subscription-id") String SubscriptionId) {
	return isubscriptionService.retrieveSubscription(SubscriptionId);
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Subscription addSubscription(@RequestBody Subscription s) {
	Subscription subscription = isubscriptionService.addSubscription(s);
	return subscription;
	}
	
	@PutMapping("/update")
	@ResponseBody
	public Subscription updateSubscription(@RequestBody Subscription s) {
	Subscription subscription = isubscriptionService.updateSubscription(s);
	return subscription;
	}
	
	@DeleteMapping("/delete-subscription/{subscription-id}")
	@ResponseBody
	public void deleteSubscription(@PathVariable("subscription-id") String SubscriptionId) {
	isubscriptionService.deleteSubscriptionById(SubscriptionId);
	}
	
	@GetMapping("/checkInsurance/{subscription-id}")
	@ResponseBody
	public String checkInsurance(@PathVariable("subscription-id") String SubscriptionId) {
	if (isubscriptionService.checkifPro(SubscriptionId)){
		return "Thank you for being a Pro Member, you have Insurance provided by our partner GAT ASSURANCES Tunisie www.gat.com.tn";
	}
	else {
		return "You dont have Insurance, please buy a Pro Subscription";
	}
	}
	
	@GetMapping("/checkCamSur/{subscription-id}")
	@ResponseBody
	public String checkCamSur(@PathVariable("subscription-id") String SubscriptionId) {
	if (isubscriptionService.checkifPro(SubscriptionId)){
		return "Thank you for being a Pro Member, you have Camera Surveillance service provided by our partner PSS www.pss.com.tn";
	}
	else {
		return "You dont have Camera Surveillance, please buy a Pro Subscription";
	}
	}
}
