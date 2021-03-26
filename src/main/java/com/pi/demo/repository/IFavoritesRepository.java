package com.pi.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pi.demo.model.Favorites;

@Repository
public interface IFavoritesRepository extends CrudRepository <Favorites, Long> {

}
