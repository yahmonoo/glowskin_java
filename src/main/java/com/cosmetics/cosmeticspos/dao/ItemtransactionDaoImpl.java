package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Category;
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
		List<Itemtransaction> itemtransactionList = session.createQuery("SELECT item FROM Itemtransaction item " ,Itemtransaction.class).getResultList();
		return itemtransactionList;
	}

	    
	    @Override
	    public void updateItemtransaction(Itemtransaction i) {
	        Session session = sessionFactory.getCurrentSession();
	        session.createQuery("UPDATE Itemtransaction SET "
	        		            +"productId = :productId, "
	        		            +" saleId = :saleId,"
	        		            + "qty = :qty,"
	        		            + "unitPrice = :unitPrice,"
	        		            + "amount = :amount, "
	        		            + "discount = :discount,"
	        		            + "balance = :balance "
	        		            + "WHERE itemTransactionId = :itemTransactionId")
	        		                .setParameter("productId", i.getProductId())
	                                .setParameter("saleId", i.getSaleId())
	                                .setParameter("qty", i.getQty())
	        		                .setParameter("unitPrice", i.getUnitPrice())
	        		                .setParameter("amount", i.getAmount()) 
	        		                .setParameter("discount", i.getDiscount())
	        		                .setParameter("balance", i.getBalance())
	        		                .setParameter("itemTransactionId", i.getItemTransactionId())
	        		                .executeUpdate();
	        	
	    }
	    @Override
	    public void deleteItemtransaction(Itemtransaction i) {
	        Session session = sessionFactory.getCurrentSession();
	        session.createQuery("DELETE FROM Itemtransaction WHERE itemTransactionId = :itemTransactionId")
	               .setParameter("itemTransactionId", i.getItemTransactionId())
	               .executeUpdate();
	    }
}

