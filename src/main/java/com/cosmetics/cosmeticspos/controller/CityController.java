package com.cosmetics.cosmeticspos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetics.cosmeticspos.dto.CategoryDto;
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
	@PutMapping("city/{cityId}")
	public CityDto updateCity(@PathVariable("cityId")int cityId,@RequestBody CityDto dto){
		dto.setCityId(cityId);
		cityService.updateCity(dto);
		return dto;
	}
	@DeleteMapping("city/{cityId}")
	public int deleteUsers(
			@PathVariable("cityId")int cityId){
		return cityService.deleteCity(cityId);
	}

}
