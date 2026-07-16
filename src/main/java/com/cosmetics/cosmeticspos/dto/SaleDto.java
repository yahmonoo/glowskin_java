package com.cosmetics.cosmeticspos.dto;


import java.util.Date;
import java.util.List;

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

	public SaleDto(int saleId2, int customerId2, Date receivedDate2, Date date2) {
		// TODO Auto-generated constructor stub
		this.saleId = saleId2;
		this.customerId = customerId2;
		this.receivedDate = receivedDate2;
		this.date = date2;
	}

	private int saleId;
	private int customerId;
	private Date receivedDate;
	private Date date;
	private String voucherCode;
	private List<ItemtransactionDto> itemList;
	private TransactionDto transaction;

}
