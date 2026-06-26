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
	@PutMapping("useraccount")
	public UseraccountDto updateUseraccount(@RequestBody UseraccountDto dto){
		
		return useraccountService.updateUseraccount(dto);
	}
	@DeleteMapping("useraccount/{useraccountId}")
	public int deleteuseraccount(@PathVariable("useraccountId") int useraccountId){
		
		return useraccountService.deleteUseraccount(useraccountId);
	}

}
