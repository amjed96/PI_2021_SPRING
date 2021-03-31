package com.pi.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pi.demo.model.Furniture;
@Repository
public interface IFurnitureRepository extends CrudRepository< Furniture,Long> {
	
	@Query("select f from Furniture f where f.title=:title")
	Furniture getByType(@Param("title") String title);

}
