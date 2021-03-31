package com.pi.demo.services;

import java.util.List;

import com.pi.demo.model.Furniture;


public interface IFurnitureService {
	List<Furniture> retrieveAllAnnonces();
	Furniture addFurniture(Furniture f);
	void deleteFurniture(String id);
	Furniture updateFurniture(Furniture f);
	Furniture retrieveFuriture(String id);
	Furniture getFurByType(String title);
	void deleteAuto();
	

}
