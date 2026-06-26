package com.cosmetics.cosmeticspos.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SaleDaoImpl implements SaleDao{
	@Autowired
	SessionFactory sessionFactory;
}
