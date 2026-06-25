package com.cosmetics.cosmeticspos.domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cosmetics.cosmeticspos.dto.UseraccountDto;

import lombok.Data;

@Entity
@Table(name = "useraccount")
public class Useraccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userAccountId;
	private int townshipId;
	private String profileName;
	private String phone;
	private String address;
	private String userName;
	private String password;
	private LocalDateTime date;
	private UserType userType;

	public Useraccount(UseraccountDto dto) {
		// TODO Auto-generated constructor stub
		this.userAccountId = dto.getUserAccountId();
		this.townshipId=dto.getTownshipId();
		this.profileName=dto.getProfileName();
		this.phone=dto.getPhone();
		this.address=dto.getAddress();
		this.userName=dto.getUserName();
		this.password=dto.getPassword();
		this.date=dto.getDate();
		this.userType=dto.getUserType();
	}

	public int getUseraccountId() {
		return userAccountId;
	}

	public void setUserAccountId(int userAccountId) {
		this.userAccountId = userAccountId;
	}

	public int getTownshipId() {
		return townshipId;
	}

	public void setTownshipId(int townshipId) {
		this.townshipId = townshipId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	

}
