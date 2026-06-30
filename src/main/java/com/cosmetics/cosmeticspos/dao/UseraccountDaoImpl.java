package com.cosmetics.cosmeticspos.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cosmetics.cosmeticspos.domain.Useraccount;
import com.cosmetics.cosmeticspos.dto.UseraccountDto;

@Repository
public class UseraccountDaoImpl  implements UseraccountDao {
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public List<UseraccountDto> getUseraccount(String userType) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		String sqlData="SELECT ua.userAccountId,ua.townshipId,t.townshipName,ua.profileName,ua.phone,ua.address,ua.userName,ua.password,ua.date,ua.userType FROM useraccount ua LEFT JOIN township t ON ua.townshipId=t.townshipId ";
		String orderClause=" ORDER BY ua.profileName ASC";
		List<Object[]> objectList=new ArrayList<>();
		if("ALL".equals(userType)) {
			objectList=session.createNativeQuery(sqlData + orderClause).getResultList();
		}else
		{
			objectList=session.createNativeQuery(sqlData + " WHERE ua.userType = ?1" + orderClause).setParameter(1, userType).getResultList();
		}
		List<UseraccountDto> userDtoList=new ArrayList<UseraccountDto>();
		for(Object[] object : objectList) {
			int userAccountId=Integer.parseInt(object[0].toString());
			int townshipId=Integer.parseInt(object[1].toString());
			String townshipName="";
			if(object[2]!=null) {
				townshipName=object[2].toString();
			}

			String profileName=object[3].toString();
		    String phone=" ";
		   if(object[4]!=null) {
			   phone=object[4].toString();
		   }
		   String address="";
		   if(object[5]!=null) {
			   address=object[5].toString();
			   
		   }
		    String userName=object[6].toString();
		    String password=object[7].toString();
		    Date date=(Date) object[8];
		    String usertype=object[9].toString();
		    
		    UseraccountDto dto=new UseraccountDto(userAccountId,townshipId,townshipName,profileName,phone,address,userName,password,date,usertype);
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


	

	
}



