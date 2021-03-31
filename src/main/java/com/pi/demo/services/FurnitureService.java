package com.pi.demo.services;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.pi.demo.model.Furniture;
import com.pi.demo.repository.IFurnitureRepository;


@Service
public class FurnitureService implements IFurnitureService {

	@Autowired
	
	IFurnitureRepository FurnitureRepository;
	

	private static final Logger L = LogManager.getLogger(FurnitureService.class);



	public Furniture addFurniture(Furniture f) {
		return FurnitureRepository.save(f);

	}

	public Furniture updateFurniture(Furniture f) {
		return FurnitureRepository.save(f);

	}

	public void deleteFurniture(String id) {
		FurnitureRepository.deleteById(Long.parseLong(id));

	}


	@Override
	public List<Furniture> retrieveAllAnnonces() {
		
		List<Furniture> Fornitures = (List<Furniture>) FurnitureRepository.findAll();
		for (Furniture Furniture : Fornitures) {
			L.info("furniture +++ : " + Furniture);
		}
		return Fornitures;
	}

	@Override
	public Furniture retrieveFuriture(String id) {
		Furniture f;
		f = FurnitureRepository.findById(Long.parseLong(id)).orElse(null);
		return f;
	
	}

	@Override
	public Furniture getFurByType(String title) {
	
		return FurnitureRepository.getByType(title);
	}
	@Scheduled(cron = "*/10 * * * * *")
	@Override
	public void deleteAuto() {

		for (Furniture p : FurnitureRepository.findAll()) {
			Date now = new Date();
			if (new Date(p.getDate().getYear(), p.getDate().getMonth(), p.getDate().getDate())
					.before(new Date(now.getYear(), now.getMonth() - 1, now.getDate()))) {
				FurnitureRepository.deleteById(p.getId());
			}
		}
	}


	

}
