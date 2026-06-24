package com.cosmetics.cosmeticspos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cosmetics.cosmeticspos.dto.CityDto;

@Entity
@Table(name = "city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cityId;
	private String cityName;
	public City(CityDto dto) {
		// TODO Auto-generated constructor stub
		this.cityId = dto.getCityId();
		this.cityName = dto.getCityName();
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}
