package com.cosmetics.cosmeticspos.service;

import java.util.ArrayList;
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
import com.cosmetics.cosmeticspos.dto.SaleDto;   
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
		for(ItemtransactionDto itDto:dto.getItemList()) {
			itDto.setSaleId(s.getSaleId());
			Itemtransaction it = new Itemtransaction(itDto);
			itDao.addItemtransaction(it);
		}
		
		Transaction t = new Transaction(s.getSaleId(),dto.getTransaction()); 
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
	public int deleteSale(int SaleId) {
//	    SaleDto dto = new SaleDto();
//	    dto.setSaleId(SaleId); 
	    
	    Sale s= new Sale(); 
	    s.setSaleId(SaleId);
	    
	    saleDao.deleteSale(s);
	    return SaleId;
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

	

}
