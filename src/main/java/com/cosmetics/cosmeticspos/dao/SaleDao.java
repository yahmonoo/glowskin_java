package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Sale;
import com.cosmetics.cosmeticspos.dto.SaleDto;

public interface SaleDao {

	void addSale(Sale s);

	void getCity(String search);

	void updateSale(Sale s);

	void deleteSale(Sale s);

	List<Sale> getSale();

	List<SaleDto> getSale(String search);


}
