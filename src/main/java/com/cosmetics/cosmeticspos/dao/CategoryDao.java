package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Category;
import com.cosmetics.cosmeticspos.dto.CategoryDto;

public interface CategoryDao {

	

	 void addCategory(Category c); 

    void updateCategory(Category c) ;

	List<CategoryDto> getCategory();
		
	}


