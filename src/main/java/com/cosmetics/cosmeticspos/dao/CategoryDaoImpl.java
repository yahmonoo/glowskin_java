package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Category;
import com.cosmetics.cosmeticspos.dto.CategoryDto;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCategory(Category c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
		
	}

	@Override
	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryDto> getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
