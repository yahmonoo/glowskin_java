package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.CityDto;

public interface CityService {

	List<CityDto> getCity();

	int addCity(CityDto dto);

	int updateCity(CityDto dto);

	int deleteCity(CityDto dto);

	int deleteCity(int cityId);

}
