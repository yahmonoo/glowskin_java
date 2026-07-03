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
	@PutMapping("category/{categoryId}")
	public CategoryDto updateCategory(@PathVariable("categoryId")int categoryId,@RequestBody CategoryDto dto){
		dto.setCategoryId(categoryId);
		categoryService.updateCategory(dto);
		return dto;
	}
	@DeleteMapping("category/{categoryId}")
	public int deleteUsers(
			@PathVariable("categoryId")int categoryId){
		return categoryService.deleteCategory(categoryId);
	}

}
