package com.cosmetics.cosmeticspos.dto;


import java.util.Date;

import com.cosmetics.cosmeticspos.domain.Sale;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {
	public SaleDto(Sale s) {
		// TODO Auto-generated constructor stub
				this.saleId = s.getSaleId();
				this.customerId = s.getCustomerId();
				this.receivedDate =s.getReceivedDate();
				this.date = s.getDate();
			}

	private int saleId;
	private int customerId;
	private Date receivedDate;
	private Date date;

}
