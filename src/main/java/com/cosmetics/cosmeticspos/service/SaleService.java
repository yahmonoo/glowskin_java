package com.cosmetics.cosmeticspos.service;

import java.util.Date;
import java.util.List;

import com.cosmetics.cosmeticspos.dto.SaleDto;
import com.cosmetics.cosmeticspos.dto.YearDto;

public interface SaleService {

	List<SaleDto> getSale();

	SaleDto addSale(SaleDto dto);
	
	List<SaleDto> getSale(String search);

	int updateSale(SaleDto dto);

	int deleteSale(int saleId);

	List<SaleDto> getSaleList(Date fromDate, Date toDate, int customerId);

	YearDto getSaleYearReport();
	

}
