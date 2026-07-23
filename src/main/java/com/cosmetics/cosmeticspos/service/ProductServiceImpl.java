package com.cosmetics.cosmeticspos.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetics.cosmeticspos.dao.ProductDao;
import com.cosmetics.cosmeticspos.domain.City;
import com.cosmetics.cosmeticspos.domain.Product;
import com.cosmetics.cosmeticspos.dto.HomeDto;
import com.cosmetics.cosmeticspos.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	@Transactional(readOnly=true)
	@Override
	public List<ProductDto> getProduct() {
		// TODO Auto-generated method stub
		return productDao.getProduct();
	}
	
	@Transactional
	@Override
	public int addProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		Product p = new Product(dto); 
	    productDao.addProduct(p);
	    return p.getProductId();
	}

	@Transactional(readOnly=false)
	@Override
	public int updateProduct(ProductDto dto) {
		// TODO Auto-generated method stub
		Product p = new Product(dto);//
		productDao.updateProduct(p);
		return p.getProductId();
	}

	@Transactional(readOnly=false)
	@Override
	public int deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setProductId(productId);
		productDao.deleteProduct(p);
		return productId;
	}
	
	

	@Transactional(readOnly=true)
	@Override
	public List<ProductDto> getProductHome(String type, int categoryId) {
		// TODO Auto-generated method stub
		return productDao.getProductHome(type,categoryId);
	}

	@Transactional(readOnly=true)
	@Override
	public ProductDto getProductDetail(int productId) {
		// TODO Auto-generated method stub
		Product p = productDao.getProductDetail(productId);
		ProductDto dto 	= new ProductDto(p);//
		return dto;//productDao.getProductDetail(productId);
	}

	@Transactional(readOnly=true)
	@Override
	public HomeDto getHome() {
		// TODO Auto-generated method stub
		return productDao.getHome();
	}
	
	@Transactional(readOnly = false)
	@Override
	public int updateProductPhoto(int productId, MultipartFile[] files) {
	    return productDao.updateProductPhoto(productId, files);
	}

	
}
