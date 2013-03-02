package com.inmyshow.webbase.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inmyshow.webbase.dao.BaseDAOImpl;
import com.inmyshow.webbase.dao.IItemInfoDao;
import com.inmyshow.webbase.entity.ItemInfo;
@Repository("itemInfoDao")
public class ItemInfoDaoImpl extends BaseDAOImpl<ItemInfo, Long> implements IItemInfoDao{

	@Override
	@Transactional("txManager")
	public List<ItemInfo> getList(int firstResult,int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(ItemInfo.class);
		return super.findByCriteria(dc, firstResult, maxResults);
	}
}
