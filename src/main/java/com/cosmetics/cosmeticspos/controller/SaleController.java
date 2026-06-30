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

import com.cosmetics.cosmeticspos.dto.SaleDto;
import com.cosmetics.cosmeticspos.service.SaleService;


@RestController
@RequestMapping("/api/v1/")
public class SaleController {

	@Autowired
	SaleService saleService;
	
	@GetMapping("sale")
	public List<SaleDto> getSale(){
		return saleService.getSale();
	}
	@PostMapping("sale")
	public int addSale(@RequestBody SaleDto dto){
		
		return saleService.addSale(dto);
	}
	@PutMapping("sale")
	public int updateSale(@RequestBody SaleDto dto){
	    return saleService.updateSale(dto); 
	}

	@DeleteMapping("sale")
	public int deleteSale(@RequestBody SaleDto dto){
	    return saleService.deleteSale(dto.getSaleId()); 
	}
}
