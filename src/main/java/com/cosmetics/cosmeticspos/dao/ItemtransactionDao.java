package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Itemtransaction;
import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;

public interface ItemtransactionDao {

//	 List<ItemtransactionDto> getItemtransaction(String search);

	void addItemtransaction(Itemtransaction i);

	List<ItemtransactionDto> getItemtransaction();

	void updateItemtransaction(Itemtransaction i);

	void deleteItemtransaction(Itemtransaction i);

}
