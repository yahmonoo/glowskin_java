package com.cosmetics.cosmeticspos.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Category;
import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.dto.CityDto;

@Repository
public class CityDaoImpl implements CityDao {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<City> getCity() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(" select c from City c order by c.cityName " ,City.class).getResultList();
		
	}

	@Override
	public void addCity(City c) {
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
		
	}

	@Override
	public void updateCity(City c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("UPDATE City SET cityName = :cityName WHERE cityId = :cityId")
        .setParameter("cityName", c.getCityName())
        .setParameter("cityId", c.getCityId())
        .executeUpdate();
	}
	

	@Override
	public void deleteCity(City c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		 session.createQuery("DELETE FROM City WHERE cityId= :cityId")
			.setParameter("cityId",c.getCityId())
			.executeUpdate();	

}
}