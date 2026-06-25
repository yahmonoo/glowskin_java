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

import com.cosmetics.cosmeticspos.dto.CategoryDto;
import com.cosmetics.cosmeticspos.dto.TownshipDto;
import com.cosmetics.cosmeticspos.service.CategoryService;
import com.cosmetics.cosmeticspos.service.TownshipService;

@RestController
@RequestMapping("/api/v1/")
public class TownshipController {
	
	@Autowired
	TownshipService townshipService;
	
	@GetMapping("township")
	public List<TownshipDto> getTownship(){
		return townshipService.getTownship();
	}
	@PostMapping("township")
	public int addTownship(@RequestBody TownshipDto dto){
		
		return townshipService.addTownship(dto);
	}
	@PutMapping("township")
	public int updateTownship(@RequestBody TownshipDto dto){
		
		return townshipService.updateTownship(dto);
	}
	@DeleteMapping("township")
	public int deleteCategory(@RequestBody TownshipDto dto){
		
		return townshipService.deleteTownship(dto);
	}
}
