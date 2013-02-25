package com.inmyshow.webbase.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


public class BaseDAOImpl<T extends Object, ID extends Serializable> implements IBaseDao<T, ID>{

	@Resource(name="sessionFactory")
	protected SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional("txManager")
	public T get(Class<T> clazz, ID id) {
		return (T)sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	@Transactional("txManager")
	public void saveOrUpdate(T object) {
		sessionFactory.getCurrentSession().saveOrUpdate(object);
	}

	@Override
	@Transactional("txManager")
	public void delete(T object) {
		sessionFactory.getCurrentSession().delete(object);
	}

}
