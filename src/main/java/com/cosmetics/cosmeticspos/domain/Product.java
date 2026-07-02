package com.cosmetics.cosmeticspos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;
import com.cosmetics.cosmeticspos.dto.ProductDto;
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
@Table(name = "product")
public class Product {
	public Product(ProductDto dto) {
		// TODO Auto-generated constructor stub
					this.productId=dto.getProductId();
					this.userAccountId=dto.getUserAccountId();
					this.categoryId=dto.getCategoryId();
					this.type=dto.getType();
					this.photoOne=dto.getPhotoOne();
					this.photoTwo=dto.getPhotoTwo();
					this.photoThree=dto.getPhotoThree();
					this.photoFour=dto.getPhotoFour();
					this.colorOne=dto.getColorOne();
					this.colorTwo=dto.getColorTwo();
					this.colorThree=dto.getColorThree();
					this.colorFour=dto.getColorFour();
					this.priceOne=dto.getPriceOne();
					this.priceTwo=dto.getPriceTwo();
					this.sizeOne=dto.getSizeOne();
					this.sizeTwo=dto.getSizeTwo();
					this.title=dto.getTitle();
					this.detail=dto.getDetail();
					this.code=dto.getCode();
					this.count=dto.getCount();
					this.discountPriceOne=dto.getDiscountPriceOne();
					this.discountPriceTwo=dto.getDiscountPriceTwo();
					this.percent=dto.getPercent();
					this.normalPriceOne=dto.getNormalPriceOne();
					this.normalPriceTwo=dto.getDiscountPriceTwo();
					this.rating=dto.getRating();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
