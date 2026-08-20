package com.cosmetics.cosmeticspos.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Sale;
import com.cosmetics.cosmeticspos.domain.Transaction;
import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;
import com.cosmetics.cosmeticspos.dto.SaleDto;
import com.cosmetics.cosmeticspos.dto.TransactionDto;
import com.cosmetics.cosmeticspos.dto.UseraccountDto;
import com.cosmetics.cosmeticspos.dto.YearDto;
import com.infolite.dental.util.ConvertDate;

@Repository
public class SaleDaoImpl implements SaleDao{
	@Autowired
	SessionFactory sessionFactory;
	private Double totalPayment;

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

//	@Override
//	public List<SaleDto> getSaleList(Date fromDate, Date toDate, int customerId) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		String strFromDate = ConvertDate.convertDateToStringYearMonthDay(fromDate);
//		String strToDate = ConvertDate.convertDateToStringYearMonthDay(toDate);
//		String sqlWhere = " ";
//		if(customerId>0) {
//			sqlWhere += " AND s.customerId="+customerId;
//		}
//		List<Object[]> objList = session.createNativeQuery("SELECT ua.userAccountId,ua.profileName,\r\n"
//				+ "s.receivedDate,s.voucherCode,count(s.saleId) AS itemCount,\r\n"
//				+ "t.amount,t.deliFee,t.paymentType,t.payment,s.date,s.saleId\r\n"
//				+ "FROM sale s\r\n"
//				+ "LEFT JOIN useraccount ua ON ua.userAccountId = s.customerId\r\n"
//				+ "LEFT JOIN itemtransaction it ON it.saleId = s.saleId\r\n"
//				+ "LEFT JOIN `transaction` t ON t.saleId = s.saleId\r\n"
//				+ "WHERE DATE(s.receivedDate) Between :fromDate and :toDate \r\n"
//				+sqlWhere
//				+ " GROUP BY s.saleId\r\n")
//				.setParameter("fromDate", strFromDate).setParameter("toDate", strToDate)
//				.getResultList();
//		List<SaleDto> dtoList = new ArrayList<>();
//		int totalAmount = 0;
//		int totalDeliFee = 0;
//		int totalPayment = 0;
//		for(Object[] obj:objList) {
//			int userId = Integer.parseInt(obj[0].toString());
//			String userName = (String)obj[1];
//			Date receivedDate = (Date)obj[2];
//			String vc = (String)obj[3];
//			int itemCount = Integer.parseInt(obj[4].toString());
//			int amount = Integer.parseInt(obj[5].toString());
//			int deliFee = Integer.parseInt(obj[6].toString());
//			String payType = (String)obj[7];
//			int payment = Integer.parseInt(obj[8].toString());
//			Date date = (Date)obj[9];
//			int saleId = Integer.parseInt(obj[10].toString());
//			SaleDto dto = new SaleDto(userId,userName,receivedDate,vc,itemCount,amount,deliFee,payType,payment,date);
//			dto.setSaleId(saleId);
//			dtoList.add(dto);
//			totalPayment+=payment;
//			totalDeliFee+=deliFee;
//			totalAmount+=amount;
//		}
//		if(dtoList.size()>0) {
//			SaleDto dto = new SaleDto(0,"",null,"",0,totalAmount,totalDeliFee,"",totalPayment,null);
//			dtoList.add(dto);
//		}
//		return dtoList;
//	}
	
	@Override
	public List<SaleDto> getSaleList(Date fromDate, Date toDate, int customerId) {
	    Session session = sessionFactory.getCurrentSession();
	    String strFromDate = ConvertDate.convertDateToStringYearMonthDay(fromDate);
	    String strToDate = ConvertDate.convertDateToStringYearMonthDay(toDate);
	    String sqlWhere = "";
	    
	    if (customerId > 0) {
	        sqlWhere += " AND s.customerId = " + customerId;
	    }

	  
	    List<Object[]> objList = session.createNativeQuery(
	            "SELECT ua.userAccountId, ua.profileName, "
	            + "s.receivedDate, s.voucherCode, COALESCE(SUM(it.qty), 0) AS itemCount, "
	            + "COALESCE(t.amount, 0), COALESCE(t.deliFee, 0), t.paymentType, COALESCE(t.payment, 0), "
	            + "s.date, s.saleId, GROUP_CONCAT(it.productId) AS productIds, AVG(it.unitPrice) AS unitPrice "
	            + "FROM sale s "
	            + "LEFT JOIN useraccount ua ON ua.userAccountId = s.customerId "
	            + "LEFT JOIN itemtransaction it ON it.saleId = s.saleId "
	            + "LEFT JOIN `transaction` t ON t.saleId = s.saleId "
	            + "WHERE DATE(s.receivedDate) BETWEEN :fromDate AND :toDate "
	            + sqlWhere
	            + " GROUP BY s.saleId")
	            .setParameter("fromDate", strFromDate)
	            .setParameter("toDate", strToDate)
	            .getResultList();

	    List<SaleDto> dtoList = new ArrayList<>();
	    
	    for (Object[] obj : objList) {
	        int userId = obj[0] != null ? Integer.parseInt(obj[0].toString()) : 0;
	        String profileName = obj[1] != null ? obj[1].toString() : "-";
	        Date receivedDate = (Date) obj[2];
	        String vc = obj[3] != null ? obj[3].toString() : "-";
	        int itemCount = obj[4] != null ? Integer.parseInt(obj[4].toString()) : 0;
	        int amount = obj[5] != null ? Integer.parseInt(obj[5].toString()) : 0;
	        int deliFee = obj[6] != null ? Integer.parseInt(obj[6].toString()) : 0;
	        String payType = obj[7] != null ? obj[7].toString() : "";
	        int payment = obj[8] != null ? Integer.parseInt(obj[8].toString()) : 0;
	        Date date = (Date) obj[9];
	        int saleId = Integer.parseInt(obj[10].toString());
	        
	        String productId = obj[11] != null ? obj[11].toString() : "-";
	        int unitPrice = obj[12] != null ? (int) Math.round(Double.parseDouble(obj[12].toString())) : 0;

	        SaleDto dto = new SaleDto(userId, profileName, receivedDate, vc, itemCount, amount, deliFee, payType, payment, date);
	        dto.setSaleId(saleId);
	        dto.setCustomerId(userId);
	        dto.setProductId(productId);
	        dto.setUnitPrice(unitPrice);
	        
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
	    Session session = sessionFactory.getCurrentSession();
	   
	    session.createNativeQuery("DELETE FROM `transaction` WHERE saleId = :saleId")
	            .setParameter("saleId", saleId)
	            .executeUpdate();
	}
	@Override
	public void deleteItemTransactionBySaleId(int saleId) {
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				session.createNativeQuery("delete from itemtransaction  where saleId =:saleId")
				.setParameter("saleId", saleId).executeUpdate();
	}
	@Override
	public YearDto getSaleAnalyticsReport(int year, int month) {
		  Session session = sessionFactory.getCurrentSession();

	        List<Transaction> transactionList = session.createQuery("from Transaction", Transaction.class).list();

	        List<String> labels = new ArrayList<>();
	        List<Double> salesData = new ArrayList<>();

	        if (month == 0) {
	            String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	            labels.addAll(Arrays.asList(monthNames));

	            Double[] yearlyArray = new Double[12];
	            Arrays.fill(yearlyArray, 0.0);

	            for (Transaction t : transactionList) {
	                if (t.getDate() != null) {
	                    Calendar cal = Calendar.getInstance();
	                    cal.setTime(t.getDate()); 

	                    if (cal.get(Calendar.YEAR) == year) {
	                        int sMonth = cal.get(Calendar.MONTH); // 0 - 11
	                        yearlyArray[sMonth] += t.getPayment(); 
	                    }
	                }
	            }
	            salesData.addAll(Arrays.asList(yearlyArray));

	        } else {
	            int targetMonthIndex = month - 1; // January = 0, July = 6

	            Calendar calObj = Calendar.getInstance();
	            calObj.set(year, targetMonthIndex, 1);
	            int daysInMonth = calObj.getActualMaximum(Calendar.DAY_OF_MONTH);

	            for (int i = 1; i <= daysInMonth; i++) {
	                labels.add(String.valueOf(i));
	            }

	            Double[] dailyArray = new Double[daysInMonth];
	            Arrays.fill(dailyArray, 0.0);

	            for (Transaction t : transactionList) {
	                if (t.getDate() != null) {
	                    Calendar cal = Calendar.getInstance();
	                    cal.setTime(t.getDate()); 

	                    int tYear = cal.get(Calendar.YEAR);
	                    int tMonth = cal.get(Calendar.MONTH); // 0 - 11
	                    int tDay = cal.get(Calendar.DAY_OF_MONTH); // 1 - 31

	                    if (tYear == year && tMonth == targetMonthIndex) {
	                        dailyArray[tDay - 1] += t.getPayment(); 
	                    }
	                }
	            }
	            salesData.addAll(Arrays.asList(dailyArray));
	        }

	        return new YearDto(labels, salesData);
	    }
	
	@Override
	public List<SaleDto> getSaleByUserId(int userId) {
	    Session session = sessionFactory.getCurrentSession();
	    List<SaleDto> dtoList = new ArrayList<>();

	    try {
	        
	        List<Object[]> saleObjList = session.createNativeQuery(
	                "SELECT s.saleId, s.customerId, s.receivedDate, s.date, s.voucherCode " +
	                "FROM sale s " +
	                "WHERE s.customerId = :userId ORDER BY s.date DESC")
	                .setParameter("userId", userId)
	                .getResultList();

	        for (Object[] s : saleObjList) {
	            SaleDto dto = new SaleDto();
	            int saleId = Integer.parseInt(s[0].toString());
	            int custId = Integer.parseInt(s[1].toString());
	            Date receivedDate = (Date) s[2];
	            Date date = (Date) s[3];
	            String voucherCode = s[4] != null ? s[4].toString() : String.valueOf(saleId);

	            dto.setSaleId(saleId);
	            dto.setCustomerId(custId);
	            dto.setReceivedDate(receivedDate);
	            dto.setDate(date);
	            dto.setVoucherCode(voucherCode);

	          
	            try {
	                List<Object[]> userObj = session.createNativeQuery(
	                        "SELECT u.phone, u.address, u.location FROM useraccount u WHERE u.userAccountId = :userId")
	                        .setParameter("userId", custId)
	                        .getResultList();

	                UseraccountDto userDto = new UseraccountDto();
	                if (!userObj.isEmpty()) {
	                    Object[] u = userObj.get(0);
	                    userDto.setPhone(u[0] != null ? u[0].toString() : "-");
	                    userDto.setAddress(u[1] != null ? u[1].toString() : "-");
	                    userDto.setLocation(u[2] != null ? u[2].toString() : "-");
	                }
	                dto.setUserAccount(userDto);
	            } catch (Exception e) {
	                System.out.println("Useraccount Fetch Error: " + e.getMessage());
	            }

	            
	            try {
	                List<Object[]> itemObjList = session.createNativeQuery(
	                        "SELECT p.productName, it.qty, it.unitPrice, it.amount " +
	                        "FROM itemtransaction it " +
	                        "LEFT JOIN product p ON p.productId = it.productId " +
	                        "WHERE it.saleId = :saleId")
	                        .setParameter("saleId", saleId)
	                        .getResultList();

	                List<ItemtransactionDto> itemList = new ArrayList<>();
	                for (Object[] obj : itemObjList) {
	                    ItemtransactionDto itemDto = new ItemtransactionDto();
	                    itemDto.setProductId(obj[0] != null ? obj[0].toString() : "Cosmetic Product");
	                    itemDto.setQty(obj[1] != null ? Integer.parseInt(obj[1].toString()) : 1);
	                    itemDto.setUnitPrice(obj[2] != null ? Math.round(Float.parseFloat(obj[2].toString())) : 0);
	                    itemDto.setAmount(obj[3] != null ? Math.round(Float.parseFloat(obj[3].toString())) : 0);
	                    itemList.add(itemDto);
	                }
	                dto.setItemList(itemList);
	            } catch (Exception e) {
	                System.out.println("Item Fetch Error: " + e.getMessage());
	            }

	            try {
	                List<Object[]> tranObjList = session.createNativeQuery(
	                        "SELECT t.paymentType, t.amount, t.deliFee, t.payment " +
	                        "FROM `transaction` t WHERE t.saleId = :saleId")
	                        .setParameter("saleId", saleId)
	                        .getResultList();

	                if (!tranObjList.isEmpty()) {
	                    Object[] t = tranObjList.get(0);
	                    TransactionDto tranDto = new TransactionDto();
	                    tranDto.setPaymentType(t[0] != null ? t[0].toString() : "kpay");
	                    tranDto.setAmount(t[1] != null ? Math.round(Float.parseFloat(t[1].toString())) : 0);
	                    tranDto.setDeliFee(t[2] != null ? Math.round(Float.parseFloat(t[2].toString())) : 0);
	                    tranDto.setPayment(t[3] != null ? Math.round(Float.parseFloat(t[3].toString())) : 0);
	                    dto.setTransaction(tranDto);
	                }
	            } catch (Exception e) {
	                System.out.println("Transaction Fetch Error: " + e.getMessage());
	            }

	            dtoList.add(dto);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return dtoList;
	}
}


