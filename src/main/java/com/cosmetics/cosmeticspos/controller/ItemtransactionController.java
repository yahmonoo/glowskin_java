package com.cosmetics.cosmeticspos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetics.cosmeticspos.dto.CategoryDto;
import com.cosmetics.cosmeticspos.dto.ItemtransactionDto;
import com.cosmetics.cosmeticspos.service.CategoryService;
import com.cosmetics.cosmeticspos.service.ItemtransactionService;

@RestController
@RequestMapping("/api/v1/")

public class ItemtransactionController {

	@Autowired
	ItemtransactionService itemtransactionService;
	
	@GetMapping("itemtransaction")
	public List<ItemtransactionDto> getItemtransaction(){
		return itemtransactionService.getItemtransaction();
	}
	@PostMapping("itemtransaction")
	public int addItemtransaction(@RequestBody ItemtransactionDto dto){
		
		return itemtransactionService.addItemtransaction(dto);
	}
	@PutMapping("itemtransaction")
	public int updateItemtransaction(@RequestBody ItemtransactionDto dto){
		
		return itemtransactionService.updateItemtransaction(dto);
	}
	@DeleteMapping("itemtransaction")
	public int deleteItemtransaction(@RequestBody ItemtransactionDto dto){
		
		return itemtransactionService.addItemtransaction(dto);
	}

}
