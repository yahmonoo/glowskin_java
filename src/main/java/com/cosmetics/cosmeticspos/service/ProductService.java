package com.cosmetics.cosmeticspos.service;

import java.util.List;

import com.cosmetics.cosmeticspos.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getProduct();

	int addProduct(ProductDto dto);


	int updateProduct(ProductDto dto);

	int deleteProduct(ProductDto dto);

	List<ProductDto> getProductHome(String type, int categoryId);

	ProductDto getProductDetail(int productId);

	


	
}
