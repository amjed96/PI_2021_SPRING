package com.pi.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pi.demo.model.Subscription;
import com.pi.demo.repository.SubscriptionRepository;

@Service
public class SubscriptionService implements ISubscriptionService{
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	public List<Subscription> retrieveAllSubscriptions() {
	List<Subscription> Subscriptions = (List<Subscription>) subscriptionRepository.findAll();
	return Subscriptions;
	}
	
	public Subscription retrieveSubscription(String id) {
		return subscriptionRepository.findById(Long.parseLong(id)).orElse(null);
	}
	
	public Subscription addSubscription(Subscription s) {
		return subscriptionRepository.save(s);
	}
	
	public Subscription updateSubscription(Subscription s) {
		return subscriptionRepository.save(s);
	}
	
	public void deleteSubscriptionById(String id) {
		subscriptionRepository.deleteById(Long.parseLong(id));
	}

}
