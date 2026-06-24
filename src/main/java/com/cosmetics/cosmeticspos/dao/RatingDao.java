package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Rating;
import com.cosmetics.cosmeticspos.dto.RatingDto;

public interface RatingDao {

	List<RatingDto> getRating(String search);

	void addRating(Rating r);

	void updateRating(Rating r);

	void deleteRating(Rating r);

}
