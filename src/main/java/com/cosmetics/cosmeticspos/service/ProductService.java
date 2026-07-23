package com.cosmetics.cosmeticspos.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cosmetics.cosmeticspos.dto.HomeDto;
import com.cosmetics.cosmeticspos.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getProduct();

	int addProduct(ProductDto dto);


	int updateProduct(ProductDto dto);

	int deleteProduct(int productId);

	List<ProductDto> getProductHome(String type, int categoryId);

	ProductDto getProductDetail(int productId);

	HomeDto getHome();

	int updateProductPhoto(int productId, MultipartFile[] files);

	
}
