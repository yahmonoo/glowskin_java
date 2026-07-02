package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
//	public CategoryDto(int categoryId, String name) {
//		// TODO Auto-generated constructor stub
//		this.categoryId=categoryId;
//		this.name=name;
//	}
	public CategoryDto(Category cat) {
		// TODO Auto-generated constructor stub
		this.categoryId=cat.getCategoryId();
		this.name=cat.getName();
	}
	
	private int categoryId;
	private String name;
}
