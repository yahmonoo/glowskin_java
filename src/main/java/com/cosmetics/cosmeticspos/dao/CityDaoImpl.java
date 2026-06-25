package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.dto.CityDto;

@Repository
public class CityDaoImpl implements CityDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCity(City ct) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(ct);
	}

	@Override
	public void updateCity(City ct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCity(City ct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CityDto> getCity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
