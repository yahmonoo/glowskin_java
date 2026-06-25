package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.Itemtransaction;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class ItemtransactionDto {
	public ItemtransactionDto(Itemtransaction item) {
		this.itemTransactionId=item.getItemTransactionId();
		this.productId=item.getProductId();
		this.saleId=item.getSaleId();
		this.qty=item.getQty();
		this.unitPrice=item.getUnitPrice();
		this.amount=item.getAmount();
		this.discount=item.getDiscount();
		this.balance=item.getDiscount();
	}
	private int itemTransactionId;
	private int productId;
	private int saleId;
	private int qty;
	private int unitPrice;
	private int amount;
	private int discount;
	private int balance;
}

