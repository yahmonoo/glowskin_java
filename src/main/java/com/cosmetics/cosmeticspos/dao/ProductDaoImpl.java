package com.cosmetics.cosmeticspos.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Product;
import com.cosmetics.cosmeticspos.dto.ProductDto;


@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<ProductDto> getProduct(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDto> getProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getProductHome(String type, int categoryId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = new ArrayList<>();
		if("p".equals(type)) {
			objList = session.createNativeQuery("SELECT p.photoOne,\r\n"
					+ "p.title,p.`code`,p.priceOne\r\n"
					+ "FROM product p where p.rating>0 order by p.rating DESC ").getResultList();//rating 
		}else if("d".equals(type)) {
			objList = session.createNativeQuery("SELECT p.photoOne,\r\n"
					+ "p.title,p.`code`,p.priceOne\r\n"
					+ "FROM product p where p.discountPriceOne>0").getResultList();
		}else if("b".equals(type)) {
			objList = session.createNativeQuery("SELECT p.photoOne,\r\n"
					+ "p.title,p.`code`,p.priceOne\r\n"
					+ "FROM product p where p.type=1 ").getResultList();
		}else {//c
			objList = session.createNativeQuery("SELECT p.priceOne,p.title ,p.`code`, p.photoOne\r\n"
					+ "FROM product p\r\n"
					+ "WHERE p.categoryId = :categoryId\r\n")
					.setParameter("categoryId", categoryId)
					.getResultList();
		}
		
		List<ProductDto> dtoList = new ArrayList<>();

		for(Object[] obj:objList) {
			
			String photoOne = (String)obj[0];
			String title = (String)obj[1];
			String code = (String)obj[2];
			int priceOne = Integer.parseInt(obj[3].toString());
			
			ProductDto dto = new ProductDto(photoOne,title,code,priceOne);
			dtoList.add(dto);
		}
		
		
		return dtoList;
	}

	
}
