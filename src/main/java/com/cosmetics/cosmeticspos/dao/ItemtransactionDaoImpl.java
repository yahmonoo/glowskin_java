package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.domain.Itemtransaction;
import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;

@Repository
public class ItemtransactionDaoImpl implements ItemtransactionDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addItemtransaction(Itemtransaction item) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(item);
		
	}

	@Override
	public List<Itemtransaction> getItemtransaction() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Itemtransaction> itemtransactionList = session.createQuery("SELECT item FROM itemtransaction item  ").getResultList();
		return itemtransactionList;
	}

	@Override
	public void updateItemtransaction(Itemtransaction item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItemtransaction(Itemtransaction item) {
		// TODO Auto-generated method stub
		
	}
	

	
}
