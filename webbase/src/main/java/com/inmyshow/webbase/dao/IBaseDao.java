package com.inmyshow.webbase.dao;

import java.io.Serializable;

public interface IBaseDao<T extends Object, ID extends Serializable> {


	/**
	 * ���ʵ��
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T get(Class<T> clazz, ID id);

	/**
	 * ��������ʵ�壬ȡ����id
	 * 
	 * @param object
	 */
	public void saveOrUpdate(T object);

	/**
	 * ɾ��ʵ��
	 * 
	 * @param object
	 */
	public void delete(T object);

}
