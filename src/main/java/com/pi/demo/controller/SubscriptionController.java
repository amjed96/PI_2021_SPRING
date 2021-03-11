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
@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	ISubscriptionService isubscriptionService;
	
	@GetMapping("/retrieve-all-subscriptions")
	@ResponseBody
	public List<Subscription> getSubscription() {
	List<Subscription> list = isubscriptionService.retrieveAllSubscriptions();
	return list;
	}
	
	@GetMapping("/retrieve-subscription/{subscription-id}")
	@ResponseBody
	public Subscription retrieveSubscription(@PathVariable("subscription-id") String SubscriptionId) {
	return isubscriptionService.retrieveSubscription(SubscriptionId);
	}
	
	@PostMapping("/add-subscription")
	@ResponseBody
	public Subscription addSubscription(@RequestBody Subscription s) {
	Subscription subscription = isubscriptionService.addSubscription(s);
	return subscription;
	}
	
	@PutMapping("/update-subscription")
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
}
