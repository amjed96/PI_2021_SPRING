package com.pi.demo.services;

import java.util.List;
import java.util.Optional;

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
	
	public Appointment findAppointmentById(long id) {
		
		Optional<Appointment> app = appointmentRepository.findById(id);
		return app.get();
	}
	
	public Appointment add(Appointment app) {
		return appointmentRepository.save(app);
	}
	
	public void deleteById(long id) {
		appointmentRepository.deleteById(id);
	}
	
	public Appointment edit(Appointment app) {
		return appointmentRepository.save(app);
	}

}
