package com.cosmetics.cosmeticspos.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cosmetics.cosmeticspos.dto.CityDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class City {

	public City(CityDto dto) {

		this.cityId = dto.getCityId();
		this.cityName = dto.getCityName();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cityId;
	private String cityName;
}


