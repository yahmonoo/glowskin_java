package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Category;
import com.cosmetics.cosmeticspos.dto.CategoryDto;

public interface CategoryDao {

	List<Category> getCategory();
	
	 void addCategory(Category c); 

	 void updateCategory(Category c) ;
		
	}


