package com.cosmetics.cosmeticspos.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.infolite.dental.util.DateTimeFormatDeserializer;
import com.infolite.dental.util.DateTimeFormatSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
	private int ratingId;
	private int customerId;
	private int productId;
	private int rating;

	private Date date;

}
