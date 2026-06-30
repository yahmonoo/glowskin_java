package com.cosmetics.cosmeticspos.dto;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
//@AllArgsConstructor
public class UseraccountDto {

	public UseraccountDto(int userAccountId, int townshipId, String townshipName, String profileName, String phone,
			String address, String userName, String password, Date date, String userType) {
		
		// TODO Auto-generated constructor stub
		this.userAccountId=userAccountId;
		this.townshipId=townshipId;
		this.townshipName=townshipName;
		this.profileName=profileName;
		this.phone=phone;
		this.address=address;
		this.userName=userName;
		this.password=password;
		this.date=date;
		this.userType=userType;
	}
	private int userAccountId;
	private int townshipId;
	private String townshipName;
	private String profileName;
	private String phone;
	private String address;
	private String userName;
	private String password;
	private Date date;
	private String userType;

}
