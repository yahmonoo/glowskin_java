package com.cosmetics.cosmeticspos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(int userAccountId) {
		this.userAccountId = userAccountId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPhotoOne() {
		return photoOne;
	}
	public void setPhotoOne(String photoOne) {
		this.photoOne = photoOne;
	}
	public String getPhotoTwo() {
		return photoTwo;
	}
	public void setPhotoTwo(String photoTwo) {
		this.photoTwo = photoTwo;
	}
	public String getPhotoThree() {
		return photoThree;
	}
	public void setPhotoThree(String photoThree) {
		this.photoThree = photoThree;
	}
	public String getPhotoFour() {
		return photoFour;
	}
	public void setPhotoFour(String photoFour) {
		this.photoFour = photoFour;
	}
	public String getColorOne() {
		return colorOne;
	}
	public void setColorOne(String colorOne) {
		this.colorOne = colorOne;
	}
	public String getColorTwo() {
		return colorTwo;
	}
	public void setColorTwo(String colorTwo) {
		this.colorTwo = colorTwo;
	}
	public String getColorThree() {
		return colorThree;
	}
	public void setColorThree(String colorThree) {
		this.colorThree = colorThree;
	}
	public String getColorFour() {
		return colorFour;
	}
	public void setColorFour(String colorFour) {
		this.colorFour = colorFour;
	}
	public int getPriceOne() {
		return priceOne;
	}
	public void setPriceOne(int priceOne) {
		this.priceOne = priceOne;
	}
	public int getPriceTwo() {
		return priceTwo;
	}
	public void setPriceTwo(int priceTwo) {
		this.priceTwo = priceTwo;
	}
	public int getSizeOne() {
		return sizeOne;
	}
	public void setSizeOne(int sizeOne) {
		this.sizeOne = sizeOne;
	}
	public int getSizeTwo() {
		return sizeTwo;
	}
	public void setSizeTwo(int sizeTwo) {
		this.sizeTwo = sizeTwo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getDiscountPriceOne() {
		return discountPriceOne;
	}
	public void setDiscountPriceOne(int discountPriceOne) {
		this.discountPriceOne = discountPriceOne;
	}
	public int getDiscountPriceTwo() {
		return discountPriceTwo;
	}
	public void setDiscountPriceTwo(int discountPriceTwo) {
		this.discountPriceTwo = discountPriceTwo;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public int getNormalPriceOne() {
		return normalPriceOne;
	}
	public void setNormalPriceOne(int normalPriceOne) {
		this.normalPriceOne = normalPriceOne;
	}
	public int getNormalPriceTwo() {
		return normalPriceTwo;
	}
	public void setNormalPriceTwo(int normalPriceTwo) {
		this.normalPriceTwo = normalPriceTwo;
	}
	
	

}
