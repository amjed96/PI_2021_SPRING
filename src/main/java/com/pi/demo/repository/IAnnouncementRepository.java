package com.pi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pi.demo.model.Announcement;
public interface IAnnouncementRepository extends CrudRepository<Announcement, Long> {
	void deleteAll();

	//@Query("SELECT * FROM announcement where type = 'vente'")
	//List<Announcement> findByType(String type);

}
