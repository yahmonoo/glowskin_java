package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.Category;
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
	public ProductDto(Product p) {
		// TODO Auto-generated constructor stub
		this.productId = p.getProductId();
		this.photoOne = p.getPhotoOne();
		this.photoTwo = p.getPhotoTwo();
		this.photoThree = p.getPhotoThree();
		this.photoFour = p.getPhotoFour();
		this.title = p.getTitle();
		this.priceOne = p.getPriceOne();
		this.priceTwo = p.getPriceTwo();
		this.sizeOne = p.getSizeOne();
		this.sizeTwo = p.getSizeTwo();
		this.colorOne = p.getColorOne();
		this.colorTwo = p.getColorTwo();
		this.colorThree = p.getColorThree();
		this.colorFour = p.getColorFour();
		this.code = p.getCode();
		this.detail = p.getDetail();
	    this.rating=p.getRating();
	    this.discountPriceOne = p.getDiscountPriceOne();
        this.discountPriceTwo = p.getDiscountPriceTwo();
        this.normalPriceOne = p.getNormalPriceOne();
        this.normalPriceTwo = p.getNormalPriceTwo();
        this.percent=p.getPercent();
        this.type = p.getType();
        this.count = p.getCount();
//	    this.categorydto=new CategoryDto(pro.getCategoryId());
        this.colorBox=p.getColorBox();
		
	}
	private int productId;
	private UseraccountDto userAccountdto;
	private CategoryDto categorydto;
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
	private int colorBox;//non , lip
	private int buyQuantity;
	

	}

