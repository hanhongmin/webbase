package com.inmyshow.webbase.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
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

	@Override
	@SuppressWarnings("rawtypes")
	public List<T> findByCriteria(DetachedCriteria dc) {
		Criteria c = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
		return c.list();
	}

	@Override
	public Long getRowCount(DetachedCriteria dc) {
		Criteria c = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
		Object o = c.setProjection(Projections.rowCount()).uniqueResult();
		Long totalCount=((Long)o).longValue();
		c.setProjection(null);
		return totalCount;
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria dc,int firstResult,int maxResults) {
		Criteria c = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
		c.setFirstResult(firstResult);
		c.setMaxResults(maxResults);
		return c.list();
	}

	@Override
	public List<T> findByExample(T exampleEntity) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(exampleEntity.getClass());
		c.add(Example.create(exampleEntity));
		return c.list();
	}

	@Override
	public List<T> findByExample(T exampleEntity, int firstResult,
			int maxResults) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(exampleEntity.getClass());
		c.add(Example.create(exampleEntity));
		c.setFirstResult(firstResult);
		c.setMaxResults(maxResults);
		return c.list();
	}

}
