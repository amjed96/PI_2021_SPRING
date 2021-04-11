package com.pi.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.pi.demo.model.Commande;

public interface iCommandeRepository extends CrudRepository<Commande, Integer> {

}
