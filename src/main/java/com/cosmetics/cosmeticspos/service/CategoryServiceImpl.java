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
	private int categoryId;
	
	@Transactional(readOnly=true)
	@Override
	public List<CategoryDto> getCategory() {
		// TODO Auto-generated method stub
		List<Category> categoryList =  categoryDao.getCategory();
		List<CategoryDto> dtoList = new ArrayList<>();
		for(Category cat:categoryList) {
			CategoryDto dto = new CategoryDto(cat);
			dtoList.add(dto);
		}	
		return dtoList;
		
	}
	
	@Transactional(readOnly=false)
	@Override
	public int addCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
				Category cat = new Category(dto);
				categoryDao.addCategory(cat);
				return cat.getCategoryId();
	}
	
	@Transactional(readOnly=false)
	@Override
	public int updateCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
		Category  cat= new Category(dto);
		categoryDao.updateCategory(cat);
		return cat.getCategoryId();
		
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteCategory(CategoryDto dto) {
		// TODO Auto-generated method stub
		Category cat=new Category(dto);
		cat.setCategoryId(categoryId);
		categoryDao.deleteCategory(cat);
		return categoryId;
	}
	
}



