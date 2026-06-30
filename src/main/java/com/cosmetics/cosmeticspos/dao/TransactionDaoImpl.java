package com.cosmetics.cosmeticspos.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Transaction;
import com.cosmetics.cosmeticspos.dto.TransactionDto;

@Repository
public class TransactionDaoImpl  implements TransactionDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(transaction);
		
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(transaction);


		
	}
	

	@Override
	public void deleteTransaction(int transactionId) {
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("DELETE FROM transaction WHERE transactionId= ?").setParameter(1,transactionId).executeUpdate();

		
	}

	@Override
	public List<TransactionDto> getTransaction() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sqlData="SELECT t.transactionId,t.saleId,t.payment,t.balance,t.paymentType,t.date,t.modifiedDate FROM transaction t ORDER BY t.transactionId DESC";
		List<Object[]>objectList=session.createNativeQuery(sqlData).getResultList();
		List<TransactionDto> dtoList=new ArrayList<TransactionDto>();
		for(Object[] object: objectList) {
			int transactionId=Integer.parseInt(object[0].toString());
			int saleId=Integer.parseInt(object[1].toString());
			int payment=Integer.parseInt(object[2].toString());
			int balance=Integer.parseInt(object[3].toString());
			String paymentType=object[4].toString();
			Date date=(Date) object[5];
			Date modifiedDate=(Date) object[6];
			TransactionDto dto=new TransactionDto(transactionId,saleId,payment,balance,paymentType,date,modifiedDate);
			dtoList.add(dto);
			

			
		}
		return dtoList;

		
	}


	@Override
	public Transaction getTransactionById(int transactionId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		return session.find(Transaction.class, transactionId);
	}
	



}
