package com.cosmetics.cosmeticspos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cosmetics.cosmeticspos.dao.CityDao;
import com.cosmetics.cosmeticspos.domain.Category;
import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.domain.Product;
import com.cosmetics.cosmeticspos.dto.CategoryDto;
import com.cosmetics.cosmeticspos.dto.CityDto;


@Service
public class CityServiceImpl implements CityService{
	@Autowired
	CityDao cityDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<CityDto> getCity() {
		// TODO Auto-generated method stub
		List<City> cityList =  cityDao.getCity();
		List<CityDto> dtoList = new ArrayList<>();
		for(City c:cityList) {
			CityDto dto = new CityDto(c);
			dtoList.add(dto);
		}	
		return dtoList;
		
	}
	@Transactional(readOnly=false)
	@Override
	public int addCity(CityDto dto) {
		// TODO Auto-generated method stub
				City c = new City(dto);
				cityDao.addCity(c);
				return c.getCityId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateCity(CityDto dto) {
		// TODO Auto-generated method stub
		City  c= new City(dto);
		cityDao.updateCity(c);
		return c.getCityId();
		
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteCity(int cityId) {
		// TODO Auto-generated method stub
		City c = new City();
		c.setCityId(cityId);
		c.setCityName("");
		cityDao.deleteCity(c);
		return cityId;
	}

	
	}
