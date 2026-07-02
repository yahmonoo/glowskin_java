package com.cosmetics.cosmeticspos.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Category;
import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.dto.CategoryDto;


@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCategory(Category cat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(cat);
		
	}

	@Override
	public void updateCategory(Category cat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(cat);
	}
	
	
	@Override
	public void deleteCategory(Category cat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		 session.createQuery("DELETE FROM category WHERE categoryId= :categoryId")
			.setParameter("categoryId",cat.getCategoryId()).
			executeUpdate();	
	}

	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery(" select cat from Category cat order by cat.name ").getResultList();
		return categoryList;
	

//
//	@Override
//	public List<Category> getCategory(String type ) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		List<Category> objList=  session.createQuery("SELECT cat.categoryId,cat.name FROM Category cat WHERE cat.type = :Type", Category.class)
//	            .setParameter("Type", type)
//	            .getResultList();
//		
	
//		List<CategoryDto> dtoList = new ArrayList<>();
//
//		for(Object[] obj:objList) {
//			
//			int categoryId = (int)obj[0];
//			String name = (String)obj[1];
//			CategoryDto dto = new CategoryDto(categoryId, name);
//			dtoList.add(dto);
//		}
		
		
//		return objList;
	}
	

}
