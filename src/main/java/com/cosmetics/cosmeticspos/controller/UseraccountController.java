package com.cosmetics.cosmeticspos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetics.cosmeticspos.dto.UseraccountDto;
import com.cosmetics.cosmeticspos.service.UseraccountService;

@RestController
@RequestMapping("/api/v1/")

public class UseraccountController {
	
	@Autowired
	UseraccountService useraccountService;
	
	@GetMapping("useraccount")
	public List<UseraccountDto> getUseraccount(){
		return useraccountService.getUseraccount();
	}
	@PostMapping("useraccount")
	public int addUseraccount(@RequestBody UseraccountDto dto){
		
		return useraccountService.addUseraccount(dto);
	}
	@PutMapping("useraccount")
	public int updateUseraccount(@RequestBody UseraccountDto dto){
		
		return useraccountService.updateUseraccount(dto);
	}
	@DeleteMapping("useraccount")
	public int deleteUseraccount(@RequestBody UseraccountDto dto){
		
		return useraccountService.deleteUseraccount(dto);
	}

}
