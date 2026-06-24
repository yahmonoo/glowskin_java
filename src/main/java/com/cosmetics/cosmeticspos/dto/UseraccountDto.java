package com.cosmetics.cosmeticspos.dto;

import java.time.LocalDateTime;

import org.hibernate.usertype.UserType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class UseraccountDto {
	private int userAccountId;
	private int townshipId;
	private String profileName;
	private String phone;
	private String address;
	private String userName;
	private String password;
	private LocalDateTime date;
	private UserType userType;

}
