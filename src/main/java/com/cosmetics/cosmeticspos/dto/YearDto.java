package com.cosmetics.cosmeticspos.dto;

import java.util.List;

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
public class YearDto {
	public YearDto(List<String> labels2, List<Double> salesData) {
		// TODO Auto-generated constructor stub
		this.labels=labels;
		this.monthlySales=salesData;
	}
	private int one;
	private List<String> labels;
	private List<Double> monthlySales;
}
