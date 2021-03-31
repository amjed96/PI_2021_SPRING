package com.pi.demo.controller;

import com.pi.demo.model.Furniture;
import com.pi.demo.services.FurnitureService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FurnitureController {

	@Autowired
	FurnitureService furnitureService;

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-Furitures
	@GetMapping("/retrieve-all-furnitures")
	@ResponseBody
	public List<Furniture> getFurnitures() {
//		List<Furniture> list = furnitureService.retrieveAllFurnitures();
		return furnitureService.retrieveAllAnnonces();//list;
	}
	@GetMapping("/retrieve-furByType/{title}")
	@ResponseBody
	public Furniture getFurByType(@PathVariable ("title") String title) {
		return furnitureService.getFurByType(title);//list;
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-furniture/{furniture-id}
	@GetMapping("/retrieve-Furniture/{furniture-id}")
	@ResponseBody
	public Furniture retrieveFurniture(@PathVariable("furniture-id") String id) {
		return furnitureService.retrieveFuriture(id);
	}

	// Add furniture : http://localhost:8081/SpringMVC/servlet/add-furniture
	@PostMapping("/add-furniture")
	@ResponseBody
	public Furniture addUser(@RequestBody Furniture f) {
		Furniture furniture = furnitureService.addFurniture(f);
		return furniture;
	}
	
	//http://localhost:8081/SpringMVC/servlet/remove-furniture/{furniture-id}
	@DeleteMapping("/remove-Furniture/{furniture-id}")
	 @ResponseBody
	 public void removeFurniture(@PathVariable("furniture-id") String furnitureId) {
		 furnitureService.deleteFurniture(furnitureId);
	 
}
	// http://localhost:8081/SpringMVC/servlet/modify-furniture
	 @PutMapping("/modify-furniture")
	 @ResponseBody
	 public Furniture modifyUser(@RequestBody Furniture furniture){
	 return furnitureService.updateFurniture(furniture);
	 }
	
}



