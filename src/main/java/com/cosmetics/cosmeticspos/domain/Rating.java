package com.cosmetics.cosmeticspos.domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cosmetics.cosmeticspos.dto.RatingDto;
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
@Table(name = "rating")
public class Rating {
	public Rating(RatingDto dto) {
		// TODO Auto-generated constructor stub
		this.ratingId=dto.getRating();
		this.customerId=dto.getCustomerId();
		this.productId=dto.getProductId();
		this.rating=dto.getRating();
		this.date=dto.getDate();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ratingId;
	private int customerId;
	private int productId;
	private int rating;
	private Date date;
	}
	