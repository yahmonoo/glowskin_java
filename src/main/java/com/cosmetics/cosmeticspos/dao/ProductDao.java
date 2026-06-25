package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import com.cosmetics.cosmeticspos.domain.Product;
import com.cosmetics.cosmeticspos.dto.ProductDto;

public interface ProductDao {

	List<ProductDto> getProduct(String search);

	void addProduct(Product p);

	List<ProductDto> getProduct();

	List<ProductDto> getProductHome(String type, int categoryId);

}
