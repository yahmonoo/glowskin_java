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
import com.cosmetics.cosmeticspos.dto.YearDto;
import com.infolite.dental.util.ConvertDate;

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

	@Override
	public List<SaleDto> getSaleList(Date fromDate, Date toDate, int customerId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String strFromDate = ConvertDate.convertDateToStringYearMonthDay(fromDate);
		String strToDate = ConvertDate.convertDateToStringYearMonthDay(toDate);
		String sqlWhere = " ";
		if(customerId>0) {
			sqlWhere += " AND s.customerId="+customerId;
		}
		List<Object[]> objList = session.createNativeQuery("SELECT ua.userAccountId,ua.profileName,\r\n"
				+ "s.receivedDate,s.voucherCode,count(s.saleId) AS itemCount,\r\n"
				+ "t.amount,t.deliFee,t.paymentType,t.payment,s.date,s.saleId\r\n"
				+ "FROM sale s\r\n"
				+ "LEFT JOIN useraccount ua ON ua.userAccountId = s.customerId\r\n"
				+ "LEFT JOIN itemtransaction it ON it.saleId = s.saleId\r\n"
				+ "LEFT JOIN `transaction` t ON t.saleId = s.saleId\r\n"
				+ "WHERE DATE(s.receivedDate) Between :fromDate and :toDate \r\n"
				+sqlWhere
				+ " GROUP BY s.saleId\r\n")
				.setParameter("fromDate", strFromDate).setParameter("toDate", strToDate)
				.getResultList();
		List<SaleDto> dtoList = new ArrayList<>();
		int totalAmount = 0;
		int totalDeliFee = 0;
		int totalPayment = 0;
		for(Object[] obj:objList) {
			int userId = Integer.parseInt(obj[0].toString());
			String userName = (String)obj[1];
			Date receivedDate = (Date)obj[2];
			String vc = (String)obj[3];
			int itemCount = Integer.parseInt(obj[4].toString());
			int amount = Integer.parseInt(obj[5].toString());
			int deliFee = Integer.parseInt(obj[6].toString());
			String payType = (String)obj[7];
			int payment = Integer.parseInt(obj[8].toString());
			Date date = (Date)obj[9];
			int saleId = Integer.parseInt(obj[10].toString());
			SaleDto dto = new SaleDto(userId,userName,receivedDate,vc,itemCount,amount,deliFee,payType,payment,date);
			dto.setSaleId(saleId);
			dtoList.add(dto);
			totalPayment+=payment;
			totalDeliFee+=deliFee;
			totalAmount+=amount;
		}
		if(dtoList.size()>0) {
			SaleDto dto = new SaleDto(0,"",null,"",0,totalAmount,totalDeliFee,"",totalPayment,null);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public YearDto getSaleYearReport() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 List<Object[]> objList = session.createNativeQuery("SELECT sum(t.payment),DATE_FORMAT(s.receivedDate,'%m')\r\n"
		 		+ "FROM sale s\r\n"
		 		+ "LEFT JOIN `transaction` t ON t.saleId = s.saleId\r\n"
		 		+ "GROUP BY DATE_FORMAT(s.receivedDate,'%m')\r\n"
		 		+ "").getResultList();
		 //
		return null;
	}

	@Override
	public void deleteTransactionBySaleId(int saleId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.createNativeQuery("delete from transaction  where saleId =:saleId")
		.setParameter("saleId", saleId).executeUpdate();
	}

	@Override
	public void deleteItemTransactionBySaleId(int saleId) {
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				session.createNativeQuery("delete from itemtransaction  where saleId =:saleId")
				.setParameter("saleId", saleId).executeUpdate();
	}

}
