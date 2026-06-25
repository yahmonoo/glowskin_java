package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.Township;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(value = Include.USE_DEFAULTS)
public class TownshipDto {
	private int townshipId;
	private int cityId;
	private String townshipName;

public TownshipDto(Township township) {
	this.townshipId=township.getTownshipId();
	this.cityId=township.getCityId();
	this.townshipName=township.getTownshipName();
	
	
}
public TownshipDto(int townshipId, int cityId, String townshipName) {
	this.townshipId=townshipId;
	this.cityId=cityId;
	this.townshipName=townshipName;
}
public int getTownshipId() {
	// TODO Auto-generated method stub
	return 0;
}
public String getTownshipName() {
	// TODO Auto-generated method stub
	return null;
}
public int getCityId() {
	// TODO Auto-generated method stub
	return 0;
}
}
