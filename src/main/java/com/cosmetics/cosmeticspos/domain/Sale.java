package com.cosmetics.cosmeticspos.domain;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cosmetics.cosmeticspos.dto.CityDto;
import com.cosmetics.cosmeticspos.dto.SaleDto;
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
@Table(name = "sale")
public class Sale {
	public Sale(SaleDto dto) {

		this.saleId = dto.getSaleId();
		this.customerId = dto.getCustomerId();
		this.receivedDate = dto.getReceivedDate();
	    this.date = dto.getDate();	
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int saleId;
	private int customerId;
	private Date receivedDate;
	private Date date;
	
	
}
