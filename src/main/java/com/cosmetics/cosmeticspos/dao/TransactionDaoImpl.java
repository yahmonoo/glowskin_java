package com.cosmetics.cosmeticspos.dao;

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
	public void addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		
	}

	@Override
	public void updateTransaction(Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TransactionDto> getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

}
