package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.RatingDto;

public interface RatingService {

	List<RatingDto> getRating();

	int addRating(RatingDto dto);

	int updateRating(RatingDto dto);

	int deleteRating(RatingDto dto);

	List<RatingDto> getRating(String search);

	int deleteRating(int RatingId);

}
