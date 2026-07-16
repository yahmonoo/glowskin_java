package com.cosmetics.cosmeticspos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetics.cosmeticspos.dto.UseraccountDto;
import com.cosmetics.cosmeticspos.service.UseraccountService;

@RestController
@RequestMapping("/api/v1/")

public class UseraccountController {
	
	@Autowired
	UseraccountService useraccountService;
	
	@GetMapping("useraccount")
	public List<UseraccountDto> getUseraccount(@RequestParam("userType") String userType){
		return useraccountService.getUseraccount(userType);
	}
	@PostMapping("useraccount")
	public UseraccountDto addUseraccount(@RequestBody UseraccountDto dto){
		
		return useraccountService.addUseraccount(dto);
	}
	@PutMapping("useraccount/{useraccountId}")
	public UseraccountDto updateUseraccount(@PathVariable("useraccountId") int useraccountId,@RequestBody UseraccountDto dto){
		
		return useraccountService.updateUseraccount(dto);
	}
	@DeleteMapping("useraccount/{useraccountId}")
	public int deleteuseraccount(@PathVariable("useraccountId") int useraccountId){
		
		return useraccountService.deleteUseraccount(useraccountId);
	}
	@GetMapping("useraccount/login")
	public UseraccountDto getLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password){
		return useraccountService.getLogin(userName,password);
	}
	 @PutMapping("userAccount/{userAccountId}/photo")
		public int updateProductPhoto(@PathVariable("userAccountId")int userAccountId,
				@RequestParam(value = "file",required=false) MultipartFile file) {
			try {
				return useraccountService.updateProductPhoto(userAccountId,file);
				}catch (Exception e) {
					// TODO: handle exception
					throw new RuntimeException("Update,Product Photo Error!", e);
				}
		}
	 @GetMapping("useraccount/{userAccountId}")
		public UseraccountDto getUseraccountById(@PathVariable("userAccountId")int userAccountId){
			return useraccountService.getUseraccountById(userAccountId);
		}
}
