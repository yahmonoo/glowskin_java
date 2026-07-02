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
		Session session = sessionFactory.getCurrentSession();
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
		String sqlWhere = " Where 1=1 ";
		String sqlOrderBy = "";
		if("p".equals(type)) {
			sqlWhere += " AND p.rating>0  ";
			sqlOrderBy = " order by p.rating DESC  ";
//			objList = session.createNativeQuery("SELECT p.photoOne,\r\n"
//					+ "p.title,p.`code`,p.priceOne\r\n"
//					+ "FROM product p where p.rating>0 order by p.rating DESC ").getResultList();//rating 
		}else if("d".equals(type)) {
			sqlWhere += " AND p.discountPriceOne>0  ";
			sqlOrderBy = " order by p.discountPriceOne DESC  ";
//			objList = session.createNativeQuery("SELECT p.photoOne,\r\n"
//					+ "p.title,p.`code`,p.priceOne\r\n"
//					+ "FROM product p where p.discountPriceOne>0").getResultList();
		}else if("b".equals(type)) {
			sqlWhere += " AND p.type=1  ";
			sqlOrderBy = " order by p.title ASC  ";
//			objList = session.createNativeQuery("SELECT p.photoOne,\r\n"
//					+ "p.title,p.`code`,p.priceOne\r\n"
//					+ "FROM product p where p.type=1 ").getResultList();
		}else {//c
			if(categoryId>0) {
				sqlWhere += " AND  p.categoryId = "+categoryId;
			}
			sqlOrderBy = " order by p.title ASC  ";
//			objList = session.createNativeQuery("SELECT p.priceOne,p.title ,p.`code`, p.photoOne\r\n"
//					+ "FROM product p\r\n"
//					+ sqlWhere
//					+ "  order by p.title ASC\r\n")
//					.getResultList();
		}
		
		objList = session.createNativeQuery("SELECT p.priceOne,p.title ,p.`code`, p.photoOne,p.rating\r\n"
				+ "FROM product p\r\n"
				+ sqlWhere
				+ sqlOrderBy)
				.getResultList();
		List<ProductDto> dtoList = new ArrayList<>();

		for(Object[] obj:objList) {
			int priceOne = Integer.parseInt(obj[0].toString());
			
			String title = (String)obj[1];
			String code = (String)obj[2];
			String photoOne = (String)obj[3];
//			int rating = Integer.parseInt(obj[4].toString());
			int rating = (int) Double.parseDouble(obj[4].toString());
			ProductDto dto = new ProductDto(photoOne,title,code,priceOne,rating);
			dtoList.add(dto);
		}
		
		
		return dtoList;
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getProductDetail(int productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.find(Product.class, productId);
	}

	
}
