package com.cosmetics.cosmeticspos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetics.cosmeticspos.dto.TransactionDto;
import com.cosmetics.cosmeticspos.service.TransactionService;

@RestController
@RequestMapping("/api/v1/")

public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("transaction")
	public List<TransactionDto> getCategory(){
		return transactionService.getTransaction();
	}
	@PostMapping("transaction")
	public TransactionDto addCategory(@RequestBody TransactionDto dto){
		
		return transactionService.addTransaction(dto);
	}
	@PutMapping("transaction")
	public TransactionDto updateCategory(@RequestBody TransactionDto dto){
		
		return transactionService.updateTransaction(dto);
	}
	@DeleteMapping("transaction/{transactionId}")
	public int deleteTransaction(@PathVariable("transactionId")int transactionId){
		
		return transactionService.deleteTransaction(transactionId);
	}


}
