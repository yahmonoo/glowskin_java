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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetics.cosmeticspos.dto.ProductDto;
import com.cosmetics.cosmeticspos.service.ProductService;

@RestController
@RequestMapping("/api/v1/")

public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("product")
	public List<ProductDto> getProduct(
			//@RequestParam(name="userType",defaultValue = "p")String userType
			){
		return productService.getProduct();
	}
	@PostMapping("product")
	public int addProduct(@RequestBody ProductDto dto){
		
		return productService.addProduct(dto);
	}
	@PutMapping("product")
	public int updateProduct(@RequestBody ProductDto dto){
		
		return productService.updateProduct(dto);
	}
	@DeleteMapping("product")
	public int deleteProduct(@RequestBody ProductDto dto){
		
		return productService.deleteProduct(dto);
	}
	@GetMapping("product/home")
	public List<ProductDto> getProductHome(
			@RequestParam(name="type",defaultValue = "p")String type,//p,d,b,c // popular,discount,best seller,cateogry
			@RequestParam(name="categoryId",defaultValue = "0")int categoryId
			){
		try {
		return productService.getProductHome(type,categoryId);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("Add,Product Error!", e);
		}
	}
		@GetMapping("product/detail/{productId}")
		public ProductDto getProductDetail(@PathVariable("productId")int productId){
			try {
			return productService.getProductDetail(productId);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new RuntimeException("Add,Product Error!", e);
			}
	}
}
