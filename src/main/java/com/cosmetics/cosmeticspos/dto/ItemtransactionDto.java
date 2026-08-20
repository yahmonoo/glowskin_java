package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.Itemtransaction;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
		this.balance=item.getBalance();
	}
	private int itemTransactionId;
	private int productId;
	private int saleId;
	private int qty;
	private int unitPrice;
	private int amount;
	private int discount;
	private int balance;
	
	public int getItemTransactionId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getProductId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setProductId(Object object) {
		// TODO Auto-generated method stub
		
	}
	public void setQty(int i) {
		// TODO Auto-generated method stub
		
	}
	public void setUnitPrice(int i) {
		// TODO Auto-generated method stub
		
	}
	public void setAmount(int i) {
		// TODO Auto-generated method stub
		
	}
	public int getSaleId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getUnitPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

