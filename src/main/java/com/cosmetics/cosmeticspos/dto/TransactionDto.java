package com.cosmetics.cosmeticspos.dto;

import com.cosmetics.cosmeticspos.domain.Transaction;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(value = Include.USE_DEFAULTS)
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
	private int transactionId;
	private int saleId;
	private int payment;
	private int balance;
	private String paymentType;
	private LocalDateTime date;
	private LocalDateTime modifiedDate;

}
