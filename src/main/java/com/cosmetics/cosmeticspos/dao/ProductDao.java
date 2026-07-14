package com.cosmetics.cosmeticspos.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cosmetics.cosmeticspos.domain.Product;
import com.cosmetics.cosmeticspos.dto.HomeDto;
import com.cosmetics.cosmeticspos.dto.ProductDto;

public interface ProductDao {

	List<ProductDto> getProduct(String search);

	void addProduct(Product p);

	List<ProductDto> getProduct();

	List<ProductDto> getProductHome(String type, int categoryId);

	void updateProduct(Product p);

	Product getProductDetail(int productId);

	void deleteProduct(Product p);

	HomeDto getHome();

	int updateProductPhoto(int productId, MultipartFile file);

}
