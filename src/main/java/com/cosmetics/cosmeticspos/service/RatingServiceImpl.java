package com.cosmetics.cosmeticspos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cosmetics.cosmeticspos.dao.RatingDao;
import com.cosmetics.cosmeticspos.domain.Rating;
import com.cosmetics.cosmeticspos.dto.RatingDto;


@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	RatingDao ratingDao;
	@Transactional(readOnly=true)
	@Override
	public List<RatingDto> getRating(String search) {
		// TODO Auto-generated method stub
	//	List<RatingDto> ratingList = ratingDao.getRating(search);//
//		 List<RatingDto> dtoList = new ArrayList();//
//		for(Rating rating:ratingList) {
//			RatingDto dto = new RatingDto(rating);//
//			dtoList.add(dto);
//		}
		return ratingDao.getRating(search);//;
	}

	@Transactional(readOnly=false)
	@Override
	public int addRating(RatingDto dto) {
		// TODO Auto-generated method stub
		Rating r = new Rating();//
		ratingDao.addRating(r);
		
		return r.getRatingId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateRating(RatingDto dto) {
		// TODO Auto-generated method stub
		Rating r= new Rating();
		ratingDao.updateRating(r);
		return r.getRatingId();
	}

	
	@Transactional(readOnly=false)
	
	public int deleteRating(int ratingId) {
		Rating r= new Rating();
		r.setRatingId(ratingId);
		ratingDao.deleteRating(r);
		return ratingId;
	}

	@Override
	public int deleteRating(RatingDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RatingDto> getRating() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}