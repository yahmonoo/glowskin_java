package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.Product;
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
		this.rating = rating;
	}
	public ProductDto(Product pro) {
		// TODO Auto-generated constructor stub
		this.productId = pro.getProductId();
		this.photoOne = pro.getPhotoOne();
		this.photoTwo = pro.getPhotoTwo();
		this.photoThree = pro.getPhotoThree();
		this.photoFour = pro.getPhotoFour();
		this.title = pro.getTitle();
		this.priceOne = pro.getPriceOne();
		this.priceTwo = pro.getPriceTwo();
		this.sizeOne = pro.getSizeOne();
		this.sizeTwo = pro.getSizeTwo();
		this.colorOne = pro.getColorOne();
		this.colorTwo = pro.getColorTwo();
		this.colorThree = pro.getColorThree();
		this.colorFour = pro.getColorFour();
		this.code = pro.getCode();
		this.detail = pro.getDetail();
	    this.rating=pro.getRating();
		
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
	private int rating;

	}

