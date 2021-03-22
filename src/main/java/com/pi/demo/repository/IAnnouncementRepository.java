package com.pi.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.pi.demo.model.Announcement;
public interface IAnnouncementRepository extends CrudRepository<Announcement, Long> {

}
