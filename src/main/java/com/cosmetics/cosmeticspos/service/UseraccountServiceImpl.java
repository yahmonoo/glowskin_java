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
	
	@Transactional(readOnly=true)
	@Override
	public List<UseraccountDto> getUseraccount() {
		return useraccountDao.getUseraccount();
		
	}
	
	@Transactional(readOnly=false)
	@Override
	public int addUseraccount(UseraccountDto dto) {
		// TODO Auto-generated method stub
		Useraccount ua = new Useraccount(dto);
		useraccountDao.addUseraccount(ua);
				return ua.getUseraccountId();
	}
	
	@Transactional(readOnly=false)
	@Override
	public int updateUseraccount(UseraccountDto dto) {
		// TODO Auto-generated method stub
		Useraccount  ua= new Useraccount(dto);
		useraccountDao.updateUseraccount(ua);
		return ua.getUseraccountId();
		
	}

	@Override
	public int deleteUseraccount(UseraccountDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	

}
