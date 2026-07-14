package com.cosmetics.cosmeticspos.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetics.cosmeticspos.domain.Product;
import com.cosmetics.cosmeticspos.dto.CategoryDto;
import com.cosmetics.cosmeticspos.dto.HomeDto;
import com.cosmetics.cosmeticspos.dto.ProductDto;
import com.infolite.dental.util.ConvertDate;


@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<ProductDto> getProduct(String search) {
		// TODO Auto-generated method stub
		//a
		return null;
	}

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(p);
	}

	@Override
	public List<ProductDto> getProduct() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = new ArrayList<>();
		String sqlWhere = " Where 1=1 ";
		String sqlOrderBy = "";
		
		
		objList = session.createNativeQuery("SELECT p.priceOne,p.title ,p.`code`, p.photoOne,p.rating,p.productId,p.categoryId,\r\n"
				+ "p.discountPriceOne,p.normalPriceOne,p.percent, c.`name` AS categoryName,p.detail,p.colorBox,p.type,p.colorOne,p.colorTwo,p.colorThree,p.colorFour\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN category c ON p.categoryId = c.categoryId\r\n"
				+ sqlWhere
				+ sqlOrderBy)
				.getResultList();
		List<ProductDto> dtoList = new ArrayList<>();

		for(Object[] obj:objList) {
			int priceOne = Integer.parseInt(obj[0].toString());
			
			String title = (String)obj[1];
			String code = (String)obj[2];
			String photoOne = (String)obj[3];
			//int rating = Integer.parseInt(obj[4].toString());
			int rating = (int) Double.parseDouble(obj[4].toString());
			int productId = Integer.parseInt(obj[5].toString());
			int categoryId = Integer.parseInt(obj[6].toString());
			int discountPriceOne = Integer.parseInt(obj[7].toString());
			int normalPriceOne = Integer.parseInt(obj[8].toString());
			int percent = Integer.parseInt(obj[9].toString());
			String categoryName = (String)obj[10];
			String detail = (String)obj[11];
//			String colorBox = (String)obj[12];
			int colorBox=Integer.parseInt(obj[12].toString());
			int type=Integer.parseInt(obj[13].toString());
			String colorOne = (String)obj[14];
			String colorTwo = (String)obj[15];
			String colorThree = (String)obj[16];
			String colorFour = (String)obj[17];
		
			ProductDto dto = new ProductDto(photoOne,title,code,priceOne,rating);
			
			dto.setProductId(productId);
			dto.setDiscountPriceOne(discountPriceOne);
			dto.setNormalPriceOne(normalPriceOne);
			dto.setPercent(percent);
			dto.setDetail(detail);
			dto.setColorBox(colorBox);
			
		    dto.setColorOne(colorOne);
		    dto.setColorTwo(colorTwo);
		    dto.setColorThree(colorThree);
		    dto.setColorFour(colorFour);
			dto.setType(type);
			
			dto.setCategorydto(new CategoryDto(categoryId,categoryName));
			dtoList.add(dto);
		}
		
		
		return dtoList;
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
		
		objList = session.createNativeQuery("SELECT p.priceOne,p.title ,p.`code`, p.photoOne,p.rating,p.productId,p.categoryId,\r\n"
				+ "p.discountPriceOne,p.normalPriceOne,p.percent, c.`name` AS categoryName\r\n"
				+ "FROM product p\r\n"
				+ "LEFT JOIN category c ON p.categoryId = c.categoryId\r\n"
				+ sqlWhere
				+ sqlOrderBy)
				.getResultList();
		List<ProductDto> dtoList = new ArrayList<>();

		for(Object[] obj:objList) {
			int priceOne = Integer.parseInt(obj[0].toString());
			
			String title = (String)obj[1];
			String code = (String)obj[2];
			String photoOne = (String)obj[3];
			//int rating = Integer.parseInt(obj[4].toString());
			int rating = (int) Double.parseDouble(obj[4].toString());
			int productId = Integer.parseInt(obj[5].toString());
			categoryId = Integer.parseInt(obj[6].toString());
			int discountPriceOne = Integer.parseInt(obj[7].toString());
			int normalPriceOne = Integer.parseInt(obj[8].toString());
			int percent = Integer.parseInt(obj[9].toString());
			String categoryName = (String)obj[10];

			ProductDto dto = new ProductDto(photoOne,title,code,priceOne,rating);
			
			dto.setProductId(productId);
			dto.setDiscountPriceOne(discountPriceOne);
			dto.setNormalPriceOne(normalPriceOne);
			dto.setPercent(percent);
			
			dto.setCategorydto(new CategoryDto(categoryId,categoryName));
			dtoList.add(dto);
		}
		
		
		return dtoList;
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
		
	}

	@Override
	public Product getProductDetail(int productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.find(Product.class, productId);
	}

	@Override
	public void deleteProduct(Product p) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		 session.createQuery("DELETE FROM Product WHERE productId= :productId")
			.setParameter("productId",p.getProductId())
			.executeUpdate();	
	}

	@Override
	public HomeDto getHome() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT SUM(t.payment),COUNT(s.saleId)\r\n"
				+ "FROM sale s\r\n"
				+ "LEFT JOIN transaction t ON t.saleId = s.saleId\r\n"
				+ "WHERE DATE(receivedDate) = CURRENT_DATE() ").getResultList();
		HomeDto dto = new HomeDto();
		if(objList.size()>0) {
			Object[] obj = objList.get(0);
			int payment = Integer.parseInt(obj[0].toString());
			int orderCount = Integer.parseInt(obj[1].toString());
			dto.setSaleAmount(payment);
			dto.setOrderCount(orderCount);
		}
		objList = session.createNativeQuery("SELECT COUNT(ua.userAccountId),0 as indexone FROM useraccount ua ").getResultList();
		if(objList.size()>0) {
			Object[] obj = objList.get(0);
			int userCount = Integer.parseInt(obj[0].toString());
			dto.setMemberCount(userCount);
		}
		objList = session.createNativeQuery("SELECT COUNT(p.productId),0 as indexone FROM product p").getResultList();
		if(objList.size()>0) {
			Object[] obj = objList.get(0);
			int itemCount = Integer.parseInt(obj[0].toString());
			dto.setItemCount(itemCount);
		}
		return dto;
	}

	@Override
	public int updateProductPhoto(int productId, MultipartFile file) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Product p= session.find(Product.class, productId);
//		String pwd=new File("").getAbsolutePath();
//		if(p.getPhoto()!=null) {
//			File deleteFile=new File(pwd+"/productphoto/"+p.getPhoto()+".png");
//			deleteFile.delete();
//		}
//		String photoCode= ConvertDate.createVoucherCode(new Date(), productId);
//		p.setPhoto(photoCode);
//		session.createNativeQuery(" UPDATE product p SET p.photo=:photoCode WHERE  p.productId=:productId ")
//		.setParameter("photoCode", photoCode)
//		.setParameter("productId", productId).executeUpdate();
//		File dir=new File(pwd+"/productphoto/");
//		String outPath=pwd+"/productphoto/"+photoCode+".png";
//		File dest=new File(outPath);
//		try {
//			if (!dir.exists()) {
//				dir.mkdir();
//			}
//			file.transferTo(dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return productId;
	}

	
}
