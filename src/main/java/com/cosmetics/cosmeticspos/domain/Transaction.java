package com.cosmetics.cosmeticspos.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cosmetics.cosmeticspos.dto.TransactionDto;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	private int saleId;
	private int payment;
	private int balance;
	private String paymentType;
	private Date date;
	private Date modifiedDate;
	public Transaction(TransactionDto dto) {
		// TODO Auto-generated constructor stub
		this.transactionId = dto.getTransactionId();
		this.saleId = dto.getSaleId();
		this.payment=dto.getPayment();
		this.balance=dto.getBalance();
		this.paymentType=dto.getPaymentType();
		this.date=(dto.getDate() !=null)? dto.getDate() : newDate();
		this.modifiedDate=new Date();
	}
	private Date newDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	

}
