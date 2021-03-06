package com.pi.demo.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pi.demo.model.Appointment;
import com.pi.demo.services.AppointmentService;


@RestController
@RequestMapping("/appointment")
public class AppointmentController implements Serializable {
	
	@Autowired
	AppointmentService appointmentService;
	
	@ResponseBody
	@GetMapping("/test")
	public Appointment test() {
		Appointment app = new Appointment(1,null,"address",true,null,null);
		return app;
	}
	
//	@GetMapping("/all")
//	public List<Appointment> getAllAppointments() {
//		return appointmentService.findAll();
//	}

}
