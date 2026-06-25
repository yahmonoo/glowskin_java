package com.cosmetics.cosmeticspos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cosmetics.cosmeticspos.dao.ItemtransactionDao;
import com.cosmetics.cosmeticspos.domain.Itemtransaction;
import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;

@Service
public class ItemtransactionServiceImpl implements ItemtransactionService {
	@Autowired
	ItemtransactionDao itemtransactionDao;
	

	@Transactional(readOnly=true)
	@Override
	public List<ItemtransactionDto> getItemtransaction() {
		return itemtransactionDao.getItemtransaction();
		
	}

	@Transactional(readOnly=false)
	@Override
	public int addItemtransaction(ItemtransactionDto dto) {
		Itemtransaction i = new Itemtransaction(dto);
		itemtransactionDao.addItemtransaction(i);
		return i.getItemTransactionId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateItemtransaction(ItemtransactionDto dto) {
		Itemtransaction i = new Itemtransaction(dto);
		itemtransactionDao.updateItemtransaction(i);
		return i.getItemTransactionId();
		
	}

	

	@Transactional(readOnly=false)
	@Override
	public int deleteItemtransaction(int itemTransactionId) {
		Itemtransaction i = new Itemtransaction();
		i.setItemTransactionId(itemTransactionId);
		itemtransactionDao.deleteItemtransaction(i);
		return itemTransactionId;
	}

	

}
