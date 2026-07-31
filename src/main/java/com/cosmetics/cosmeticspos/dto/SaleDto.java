package com.cosmetics.cosmeticspos.dto;


import java.util.Date;
import java.util.List;

import com.cosmetics.cosmeticspos.domain.Sale;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.infolite.dental.util.DateFormatDeserializer;
import com.infolite.dental.util.DateFormatSerializer;
import com.infolite.dental.util.DateTimeFormatDeserializer;
import com.infolite.dental.util.DateTimeFormatSerializer;

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

	public SaleDto(int userId, String userName, Date receivedDate, String vc, int itemCount, int amount, int deliFee,
			String payType, int payment, Date date) {
		// TODO Auto-generated constructor stub
		this.userAccount = new UseraccountDto(userId,userName);
		this.receivedDate = receivedDate;
		this.voucherCode = vc;
		this.itemCount = itemCount;
		this.transaction = new TransactionDto(amount,deliFee,payType,payment);
		this.date = date;
	}

	private int saleId;
	private int customerId;
	private UseraccountDto userAccount;
	@JsonSerialize(using = DateFormatSerializer.class)
	@JsonDeserialize(using = DateFormatDeserializer.class)
	private Date receivedDate;
	@JsonSerialize(using = DateTimeFormatSerializer.class)
	@JsonDeserialize(using = DateTimeFormatDeserializer.class)
	private Date date;
	private String voucherCode;
	private List<ItemtransactionDto> itemList;
	private TransactionDto transaction;
	private List<ProductDto> productList;
	private int itemCount;
	private String productId;
	private int unitPrice;
	private List<ItemtransactionDto> items; 

}
