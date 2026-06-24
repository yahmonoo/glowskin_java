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
import com.cosmetics.cosmeticspos.service.CategoryService;

@RestController
@RequestMapping("/api/v1/")

public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("category")
	public List<CategoryDto> getCategory(){
		return categoryService.getCategory();
	}
	@PostMapping("category")
	public int addCategory(@RequestBody CategoryDto dto){
		
		return categoryService.addCategory(dto);
	}
	@PutMapping("category")
	public int updateCategory(@RequestBody CategoryDto dto){
		
		return categoryService.updateCategory(dto);
	}
	@DeleteMapping("category")
	public int deleteCategory(@RequestBody CategoryDto dto){
		
		return categoryService.deleteCategory(dto);
	}

}
