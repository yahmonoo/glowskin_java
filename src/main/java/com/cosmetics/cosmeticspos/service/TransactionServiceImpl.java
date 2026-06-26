package com.cosmetics.cosmeticspos.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetics.cosmeticspos.dao.TransactionDao;
import com.cosmetics.cosmeticspos.domain.Township;
import com.cosmetics.cosmeticspos.domain.Transaction;
import com.cosmetics.cosmeticspos.dto.TownshipDto;
import com.cosmetics.cosmeticspos.dto.TransactionDto;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDao transactionDao;
	
	@Override
	@Transactional(readOnly=true)
	
	public List<TransactionDto> getTransaction() {
		return transactionDao.getTransaction();
		
	}
	
	@Transactional(readOnly=false)
	@Override
	public TransactionDto addTransaction(TransactionDto dto) {
		// TODO Auto-generated method stub
		Transaction transaction = new Transaction(dto);
				transactionDao.addTransaction(transaction);
				dto.setTransactionId(transaction.getTransactionId());
				dto.setDate(new Date());
				dto.setModifiedDate(new Date());
				return dto;
	}
	
	@Transactional(readOnly=false)
	@Override
	public TransactionDto updateTransaction(TransactionDto dto) {
		Transaction transaction = new Transaction(dto);
		transaction.setModifiedDate(new Date());
		transactionDao.updateTransaction(transaction);
		dto.setTransactionId(transaction.getTransactionId());

		dto.setDate(transaction.getDate());
		dto.setModifiedDate(transaction.getModifiedDate());
		
		return dto;
	
	}

	
	@Override
	@Transactional(readOnly=false)
	public int deleteTransaction(int transactionId) {
		// TODO Auto-generated method stub
		transactionDao.deleteTransaction(transactionId);
		return transactionId;
	}

	
	@Override
	@Transactional(readOnly=true)
	public TransactionDto getTransactionById(int id) {
		Transaction transaction=transactionDao.getTransactionById(id);
		if(transaction==null) return null;
		return new TransactionDto(transaction);
	}

	
	

}
