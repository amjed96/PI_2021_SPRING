package com.pi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pi.demo.model.Announcement;
public interface IAnnouncementRepository extends CrudRepository<Announcement, Long> {
	void deleteAll();

	@Query(value="SELECT * FROM announcement where type =:type",nativeQuery = true)
	//List<Announcement> findByType(String type);
	List<Announcement> findByType(@Param("type")String type);
	long count();
	@Query(value="SELECT count('a') FROM announcement a where a.type =:type",nativeQuery = true)
	long countByType(@Param("type") String type);

}
