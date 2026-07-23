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
	    Session session = sessionFactory.getCurrentSession();
	    List<Object[]> objList = new ArrayList<>();
	    String sqlWhere = " Where 1=1 ";
	    String sqlOrderBy = "";
	    
	 
	    objList = session.createNativeQuery("SELECT p.priceOne, p.title, p.`code`, p.photoOne, p.rating, p.productId, p.categoryId,\r\n"
	            + "p.discountPriceOne, p.normalPriceOne, p.percent, c.`name` AS categoryName, p.detail, p.colorBox, p.type, p.colorOne, p.colorTwo, p.colorThree, p.colorFour,\r\n"
	            + "p.photoTwo, p.photoThree, p.photoFour\r\n"
	            + "FROM product p\r\n"
	            + "LEFT JOIN category c ON p.categoryId = c.categoryId\r\n"
	            + sqlWhere
	            + sqlOrderBy)
	            .getResultList();
	            
	    List<ProductDto> dtoList = new ArrayList<>();

	    for(Object[] obj : objList) {
	        int priceOne = Integer.parseInt(obj[0].toString());
	        String title = (String)obj[1];
	        String code = (String)obj[2];
	        String photoOne = (String)obj[3];
	        int rating = (int) Double.parseDouble(obj[4].toString());
	        int productId = Integer.parseInt(obj[5].toString());
	        int categoryId = Integer.parseInt(obj[6].toString());
	        int discountPriceOne = Integer.parseInt(obj[7].toString());
	        int normalPriceOne = Integer.parseInt(obj[8].toString());
	        int percent = Integer.parseInt(obj[9].toString());
	        String categoryName = (String)obj[10];
	        String detail = (String)obj[11];
	        int colorBox = Integer.parseInt(obj[12].toString());
	        int type = Integer.parseInt(obj[13].toString());
	        String colorOne = (String)obj[14];
	        String colorTwo = (String)obj[15];
	        String colorThree = (String)obj[16];
	        String colorFour = (String)obj[17];
	        
	       
	        String photoTwo = (String)obj[18];
	        String photoThree = (String)obj[19];
	        String photoFour = (String)obj[20];
	    
	        ProductDto dto = new ProductDto(photoOne, title, code, priceOne, rating);
	        
	        dto.setProductId(productId);
	        dto.setDiscountPriceOne(discountPriceOne);
	        dto.setNormalPriceOne(normalPriceOne);
	        dto.setPercent(percent);
	        dto.setDetail(detail);
	        dto.setColorBox(colorBox);
	        dto.setPhotoTwo(photoTwo);
	        dto.setPhotoThree(photoThree);
	        dto.setPhotoFour(photoFour);

	        dto.setColorOne(colorOne);
	        dto.setColorTwo(colorTwo);
	        dto.setColorThree(colorThree);
	        dto.setColorFour(colorFour);
	        dto.setType(type);
	        
	        dto.setCategorydto(new CategoryDto(categoryId, categoryName));
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
				+ "p.discountPriceOne,p.normalPriceOne,p.percent, c.`name` AS categoryName,p.sizeOne\r\n"
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
			int sizeOne = Integer.parseInt(obj[11].toString());
			ProductDto dto = new ProductDto(photoOne,title,code,priceOne,rating);
			
			dto.setProductId(productId);
			dto.setDiscountPriceOne(discountPriceOne);
			dto.setNormalPriceOne(normalPriceOne);
			dto.setPercent(percent);
			dto.setSizeOne(sizeOne);
			
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
//		if(objList.size()>0) {
//			Object[] obj = objList.get(0);
//			int payment = Integer.parseInt(obj[0].toString());
//			int orderCount = Integer.parseInt(obj[1].toString());
//			dto.setSaleAmount(payment);
//			dto.setOrderCount(orderCount);
//		}
//		objList = session.createNativeQuery("SELECT COUNT(ua.userAccountId),0 as indexone FROM useraccount ua ").getResultList();
//		if(objList.size()>0) {
//			Object[] obj = objList.get(0);
//			int userCount = Integer.parseInt(obj[0].toString());
//			dto.setMemberCount(userCount);
//		}
//		objList = session.createNativeQuery("SELECT COUNT(p.productId),0 as indexone FROM product p").getResultList();
//		if(objList.size()>0) {
//			Object[] obj = objList.get(0);
//			int itemCount = Integer.parseInt(obj[0].toString());
//			dto.setItemCount(itemCount);
//		}
//		return dto;
//	}
		if(objList.size() > 0 && objList.get(0) != null) {
			Object[] obj = objList.get(0);
			
			String paymentStr = (obj[0] != null) ? obj[0].toString() : "0";
			String orderCountStr = (obj[1] != null) ? obj[1].toString() : "0";
			
			int payment = Integer.parseInt(paymentStr);
			int orderCount = Integer.parseInt(orderCountStr);
			
			dto.setSaleAmount(payment);
			dto.setOrderCount(orderCount);
		}
		
		
		objList = session.createNativeQuery("SELECT COUNT(ua.userAccountId),0 as indexone FROM useraccount ua ").getResultList();
		if(objList.size() > 0 && objList.get(0) != null) {
			Object[] obj = objList.get(0);
			String userCountStr = (obj[0] != null) ? obj[0].toString() : "0";
			int userCount = Integer.parseInt(userCountStr);
			dto.setMemberCount(userCount);
		}
		
		objList = session.createNativeQuery("SELECT COUNT(p.productId),0 as indexone FROM product p").getResultList();
		if(objList.size() > 0 && objList.get(0) != null) {
			Object[] obj = objList.get(0);
			String itemCountStr = (obj[0] != null) ? obj[0].toString() : "0";
			int itemCount = Integer.parseInt(itemCountStr);
			dto.setItemCount(itemCount);
		}
		
		return dto;
	}

	

	@Override
	public int updateProductPhoto(int productId, MultipartFile[] files) {
	    Session session = sessionFactory.getCurrentSession();
	    Product p = session.find(Product.class, productId);

	    if (p == null || files == null || files.length == 0) {
	        return productId;
	    }

	    String pwd = new File("").getAbsolutePath();
	    File dir = new File(pwd + "/productphoto/");
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }

	    	for (int i = 0; i < files.length && i < 4; i++) {
	        MultipartFile file = files[i];
	        if (file != null && !file.isEmpty()) {
	            
	            String fileName = System.currentTimeMillis() + "_" + java.util.UUID.randomUUID().toString().substring(0, 5) + "_" + (i + 1) + ".jpg";
	            File dest = new File(pwd + "/productphoto/" + fileName);
	            
	            try {
	                file.transferTo(dest);
	                
	                if (i == 0) p.setPhotoOne(fileName);
	                if (i == 1) p.setPhotoTwo(fileName);
	                if (i == 2) p.setPhotoThree(fileName);
	                if (i == 3) p.setPhotoFour(fileName);

	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    session.update(p);
	    return productId;
	}
}
