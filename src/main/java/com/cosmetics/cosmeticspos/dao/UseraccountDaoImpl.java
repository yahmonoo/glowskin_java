package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Useraccount;
import com.cosmetics.cosmeticspos.dto.UseraccountDto;

@Repository
public class UseraccountDaoImpl  implements UseraccountDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addUseraccount(Useraccount ua) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(ua);
		
	}

	@Override
	public void updateUseraccount(Useraccount ua) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UseraccountDto> getUseraccount() {
		// TODO Auto-generated method stub
		return null;
	}


}
