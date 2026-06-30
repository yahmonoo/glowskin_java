package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.SaleDto;

public interface SaleService {

	List<SaleDto> getSale();

	int addSale(SaleDto dto);
	
	List<SaleDto> getSale(String search);

	int updateSale(SaleDto dto);

	int deleteSale(int saleId);
	

}
