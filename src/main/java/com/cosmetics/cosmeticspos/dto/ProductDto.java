package com.cosmetics.cosmeticspos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	public ProductDto(String photoOne, String title, String code, int priceOne,int rating) {
		// TODO Auto-generated constructor stub
		this.photoOne = photoOne;
		this.title = title;
		this.code = code;
		this.priceOne = priceOne;
		this.ratingCount = rating;
	}
	private int productId;
	private int userAccountId;
	private int categoryId;
	private int type;
	private String photoOne;
	private String photoTwo;
	private String photoThree;
	private String photoFour;
	private String colorOne;
	private String colorTwo;
	private String colorThree;
	private String colorFour;
	private int priceOne;
	private int priceTwo;
	private int sizeOne;
	private int sizeTwo;
	private String title;
	private String detail;
	private String code;
	private int count;
	private int discountPriceOne;
	private int discountPriceTwo;
	private int percent;
	private int normalPriceOne;
	private int normalPriceTwo;
	private double ratingCount;
}
