package com.cosmetics.cosmeticspos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetics.cosmeticspos.dto.CityDto;
import com.cosmetics.cosmeticspos.service.CityService;

@RestController
@RequestMapping("/api/v1/")
public class CityController {

	@Autowired
	CityService cityService;
	
	@GetMapping("city")
	public List<CityDto> getCity(){
		return cityService.getCity();
	}
	@PostMapping("city")
	public int addCity(@RequestBody CityDto dto){
		
		return cityService.addCity(dto);
	}
	@PutMapping("city")
	public int updateCity(@RequestBody CityDto dto){
		
		return cityService.updateCity(dto);
	}
	@DeleteMapping("city")
	public int deleteCity(@RequestBody CityDto dto){
		
		return cityService.deleteCity(dto);
	}
}
