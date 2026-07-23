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

import com.cosmetics.cosmeticspos.domain.Useraccount;
import com.cosmetics.cosmeticspos.dto.CityDto;
import com.cosmetics.cosmeticspos.dto.UseraccountDto;
import com.infolite.dental.util.ConvertDate;

@Repository
public class UseraccountDaoImpl  implements UseraccountDao {
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public List<UseraccountDto> getUseraccount(String userType) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		String sqlData="SELECT ua.userAccountId,ua.townshipId,t.townshipName,ua.profileName,ua.phone,ua.address,ua.userName,ua.password,ua.date,ua.userType,ua.photo FROM useraccount ua LEFT JOIN township t ON ua.townshipId=t.townshipId ";
		String orderClause=" ORDER BY ua.profileName ASC";
		List<Object[]> objectList=new ArrayList<>();
		if("ALL".equals(userType)) {
			objectList=session.createNativeQuery(sqlData + orderClause).getResultList();
		}else
		{
			objectList=session.createNativeQuery(sqlData + " WHERE ua.userType = :userType " + orderClause).setParameter("userType", userType).getResultList();
		}
		List<UseraccountDto> userDtoList=new ArrayList<UseraccountDto>();
		for(Object[] object : objectList) {
			int userAccountId=Integer.parseInt(object[0].toString());
			int townshipId=Integer.parseInt(object[1].toString());
			String townshipName= (String)object[2];

			String profileName=object[3].toString();
		    String phone= (String)object[4];

		   String address=(String)object[5];
		    String userName=object[6].toString();
		    String password=object[7].toString();
		    Date date=(Date) object[8];
		    String usertype=object[9].toString();
		    String photo= (String)object[10];
		    UseraccountDto dto=new UseraccountDto(userAccountId,townshipId,townshipName,profileName,phone,address,userName,password,date,usertype,photo,new CityDto());
		    userDtoList.add(dto);

		}
		return userDtoList;
		

	}

	@Override
	public void addUseraccount(Useraccount ua) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(ua);
		
	}

	@Override
	public void updateUseraccount(Useraccount ua) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(ua);
		
	}

	@Override
	public void deleteUseraccount(int userAccountId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql="DELETE FROM useraccount WHERE userAccountId= ?1";
		session.createNativeQuery(sql).setParameter(1, userAccountId).executeUpdate();
		
	}

	@Override
	public Useraccount getLogin(String userName, String password) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<Useraccount> userList = session.createQuery("select u from Useraccount u where "
				+ " u.userName = :userName AND u.password = :password ")
		.setParameter("userName", userName)
		.setParameter("password", password).getResultList();
		Useraccount ua = new Useraccount();
		if(userList.size()>0) {
			ua = userList.get(0);
		}
		return ua;
	}

	@Override
	public int updateProductPhoto(int userAccountId, MultipartFile file) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Useraccount ua= session.find(Useraccount.class, userAccountId);
		String pwd=new File("").getAbsolutePath();
		if(ua.getPhoto()!=null) {
			File deleteFile=new File(pwd+"/userphoto/"+ua.getPhoto());//+".png"
			deleteFile.delete();
		}
		String photoCode= ConvertDate.createVoucherCode(new Date(), userAccountId);
		ua.setPhoto(photoCode+".png");
		File dir=new File(pwd+"/userphoto/");
		String outPath=pwd+"/userphoto/"+photoCode+".png";
		File dest=new File(outPath);
		try {
			if (!dir.exists()) {
				dir.mkdir();
			}
			file.transferTo(dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userAccountId;
	}

	@Override
	public UseraccountDto getUseraccountById(int userAccountId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<Object[]> objList = session.createNativeQuery("SELECT ua.userAccountId,ua.phone,\r\n"
				+ "ua.address,c.cityId,c.cityName,ts.townshipId,ts.townshipName,ua.photo\r\n"
				+ "FROM useraccount ua\r\n"
				+ "LEFT JOIN township ts ON ts.townshipId = ua.townshipId\r\n"
				+ "LEFT JOIN city c ON c.cityId  = ts.cityId\r\n"
				+ " Where ua.userAccountId=:userAccountId")
				.setParameter("userAccountId", userAccountId).getResultList();
		UseraccountDto dto = new UseraccountDto();
		if(objList.size()>0) {
			Object[] obj = objList.get(0);
			int userId = Integer.parseInt(obj[0].toString());
			String phone = (String)obj[1];
			String address = (String)obj[2];
			int cityId = Integer.parseInt(obj[3].toString());
			String cityName = (String)obj[4];
			int tsId = Integer.parseInt(obj[5].toString());
			String tsName = (String)obj[6];
			String photo = (String)obj[7];
			dto.setUserAccountId(userAccountId);
			dto.setPhone(phone);
			dto.setAddress(address);
			dto.setTownshipId(tsId);
			dto.setTownshipName(tsName);
			dto.setCityDto(new CityDto(cityId,cityName));
			dto.setPhoto(photo);
		}
		return dto;
	}


	

	
}



