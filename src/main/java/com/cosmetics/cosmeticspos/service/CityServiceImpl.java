package com.cosmetics.cosmeticspos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetics.cosmeticspos.dao.CategoryDao;
import com.cosmetics.cosmeticspos.dao.CityDao;
import com.cosmetics.cosmeticspos.domain.Category;
import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.dto.CityDto;


@Service
public class CityServiceImpl implements CityService{

	@Autowired
	CityDao cityDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<CityDto> getCity() {
		
		return cityDao.getCity();
	}

	@Transactional(readOnly=true)
	@Override
	public int addCity(CityDto dto) {
		City ct = new City(dto);
		cityDao.addCity(ct);
		return ct.getCityId();
	}

	@Override
	public int updateCity(CityDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCity(CityDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCity(int cityId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
