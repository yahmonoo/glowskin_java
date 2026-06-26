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
	private int cityId;
	private String townshipName;

public TownshipDto(Township township) {
	this.townshipId=township.getTownshipId();
	this.cityId=township.getCityId();
	this.townshipName=township.getTownshipName();
	
	
}

}
