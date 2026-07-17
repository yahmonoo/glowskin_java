package com.cosmetics.cosmeticspos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetics.cosmeticspos.dao.UseraccountDao;
import com.cosmetics.cosmeticspos.domain.Category;
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
		dto.setUserAccountId(ua.getUseraccountId());
				return dto;
	}
	@Override
	@Transactional(readOnly=false)
	
	public int updateUseraccount(UseraccountDto dto) {
		// TODO Auto-generated method stub
		Useraccount  ua= new Useraccount(dto);
		useraccountDao.updateUseraccount(ua);
		return ua.getUseraccountId();
		
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteUseraccount( int useraccountId) {
		// TODO Auto-generated method stub
		useraccountDao.deleteUseraccount(useraccountId);
		return useraccountId;
	}
	
	@Transactional(readOnly=true)
	@Override
	public UseraccountDto getLogin(String userName, String password) {
		// TODO Auto-generated method stub
		Useraccount ua = useraccountDao.getLogin(userName,password);
		
		return new UseraccountDto(ua);
	}	
	@Transactional(readOnly=false)
	@Override
	public int updateProductPhoto(int userAccountId, MultipartFile file) {
		// TODO Auto-generated method stub
		return useraccountDao.updateProductPhoto(userAccountId,file);
	}
	@Transactional(readOnly=true)
	@Override
	public UseraccountDto getUseraccountById(int userAccountId) {
		// TODO Auto-generated method stub
		return useraccountDao.getUseraccountById(userAccountId);
	}

	

	
	
	

	
	
	

}
