package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Township;
import com.cosmetics.cosmeticspos.dto.TownshipDto;

public interface TownshipDao {
	 void addTownship(Township township); 

	    void updateTownship(Township township) ;
	    
	    void deleteTownship(int townshipId);
	    Township getTownshipyId(int townshipId);

		List<TownshipDto> getTownship();

		Township getTownshipById(int id);

}
