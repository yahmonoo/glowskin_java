package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.Township;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class TownshipDto {
	private int townshipId;
	private CityDto cityDto;
	private String townshipName;

public TownshipDto(Township township) {
	this.townshipId=township.getTownshipId();
	
	this.cityDto = new CityDto(township.getCityId());
	this.townshipName=township.getTownshipName();
	
	
}

public TownshipDto(int townshipId, String townshipName) {
	// TODO Auto-generated constructor stub
	this.townshipId = townshipId;
	this.townshipName = townshipName;
}

}
