package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.dto.CityDto;

public interface CityDao {

	List<City> getCity();

	void addCity(City c);

	void updateCity(City c);

	void deleteCity(City c);

	

}
