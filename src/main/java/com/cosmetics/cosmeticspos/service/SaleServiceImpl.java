package com.cosmetics.cosmeticspos.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetics.cosmeticspos.dao.ItemtransactionDao;
import com.cosmetics.cosmeticspos.dao.SaleDao;
import com.cosmetics.cosmeticspos.dao.TransactionDao;
import com.cosmetics.cosmeticspos.domain.Itemtransaction;
import com.cosmetics.cosmeticspos.domain.Sale;
import com.cosmetics.cosmeticspos.domain.Transaction;
import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;
import com.cosmetics.cosmeticspos.dto.ProductDto;
import com.cosmetics.cosmeticspos.dto.SaleDto;
import com.cosmetics.cosmeticspos.dto.TransactionDto;
import com.cosmetics.cosmeticspos.dto.YearDto;
import com.infolite.dental.util.ConvertDate;   
@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleDao saleDao;
	@Autowired
	ItemtransactionDao itDao;
	@Autowired
	TransactionDao tranDao;
	@Transactional(readOnly=true)
	
	public List<SaleDto> getSale(String search) {
	    return saleDao.getSale(search);
	}

	@Transactional(readOnly=false)
	public SaleDto addSale(SaleDto dto) {
		Sale s= new Sale(dto);
		saleDao.addSale(s);
		
		//Itemtransaction it = new Itemtransaction(dto.get);
		int amount = 0;
		for(ProductDto p:dto.getProductList()) {
			
			Itemtransaction it = new Itemtransaction(p);
			it.setSaleId(s.getSaleId());
			itDao.addItemtransaction(it);
			amount+= it.getAmount();
		}
		TransactionDto tranDto = dto.getTransaction();
		tranDto.setAmount(amount);
		Transaction t = new Transaction(s.getSaleId(),tranDto); 
		tranDao.addTransaction(t);
		
		dto.setVoucherCode(s.getVoucherCode());
		dto.setSaleId(s.getSaleId());
		return dto;
	}

	@Transactional(readOnly=false)

	public int updateSale(SaleDto dto) {
		Sale s = new Sale(dto);
        saleDao.updateSale(s);
		return s.getSaleId();
	}

	@Transactional(readOnly=false)
	public int deleteSale(int saleId) {
		
		saleDao.deleteTransactionBySaleId(saleId);//
		saleDao.deleteItemTransactionBySaleId(saleId);//
		
		
	    Sale s= new Sale(); 
	    s.setSaleId(saleId);
	    saleDao.deleteSale(s);//
	    
	    
	    
	    
	    return saleId;
	}

//	@Transactional(readOnly=true)
//	
//	public List<SaleDto> getSale() {
//		// TODO Auto-generated method stub
//		List<Sale> saleList = saleDao.getSale();//
//		List<SaleDto> dtoList = new ArrayList<>();
//		for(Sale s:saleList) {
//		    SaleDto dto = new SaleDto(s);
//			dtoList.add(dto);
//		}
//		return dtoList;
	//}
	
	@Transactional(readOnly=true)
	public List<SaleDto> getSale() {
	    
		Date fromDate = new Date(0); 
	    Date toDate = new Date();   
	    
	    return saleDao.getSaleList(fromDate, toDate, 0);
	}

	@Transactional(readOnly=true)
	@Override
	public List<SaleDto> getSaleList(Date fromDate, Date toDate, int customerId) {
		// TODO Auto-generated method stub
		return saleDao.getSaleList(fromDate,toDate,customerId);
	}

	@Transactional(readOnly=true)
	@Override
	public YearDto getSaleYearReport() {
		// TODO Auto-generated method stub
		return saleDao.getSaleYearReport();
	}
	
	@Transactional(readOnly = true)
	@Override
	public YearDto getSaleAnalyticsReport(int year, int month) {
	    return saleDao.getSaleAnalyticsReport(year, month);
	}

	@Transactional(readOnly=false)
	@Override
	public SaleDto addNewSale(SaleDto dto) {
	    Sale s = new Sale();
	    
	    // Customer ID စစ်ယူခြင်း
	    if (dto.getUserAccount() != null && dto.getUserAccount().getUserAccountId() != 0) {
	        s.setCustomerId(dto.getUserAccount().getUserAccountId());
	    } else if (dto.getCustomerId() != 0) {
	        s.setCustomerId(dto.getCustomerId());
	    } else {
	        s.setCustomerId(1);
	    }

	    s.setReceivedDate(dto.getReceivedDate() != null ? dto.getReceivedDate() : new Date());
	    s.setDate(new Date());
	    s.setVoucherCode(ConvertDate.convertyymmddhhmmss(new Date()));
	    
	    saleDao.addSale(s);
	    
	    if (dto.getItemList() != null) {
	        for (ItemtransactionDto i : dto.getItemList()) {
	            Itemtransaction it = new Itemtransaction();
	            it.setSaleId(s.getSaleId()); 
	          
	            it.setProductId(i.getProductId());
	            it.setQty(i.getQty());
			    it.setUnitPrice(i.getUnitPrice());
			    it.setAmount(i.getAmount());
			    it.setDiscount(i.getDiscount());
			    it.setBalance(i.getBalance());
	
	            itDao.addItemtransaction(it);
	        }
	    }
	    
	    
	    Transaction t = new Transaction();
	    t.setSaleId(s.getSaleId());
	    
	    double paymentAmount = (dto.getTransaction() != null) ? dto.getTransaction().getPayment() : 0;
	    t.setAmount(paymentAmount);
	    t.setDeliFee(0);
	    t.setPayment(paymentAmount);
	    t.setBalance(paymentAmount);
	    t.setPaymentType("kpay");
	    t.setDate(new Date());
	    t.setModifiedDate(new Date());
	    tranDao.addTransaction(t);
	    
	    dto.setSaleId(s.getSaleId());
	    dto.setVoucherCode(s.getVoucherCode());
	    return dto;
	}

	@Transactional(readOnly = true)
	@Override
	public List<SaleDto> getSaleByUserId(int userId) {
	    
	    return saleDao.getSaleByUserId(userId);
	}

}
