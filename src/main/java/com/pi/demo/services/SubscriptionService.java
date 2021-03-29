package com.pi.demo.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.pi.demo.model.Subscription;
import com.pi.demo.model.SubType;
import com.pi.demo.repository.SubscriptionRepository;

@Service
public class SubscriptionService implements ISubscriptionService{
	
	private static final Logger log = LoggerFactory.getLogger(SubscriptionService.class);
	
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
	
	@Scheduled(fixedRate = 100000)
	public void resolveSubExpirationDate() {
		List<Subscription> SubList = (List<Subscription>) subscriptionRepository.findAll();
		//for (Subscription sub : Sublist) {
		//	if(sub.)
		//}
		Date TodaysDate=new Date();
		SubList.forEach(s -> {
			if(s.getSubType()==SubType.PRO){
				if(TodaysDate.compareTo(s.getEndDate())>0) {
					s.setEndDate(null);
					s.setStartDate(null);
					s.setSubType(SubType.FREE);
					subscriptionRepository.save(s);
					log.info("Sub Expired And Changed To FREE");
				}
			}
		});
	}
	
}