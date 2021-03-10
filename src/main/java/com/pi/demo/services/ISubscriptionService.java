package com.pi.demo.services;

import java.util.List;
import com.pi.demo.model.Subscription;
public interface ISubscriptionService {

	List<Subscription> retrieveAllSubscriptions();
	Subscription retrieveSubscription(String id);
	Subscription addSubscription(Subscription s);
	Subscription updateSubscription(Subscription s);
	void deleteSubscriptionById(String id);
	
}
