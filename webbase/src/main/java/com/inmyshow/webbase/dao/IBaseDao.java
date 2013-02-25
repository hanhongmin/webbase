package com.inmyshow.webbase.dao;

import java.io.Serializable;

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

}
