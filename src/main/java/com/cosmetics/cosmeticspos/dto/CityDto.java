package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.City;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
	public CityDto(City c) {
		// TODO Auto-generated constructor stub
		this.cityId = c.getCityId();
		this.cityName = c.getCityName();
	}
	private int cityId;
	private String cityName;
}
