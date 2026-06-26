package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.UseraccountDto;

public interface UseraccountService {

		UseraccountDto addUseraccount(UseraccountDto dto);

		UseraccountDto updateUseraccount(UseraccountDto dto);



		List<UseraccountDto> getUseraccount(String userType);


		

		int deleteUseraccount(int useraccountId);

		

		


}
