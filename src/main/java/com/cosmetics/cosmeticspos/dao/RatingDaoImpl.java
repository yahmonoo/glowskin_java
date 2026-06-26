package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Rating;
import com.cosmetics.cosmeticspos.dto.RatingDto;

@Repository
public class RatingDaoImpl implements RatingDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<RatingDto> getRating(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRating(Rating r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRating(Rating r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRating(Rating r) {
		// TODO Auto-generated method stub
		
	}

}
