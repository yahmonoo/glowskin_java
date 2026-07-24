package com.cosmetics.cosmeticspos.dao;

import java.util.Date;
import java.util.List;

import com.cosmetics.cosmeticspos.domain.Sale;
import com.cosmetics.cosmeticspos.dto.SaleDto;
import com.cosmetics.cosmeticspos.dto.YearDto;

public interface SaleDao {

	void addSale(Sale s);

	void getCity(String search);

	void updateSale(Sale s);

	void deleteSale(Sale s);

	List<Sale> getSale();

	List<SaleDto> getSale(String search);

	List<SaleDto> getSaleList(Date fromDate, Date toDate, int customerId);

	YearDto getSaleYearReport();

	void deleteTransactionBySaleId(int saleId);

	void deleteItemTransactionBySaleId(int saleId);


}
