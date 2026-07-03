package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;

public interface ItemtransactionService {

	List<ItemtransactionDto> getItemtransaction();

	int addItemtransaction(ItemtransactionDto dto);

	int deleteItemtransaction(int itemTransactionId);

	

	int updateItemtransaction(ItemtransactionDto dto);
	
}
