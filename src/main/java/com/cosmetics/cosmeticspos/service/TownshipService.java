package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.TownshipDto;
import com.cosmetics.cosmeticspos.dto.TownshipDto;

public interface TownshipService {

	 List<TownshipDto> getTownship();

		TownshipDto addTownship(TownshipDto dto);

		TownshipDto updateTownship(TownshipDto dto);

		int deleteTownship(int townshipId);

		TownshipDto getTownshipById(int id);


}
