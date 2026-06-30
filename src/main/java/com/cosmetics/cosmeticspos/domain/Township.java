package com.cosmetics.cosmeticspos.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cosmetics.cosmeticspos.dto.TownshipDto;

@Entity
@Table(name = "township")
public class Township {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int townshipId;
	private int cityId;
	private String townshipName;
	public Township(TownshipDto dto) {
		// TODO Auto-generated constructor stub
		this.townshipId = dto.getTownshipId();
		this.townshipName = dto.getTownshipName();
		this.cityId=dto.getCityId();
	}
	public int getTownshipId() {
		return townshipId;
	}
	public void setTownshipId(int townshipId) {
		this.townshipId = townshipId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getTownshipName() {
		return townshipName;
	}
	public void setTownshipName(String townshipName) {
		this.townshipName = townshipName;
	}
	

}
