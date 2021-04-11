package com.pi.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pi.demo.model.Appointment;

@Repository
public interface IAppointmentRepository extends CrudRepository<Appointment, Long> {
	
}
