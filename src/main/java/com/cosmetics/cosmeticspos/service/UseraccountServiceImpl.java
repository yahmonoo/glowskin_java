package com.cosmetics.cosmeticspos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetics.cosmeticspos.dao.UseraccountDao;
import com.cosmetics.cosmeticspos.domain.Useraccount;
import com.cosmetics.cosmeticspos.dto.UseraccountDto;

@Service
public class UseraccountServiceImpl  implements UseraccountService{
	
	@Autowired
	UseraccountDao useraccountDao;
	
	@Override
	@Transactional(readOnly=true)
	
	public List<UseraccountDto> getUseraccount(String userType) {
		return useraccountDao.getUseraccount(userType);
		
	}
	@Override
	@Transactional(readOnly=false)

	public UseraccountDto addUseraccount(UseraccountDto dto) {
		// TODO Auto-generated method stub
		Useraccount ua = new Useraccount(dto);
		useraccountDao.addUseraccount(ua);
				return dto;
	}
	@Override
	@Transactional(readOnly=false)
	
	public UseraccountDto updateUseraccount(UseraccountDto dto) {
		// TODO Auto-generated method stub
		Useraccount  ua= new Useraccount(dto);
		useraccountDao.updateUseraccount(ua);
		return dto;
		
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteUseraccount( int useraccountId) {
		// TODO Auto-generated method stub
		useraccountDao.deleteUseraccount(useraccountId);
		return useraccountId;
	}

	

	
	
	

	
	
	

}
