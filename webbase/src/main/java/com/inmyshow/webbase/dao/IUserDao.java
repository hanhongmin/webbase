package com.inmyshow.webbase.dao;

import com.inmyshow.webbase.entity.User;


public interface IUserDao extends IBaseDao<User,Long> {
	public User getABCD(Long id);

}
