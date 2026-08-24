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
		return itemTransactionId;
	}
	public void setItemTransactionId(int itemTransactionId) {
		this.itemTransactionId = itemTransactionId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
}

