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

	@Transactional(readOnly=true)
	
	public List<SaleDto> getSale() {
		// TODO Auto-generated method stub
		List<Sale> saleList = saleDao.getSale();//
		List<SaleDto> dtoList = new ArrayList<>();
		for(Sale s:saleList) {
		    SaleDto dto = new SaleDto(s);
			dtoList.add(dto);
		}
		return dtoList;
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

	

}
