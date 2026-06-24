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
	@Override
	public int deleteRating(int RatingId) {
		// TODO Auto-generated method stub
		Rating r= new Rating();
		r.setRatingId(RatingId);
	    ratingDao.deleteRating(r);
		return RatingId;
	}

	

}