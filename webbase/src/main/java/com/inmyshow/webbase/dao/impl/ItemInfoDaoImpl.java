package com.inmyshow.webbase.dao.impl;

import org.springframework.stereotype.Repository;

import com.inmyshow.webbase.dao.BaseDAOImpl;
import com.inmyshow.webbase.dao.IItemInfoDao;
import com.inmyshow.webbase.entity.ItemInfo;
@Repository("itemInfoDao")
public class ItemInfoDaoImpl extends BaseDAOImpl<ItemInfo, Long> implements IItemInfoDao{
	/**
	@Transactional("txManager")
	public User getABCD(Long id){
		return (User)sessionFactory.getCurrentSession().get(ItemInfo.class, id);
	}
	*/
}
