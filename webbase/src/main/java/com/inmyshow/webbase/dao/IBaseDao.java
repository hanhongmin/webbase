package com.inmyshow.webbase.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDao<T extends Object, ID extends Serializable> {


	/**
	 * 获得实体
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T get(Class<T> clazz, ID id);

	/**
	 * 保存或更新实体，取决于id
	 * 
	 * @param object
	 */
	public void saveOrUpdate(T object);

	/**
	 * 删除实体
	 * 
	 * @param object
	 */
	public void delete(T object);
	public List<T> findByExample(T exampleEntity);
	public List<T> findByExample(T exampleEntity,int firstResult,int maxResults);
	public List<T> findByCriteria(DetachedCriteria dc);
	public Long getRowCount(DetachedCriteria dc);
	public List<T> findByCriteria(DetachedCriteria dc,int firstResult,int maxResults);

}
