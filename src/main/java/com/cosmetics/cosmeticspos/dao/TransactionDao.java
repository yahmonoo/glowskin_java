package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Transaction;
import com.cosmetics.cosmeticspos.dto.TransactionDto;

public interface TransactionDao {
	 void addTransaction(Transaction t); 

	    void updateTransaction(Transaction t) ;

		List<TransactionDto> getTransaction();

}
