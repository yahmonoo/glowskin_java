package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.CategoryDto;

public interface CategoryService {

	 List<CategoryDto> getCategory();

	int addCategory(CategoryDto dto);

	int updateCategory(CategoryDto dto);

	int deleteCategory(CategoryDto dto);

	

}
