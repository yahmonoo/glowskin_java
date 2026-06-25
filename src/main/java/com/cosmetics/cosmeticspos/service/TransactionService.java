package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.TransactionDto;

public interface TransactionService {
	
	 List<TransactionDto> getTransaction();

		int addTransaction(TransactionDto dto);

		int updateTransaction(TransactionDto dto);

		int deleteTransaction(TransactionDto dto);


}
