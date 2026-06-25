package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Itemtransaction;
import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;

@Repository
public class ItemtransactionDaoImpl implements ItemtransactionDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addItemtransaction(Itemtransaction i) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(i);
		
	}

	@Override
	public List<ItemtransactionDto> getItemtransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateItemtransaction(Itemtransaction i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItemtransaction(Itemtransaction i) {
		// TODO Auto-generated method stub
		
	}
	

	
}
