package com.pi.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.demo.model.Appointment;
import com.pi.demo.repository.IAppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	IAppointmentRepository appointmentRepository;

	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		List<Appointment> list = (List<Appointment>) appointmentRepository.findAll();
		return list;
	}

}
