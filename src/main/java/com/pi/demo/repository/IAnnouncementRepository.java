package com.pi.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pi.demo.model.Announcement;
@Repository
public interface IAnnouncementRepository extends CrudRepository<Announcement, Long> {
	void deleteAll();

	@Query(value="SELECT * FROM announcement where type =:t ", nativeQuery = true)
	List<Announcement> findByType(@Param("t")String type);
	
	@Query(value="SELECT * FROM announcement where title =:title ",nativeQuery = true)
	List<Announcement> findByTitle(@Param("title")String title);
	
	long count();
	
	@Query(value="SELECT count('a') FROM announcement a where a.type =:type",nativeQuery = true)
	long countByType(@Param("type") String type);
	@Query(value="SELECT * FROM announcement a INNER JOIN customer c ON a.customer_id =c.id where c.id=:id",nativeQuery = true)
	List<Announcement> pdf(@Param("id")long id);
}
