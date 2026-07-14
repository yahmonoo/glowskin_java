package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cosmetics.cosmeticspos.domain.Useraccount;
import com.cosmetics.cosmeticspos.dto.UseraccountDto;

public interface UseraccountDao {
	 void addUseraccount(Useraccount ua); 

	    void updateUseraccount(Useraccount ua) ;

		List<UseraccountDto> getUseraccount(String userType);

		void deleteUseraccount(int userAccountId);

		Useraccount getLogin(String userName, String password);

		int updateProductPhoto(int userAccountId, MultipartFile file);


}
