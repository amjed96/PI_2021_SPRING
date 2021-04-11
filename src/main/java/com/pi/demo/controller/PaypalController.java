package com.pi.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pi.demo.services.PaypalService;
import com.pi.demo.services.SubscriptionService;
import com.pi.demo.utils.URLUtils;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@RestController
@RequestMapping("/api/paypal")
public class PaypalController {

	public static final String PAYPAL_SUCCESS_URL = "pay/success";
	public static final String PAYPAL_CANCEL_URL = "pay/cancel";
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PaypalService paypalService;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@PostMapping("/pay/{subscription-id}")
	@ResponseBody
	public String pay(HttpServletRequest request, @PathVariable("subscription-id") String SubscriptionId){
		String cancelUrl = URLUtils.getBaseURl(request) + "/api/paypal/" + PAYPAL_CANCEL_URL;
		String successUrl = URLUtils.getBaseURl(request) + "/api/paypal/" + PAYPAL_SUCCESS_URL;
		try {
			Payment payment = paypalService.createPayment(
					21.00, 
					"USD", 
					"paypal", 
					"sale",
					"PRO Subscription to DARI app ", 
					cancelUrl, 
					successUrl);
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
					subscriptionService.setToPro(SubscriptionId);
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/";
	}

	@GetMapping(PAYPAL_CANCEL_URL)
	@ResponseBody
	public String cancelPay(){
		return "PaymentCancelled";
	}

	@GetMapping(PAYPAL_SUCCESS_URL)
	@ResponseBody
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if(payment.getState().equals("approved")){
				return "PaymentSuccessful";
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/";
	}
}
