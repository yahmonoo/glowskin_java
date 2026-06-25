package com.cosmetics.cosmeticspos.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;
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
@Table(name = "itemtransaction")
public class Itemtransaction {
	public Itemtransaction(ItemtransactionDto dto) {
	// TODO Auto-generated constructor stub
			this.itemTransactionId = dto.getItemTransactionId();
			this.productId = dto.getProductId();
			this.saleId=dto.getSaleId();
			this.qty=dto.getQty();
			this.unitPrice=dto.getUnitPrice();
			this.amount=dto.getAmount();
			this.discount=dto.getDiscount();
			this.balance=dto.getBalance();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		return itemTransactionId;
	}
	
	}
	
	
	
	
	

