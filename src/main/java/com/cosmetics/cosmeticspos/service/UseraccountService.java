package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.UseraccountDto;

public interface UseraccountService {
	 List<UseraccountDto> getUseraccount();

		int addUseraccount(UseraccountDto dto);

		int updateUseraccount(UseraccountDto dto);

		int deleteUseraccount(UseraccountDto dto);


}
