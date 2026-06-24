package com.cosmetics.cosmeticspos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetics.cosmeticspos.dao.CategoryDao;
import com.cosmetics.cosmeticspos.domain.Category;
import com.cosmetics.cosmeticspos.dto.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<CategoryDto> getCategory() {
		return categoryDao.getCategory();
		
	}
	
	@Transactional(readOnly=false)
	@Override
	public int addCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
				Category c = new Category(dto);
				categoryDao.addCategory(c);
				return c.getCategoryId();
	}
	
	@Transactional(readOnly=false)
	@Override
	public int updateCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
		Category  c= new Category(dto);
		categoryDao.updateCategory(c);
		return c.getCategoryId();
		
	}

	@Override
	public int deleteCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
}



