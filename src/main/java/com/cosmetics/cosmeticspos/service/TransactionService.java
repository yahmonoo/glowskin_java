package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.TransactionDto;

public interface TransactionService {
	
	 List<TransactionDto> getTransaction();

		TransactionDto addTransaction(TransactionDto dto);

		TransactionDto updateTransaction(TransactionDto dto);
		int deleteTransaction(int transactionId);

		TransactionDto getTransactionById(int id);


}
