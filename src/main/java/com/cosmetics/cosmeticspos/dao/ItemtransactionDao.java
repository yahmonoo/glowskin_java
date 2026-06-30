package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Itemtransaction;
import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;

public interface ItemtransactionDao {

//	 List<ItemtransactionDto> getItemtransaction(String search);

	void addItemtransaction(Itemtransaction item);

	List<Itemtransaction> getItemtransaction();

	void updateItemtransaction(Itemtransaction item);

	void deleteItemtransaction(Itemtransaction item);

}
