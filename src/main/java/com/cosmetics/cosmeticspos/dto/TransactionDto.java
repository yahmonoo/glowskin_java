package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.Transaction;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
//@AllArgsConstructor
public class TransactionDto {
	public TransactionDto(Transaction transaction) {
		// TODO Auto-generated constructor stub
		this.transactionId=transaction.getTransactionId();
		this.saleId=transaction.getSaleId();
		this.payment=transaction.getPayment();
		this.balance=transaction.getBalance();
		this.paymentType=transaction.getPaymentType();
		this.date= transaction.getDate();
		this.modifiedDate=transaction.getModifiedDate();
	}
	
public TransactionDto(int transactionId, int saleId, int payment, int balance, String paymentType,
Date date, Date modifiedDate) {
    //TODO Auto-generated constructor stub
	this.transactionId=transactionId;
	this.saleId=saleId;
	this.payment=payment;
	this.balance=balance;
	this.paymentType=paymentType;
	this.date=date;
	this.modifiedDate=modifiedDate;
}

private int transactionId;
private int saleId;
private int payment;
private int balance;
private String paymentType;
private Date date;
private Date modifiedDate;
}

