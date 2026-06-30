package com.cosmetics.cosmeticspos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cosmetics.cosmeticspos.dao.SaleDao;
import com.cosmetics.cosmeticspos.domain.Sale;
import com.cosmetics.cosmeticspos.dto.SaleDto;   
@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleDao saleDao;
	
	@Transactional(readOnly=true)
	
	public List<SaleDto> getSale(String search) {
	    return saleDao.getSale(search);
	}

	@Transactional(readOnly=false)
	public int addSale(SaleDto dto) {
		Sale s= new Sale(dto);
		saleDao.addSale(s);
		return s.getSaleId();
	}

	@Transactional(readOnly=false)

	public int updateSale(SaleDto dto) {
		Sale s = new Sale(dto);
        saleDao.updateSale(s);
		return s.getSaleId();
	}

	@Transactional(readOnly=false)
	public int deleteSale(int SaleId) {
	    SaleDto dto = new SaleDto();
	    dto.setSaleId(SaleId); 
	    
	    Sale s= new Sale(dto); 
	    
	    saleDao.deleteSale(s);
	    return SaleId;
	}

	@Transactional(readOnly=true)
	
	public List<SaleDto> getSale() {
		// TODO Auto-generated method stub
		List<Sale> saleList = saleDao.getSale();
		List<SaleDto> dtoList = new ArrayList<>();
		for(Sale s:saleList) {
		    SaleDto dto = new SaleDto(s);
			dtoList.add(dto);
		}
		return dtoList;
	}

	

}
