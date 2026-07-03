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
		session.createQuery("UPDATE Category SET name = :name WHERE categoryId = :categoryId")
        .setParameter("name", cat.getName())
        .setParameter("categoryId", cat.getCategoryId())
        .executeUpdate();
	}
	
	
	@Override
	public void deleteCategory(Category cat) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		 session.createQuery("DELETE FROM Category WHERE categoryId= :categoryId")
			.setParameter("categoryId",cat.getCategoryId())
			.executeUpdate();	
	}

	@Override
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(" select cat from Category cat order by cat.name ", Category.class)
				.getResultList();
		
	}
}
