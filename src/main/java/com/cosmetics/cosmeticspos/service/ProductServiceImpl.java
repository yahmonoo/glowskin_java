package com.cosmetics.cosmeticspos.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetics.cosmeticspos.dao.ProductDao;
import com.cosmetics.cosmeticspos.domain.Product;
import com.cosmetics.cosmeticspos.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	
	public List<ProductDto> getProduct(String search) {
		// TODO Auto-generated method stub
		return productDao.getProduct(search);
	}

	@Override
	public int addProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		Product p = new Product(dto);
		productDao.addProduct(p);
		return p.getProductId();
	}

	@Override
	public int updateProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		Product p = new Product(dto);//
		productDao.updateProduct(p);
		return p.getProductId();
	}

	@Override
	public int deleteProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Transactional(readOnly=true)
	@Override
	public List<ProductDto> getProduct() {
		// TODO Auto-generated method stub
		return productDao.getProduct();
	}

	@Transactional(readOnly=true)
	@Override
	public List<ProductDto> getProductHome(String type, int categoryId) {
		// TODO Auto-generated method stub
		return productDao.getProductHome(type,categoryId);
	}

	@Override
	public ProductDto getProductDetail(int productId) {
		// TODO Auto-generated method stub
		Product pro = productDao.getProductDetail(productId);
		ProductDto dto 	= new ProductDto(pro);//
		return dto;//productDao.getProductDetail(productId);
	}


}
