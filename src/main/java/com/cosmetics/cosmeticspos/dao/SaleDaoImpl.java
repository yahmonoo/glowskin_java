package com.cosmetics.cosmeticspos.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Sale;
import com.cosmetics.cosmeticspos.dto.SaleDto;

@Repository
public class SaleDaoImpl implements SaleDao{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<SaleDto> getSale(String search) {
		
		Session session = sessionFactory.getCurrentSession();
		List<SaleDto> dtoList = new ArrayList<>();
		List<Object[]> objList = session.createNativeQuery("SELECT s.saleId, u.userAccountId, s.receivedDate, s.date "
				+ "FROM sale s "
				+ "LEFT JOIN useraccount u ON u.userAccountId = s.customerId "
				+ "WHERE s.saleId LIKE :search")
				.setParameter("search", "%"+search+"%")
						.getResultList();
		for(Object[] obj:objList) {
		    int saleId = Integer.parseInt(obj[0].toString());
		    int customerId = Integer.parseInt(obj[1].toString());
		    Date receivedDate = (Date)obj[2];
		    Date date = (Date)obj[3];
		    
		    SaleDto dto = new SaleDto(saleId, customerId, receivedDate, date);
		    dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public void addSale(Sale s) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(s);
		
	}

	
	@Override
	public void getCity(String search) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSale(Sale s) {
		Session session = sessionFactory.getCurrentSession();
		session.update(s);
		}

	@Override
	public void deleteSale(Sale s) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(s);
	}

	@Override
	public List<Sale> getSale() {
		
		    Session session = sessionFactory.getCurrentSession();
		    return session.createQuery("from Sale", Sale.class).list();
		}

}
