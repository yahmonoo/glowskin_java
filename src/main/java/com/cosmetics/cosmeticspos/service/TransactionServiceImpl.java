package com.cosmetics.cosmeticspos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetics.cosmeticspos.dao.TransactionDao;
import com.cosmetics.cosmeticspos.domain.Transaction;
import com.cosmetics.cosmeticspos.dto.TransactionDto;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDao transactionDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<TransactionDto> getTransaction() {
		return transactionDao.getTransaction();
		
	}
	
	@Transactional(readOnly=false)
	@Override
	public int addTransaction(TransactionDto dto) {
		// TODO Auto-generated method stub
		Transaction t = new Transaction(dto);
				transactionDao.addTransaction(t);
				return t.getTransactionId();
	}
	
	@Transactional(readOnly=false)
	@Override
	public int updateTransaction(TransactionDto dto) {
		// TODO Auto-generated method stub
		Transaction  t= new Transaction(dto);
		transactionDao.updateTransaction(t);
		return t.getTransactionId();
		
	}

	@Override
	public int deleteTransaction(TransactionDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
