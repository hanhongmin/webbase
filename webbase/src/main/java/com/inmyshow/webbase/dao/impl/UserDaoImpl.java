package com.inmyshow.webbase.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inmyshow.webbase.dao.BaseDAOImpl;
import com.inmyshow.webbase.dao.IUserDao;
import com.inmyshow.webbase.entity.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDAOImpl<User, Long> implements IUserDao{
	
	@Transactional("txManager")
	public User getABCD(Long id){
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}
	
}
