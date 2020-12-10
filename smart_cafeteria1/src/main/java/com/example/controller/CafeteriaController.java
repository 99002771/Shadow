package com.example.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CafeteriaRepository;
import com.example.model.Cafeteria;
import com.example.service.CafeteriaService;

@RestController
public class CafeteriaController {

	
	@Autowired
	private CafeteriaService cafeteriaService;
	
	@Autowired
	private CafeteriaRepository repos;
	
	public void setUserService(CafeteriaService cafeteriaService) {
		this.cafeteriaService = cafeteriaService;
	}
	
	
	@PostMapping("/save")
	public Cafeteria save(@RequestBody Cafeteria user){
	
		return cafeteriaService.save(user);
	}
	
	@GetMapping("/all")
	public List<Cafeteria> getAllUsers() {
		return cafeteriaService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Cafeteria getDetails(@PathVariable(value="id")long id) {
		return cafeteriaService.getDetails(id);
	}
	
	
	
	
	
	@GetMapping("/datetimeDining/{dt}")
	public List<Cafeteria> getDiffTimeCountByDiningArea(@PathVariable(value="dt")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date dt) throws ParseException {
		return repos.getDiffTimeCountByDiningArea(dt);
	}
	
	@GetMapping("/datetime/{spacetype}/{dt}")
	public List<Cafeteria> getDiffTimeCountByServiceArea(
			@PathVariable(value="dt")@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date dt,
			@PathVariable(value="spacetype")String spacetype) throws ParseException {
		return repos.getDiffTimeCountByServiceArea(dt,spacetype);
	}
	
	/*
	@GetMapping("/peoplecount/{spacetype}")
	public List<Cafeteria> getCount(@PathVariable(value="spacetype")String spacetype) {
		return cafeteriaService.getCount(spacetype);
	}*/
	
	@GetMapping("/getallbydatetimebetween")
    public List<Cafeteria> getAllByDatetimeBetween(
        @RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startdate,
        @RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date enddate) {
      return repos.findAllByDatetimeBetween(startdate, enddate);
    }
	
	@GetMapping("/findPeopleCountForDateRange")
    public List<Cafeteria> getfindPeopleCountForDateRange(
        @RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startdate,
        @RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date enddate) {
      return repos.findPeopleCountForDateRange(startdate, enddate);
    }
	
	@GetMapping("/getCountbyService/{currentDate}")
    public List<Cafeteria> getCountByService(
    		@PathVariable("currentDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date datetime){
    		return repos.getCountByServiceArea(datetime);
        
    }
	@GetMapping("/getCountbyDining/{currentDate}")
    public List<Cafeteria> getCountByDining(
    		@PathVariable("currentDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date datetime){
    		return repos.getCountByDiningArea(datetime);
        
    }
	
	/*@GetMapping("/time/{time}")
	public List<Cafeteria> getTimeForDate(@PathVariable(value="datetime")Date spacetype) {
		return cafeteriaService.getTimeForDate(spacetype);
	}*/
	
	
	
	
}
