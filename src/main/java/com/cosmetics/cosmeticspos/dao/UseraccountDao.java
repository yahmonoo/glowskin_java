package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Useraccount;
import com.cosmetics.cosmeticspos.dto.UseraccountDto;

public interface UseraccountDao {
	 void addUseraccount(Useraccount ua); 

	    void updateUseraccount(Useraccount ua) ;

		List<UseraccountDto> getUseraccount(String userType);

		void deleteUseraccount(int userAccountId);


}
