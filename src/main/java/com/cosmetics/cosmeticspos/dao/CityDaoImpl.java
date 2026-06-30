package com.cosmetics.cosmeticspos.dao;

import java.util.ArrayList;
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

//	@Override
//	public List<CityDto> getCity(String search) {
//	    Session session = sessionFactory.getCurrentSession();
//	    
//	    List<Object[]> objList = session.createQuery(
//	            "SELECT c.cityId, c.cityName FROM City c WHERE c.cityName LIKE :search", Object[].class)
//	            .setParameter("search", "%" + search + "%") 
//	            .getResultList();
//	    
//	    List<CityDto> dtoList = new ArrayList<>();
//	    for(Object[] obj : objList) {
//	        
//	        int cityId = ((Number) obj[0]).intValue(); 
//	        String name = (String) obj[1];
//	        
//	        CityDto dto = new CityDto(cityId, name);
//	        dtoList.add(dto);
//	    }
//	    
//	    
//	    return dtoList;
//	}

	
	@Override
	public List<City> getCity() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<City> cityList = session.createQuery(" select c from City c order by c.cityName ASC ").getResultList();
		return cityList;
	}

	@Override
	public void addCity(City ct) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ct);
		
	}

	@Override
	public void updateCity(City ct) {
		Session session = sessionFactory.getCurrentSession();
		session.update(ct);
		
	}

	@Override
	public void deleteCity(City ct) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(ct);
	}

}
