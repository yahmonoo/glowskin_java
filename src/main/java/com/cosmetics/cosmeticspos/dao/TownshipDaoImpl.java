package com.cosmetics.cosmeticspos.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Township;
import com.cosmetics.cosmeticspos.dto.TownshipDto;

@Repository
public class TownshipDaoImpl implements TownshipDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addTownship(Township township) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(township);
		
	}

	@Override
	public void updateTownship(Township township) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(township);
		
	}


	@Override
	public void deleteTownship(int townshipId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.createNativeQuery("DELETE FROM township WHERE townshipid= :townshipId").setParameter(townshipId, townshipId).executeUpdate();

		
	}

	@Override
	public Township getTownshipyId(int townshipId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();

		return session.find(Township.class,townshipId) ;
	}
	@Override
	public List<TownshipDto> getTownship() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String sqlData="SELECT t.townshipid,t.townshipname,t.cityid FROM township t ORDER BY t.townshipname ASC";
		List<Object[]> objectList=session.createNativeQuery(sqlData).getResultList();
		List<TownshipDto> townshipDtoList=new ArrayList<TownshipDto>();
		for(Object[] object: objectList) {
			int townshipId=Interger.parseInt(object[0].toString());
			String townshipName=object[1].toString();
			int cityId=Interger.parseInt(object[2].toString());
			TownshipDto dto =new TownshipDto(townshipId,cityId,townshipName);
			townshipDtoList.add(dto);
		}

		return townshipDtoList;
	}

}
