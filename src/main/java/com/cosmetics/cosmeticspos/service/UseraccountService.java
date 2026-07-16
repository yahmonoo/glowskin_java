package com.cosmetics.cosmeticspos.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cosmetics.cosmeticspos.dto.UseraccountDto;

public interface UseraccountService {

		UseraccountDto addUseraccount(UseraccountDto dto);

		UseraccountDto updateUseraccount(UseraccountDto dto);



		List<UseraccountDto> getUseraccount(String userType);


		

		int deleteUseraccount(int useraccountId);

		UseraccountDto getLogin(String userName, String password);

		int updateProductPhoto(int userAccountId, MultipartFile file);

		UseraccountDto getUseraccountById(int userAccountId);

		

		


}
