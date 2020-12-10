package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CafeteriaRepository;
import com.example.model.Cafeteria;

@Service
public class CafeteriaService {
	
	@Autowired
	private CafeteriaRepository cafeteriaRepository;
	
	public void setUserReposatory(CafeteriaRepository cafeteriaRepository) {
		this.cafeteriaRepository = cafeteriaRepository;
	}

	public Cafeteria save(Cafeteria cafeteria){
		 return cafeteriaRepository.save(cafeteria);
	}
	
	public List<Cafeteria> getAllUsers() {
		return cafeteriaRepository.getAllUsers();
	}
	
	public Cafeteria getDetails(long id) {
		return cafeteriaRepository.getDetails(id);
	}
	
	
	
	
	/*public List<Cafeteria> getBySpaceType(String spacetype) {
		return cafeteriaRepository.getBySpaceType(spacetype);
	}*/
	
/*	public List<Cafeteria> getCount(String spacetype){
		return cafeteriaRepository.getCount(spacetype);
	}*/
	

	/*public List<Cafeteria> getTimeForDate(Date datetime) {
		
		return cafeteriaRepository.getTimeForDate(datetime);
	}*/

}
