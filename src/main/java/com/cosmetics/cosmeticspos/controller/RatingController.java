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


import com.cosmetics.cosmeticspos.dto.RatingDto;
import com.cosmetics.cosmeticspos.service.RatingService;

@RestController
@RequestMapping("/api/v1/")
public class RatingController {

	
	@Autowired
	RatingService 	ratingService;
	
	@GetMapping("rating")
	public List<RatingDto> getRating(){
		return ratingService.getRating();
	}
	@PostMapping("rating")
	public int addRating(@RequestBody RatingDto dto){
		
		return ratingService.addRating(dto);
	}
	@PutMapping("rating")
	public int updateRating(@RequestBody RatingDto dto){
		
		return ratingService.updateRating(dto);
	}
	@DeleteMapping("rating")
	public int deleteRating(@RequestBody RatingDto dto){
		
		return ratingService.deleteRating(dto);
	}

}
