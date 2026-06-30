package com.cosmetics.cosmeticspos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cosmetics.cosmeticspos.dao.CityDao;
import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.domain.Product;
import com.cosmetics.cosmeticspos.dto.CityDto;


@Service
public class CityServiceImpl implements CityService{
	@Autowired
	CityDao cityDao;

	@Transactional(readOnly=true)
	@Override
	public List<CityDto> getCity(String search) {
		return null;//cityDao.getCity(search);
	}

	@Transactional(readOnly=false)
	@Override
	public int addCity(CityDto dto) {
		City ct = new City(dto);
		cityDao.addCity(ct);
		return ct.getCityId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateCity(CityDto dto) {
		City ct = new City(dto);
        cityDao.updateCity(ct);
		return ct.getCityId();
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteCity(int CityId) {
	    CityDto dto = new CityDto();
	    dto.setCityId(CityId); 
	    
	    City ct = new City(dto); 
	    
	    cityDao.deleteCity(ct);
	    return CityId;
	}

	@Transactional(readOnly=true)
	@Override
	public List<CityDto> getCity() {
		// TODO Auto-generated method stub
		List<City> cityList = cityDao.getCity();
		List<CityDto> dtoList = new ArrayList<>();
		for(City c:cityList) {
			CityDto dto = new CityDto(c);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public int deleteCity(CityDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}


	}
