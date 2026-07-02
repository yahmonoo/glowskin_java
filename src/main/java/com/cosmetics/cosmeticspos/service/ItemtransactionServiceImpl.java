package com.cosmetics.cosmeticspos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cosmetics.cosmeticspos.dao.ItemtransactionDao;
import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.domain.Itemtransaction;
import com.cosmetics.cosmeticspos.domain.Product;
import com.cosmetics.cosmeticspos.dto.CityDto;
import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;
import com.cosmetics.cosmeticspos.dto.ProductDto;

@Service
public class ItemtransactionServiceImpl implements ItemtransactionService {
	@Autowired
	ItemtransactionDao itemtransactionDao;
	public List<Itemtransaction> getItemtransaction(String search) {
		// TODO Auto-generated method stub
		return itemtransactionDao.getItemtransaction();
	}

//	@Transactional(readOnly=true)
//	@Override
//	public List<ItemtransactionDto> getItemtransaction() {
//		List<Itemtransaction> itemtransactionList = itemtransactionDao.getItemtransaction();
//		List<ItemtransactionDto> dtoList = new ArrayList<>();
//		for(Itemtransaction item:itemtransactionList) {
//			ItemtransactionDto dto = new ItemtransactionDto(item);
//			dtoList.add(dto);
//		}
//		return dtoList;	
//	}

	@Transactional(readOnly=false)
	@Override
	public int addItemtransaction(ItemtransactionDto dto) {
		// TODO Auto-generated method stub
		Itemtransaction i = new Itemtransaction(dto);
		itemtransactionDao.addItemtransaction(i);
		return i.getItemTransactionId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateItemtransaction(ItemtransactionDto dto) {
		// TODO Auto-generated method stub
		Itemtransaction i = new Itemtransaction(dto);
		itemtransactionDao.updateItemtransaction(i);
		return i.getItemTransactionId();
		
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteItemtransaction(int itemTransactionId) {
		// TODO Auto-generated method stub
		Itemtransaction i = new Itemtransaction();
		i.setItemTransactionId(itemTransactionId);
		itemtransactionDao.deleteItemtransaction(i);
		return itemTransactionId;
	}

	@Override
	public List<ItemtransactionDto> getItemtransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
