package com.inmyshow.webbase.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inmyshow.webbase.dao.BaseDAOImpl;
import com.inmyshow.webbase.dao.IItemInfoDao;
import com.inmyshow.webbase.entity.ItemInfo;
@Repository("itemInfoDao")
public class ItemInfoDaoImpl extends BaseDAOImpl<ItemInfo, Long> implements IItemInfoDao{

	@Override
	@Transactional("txManager")
	public List<ItemInfo> getList(int firstResult,int maxResults,String orderCol,String orderby) {
		DetachedCriteria dc = DetachedCriteria.forClass(ItemInfo.class);
		Order order;
		if("asc".equals(orderby)){
			order = Order.asc(orderCol);
		}else{
			order = Order.desc(orderCol);
		}
		dc.addOrder(order);
		return super.findByCriteria(dc, firstResult, maxResults);
	}

	@Override
	@Transactional("txManager")
	public long countAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(ItemInfo.class);
		return super.getRowCount(dc);
	}
}
