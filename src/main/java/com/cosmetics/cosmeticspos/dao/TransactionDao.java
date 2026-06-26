package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Transaction;
import com.cosmetics.cosmeticspos.dto.TransactionDto;

public interface TransactionDao {
	 void addTransaction(Transaction transaction); 

	    void updateTransaction(Transaction transaction) ;
	  

		List<TransactionDto> getTransaction();

		Transaction getTransactionById(int transactionId);

		void deleteTransaction(int transactionId);

		
		

}
