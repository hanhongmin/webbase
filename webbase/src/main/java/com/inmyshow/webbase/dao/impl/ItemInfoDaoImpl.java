package com.inmyshow.webbase.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inmyshow.webbase.dao.BaseDAOImpl;
import com.inmyshow.webbase.dao.IItemInfoDao;
import com.inmyshow.webbase.entity.ItemInfo;

@Repository("itemInfoDao")
public class ItemInfoDaoImpl extends BaseDAOImpl<ItemInfo, Long> implements
		IItemInfoDao {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ItemInfoDaoImpl.class);

	@Override
	@Transactional("txManager")
	public List<ItemInfo> getList(int firstResult, int maxResults,
			String orderCol, String orderby) {
		DetachedCriteria dc = DetachedCriteria.forClass(ItemInfo.class);
		Order order;
		if ("asc".equals(orderby)) {
			order = Order.asc(orderCol);
		} else {
			order = Order.desc(orderCol);
		}
		dc.addOrder(order);
		return super.findByCriteria(dc, firstResult, maxResults);
	}
	
	@Override
	@Transactional("txManager")
	public List<ItemInfo> searchList(int firstResult, int maxResults,
			String orderCol, String orderby,String searchField,String searchString,String searchOper) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(ItemInfo.class);
		Criterion c;
		/**switch (searchOper) {//['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc'] 
		case "eq":
			c = Restrictions.eq(searchField, searchString);
			break;
		case "ne":
			c = Restrictions.ne(searchField, searchString);
			break;
		case "lt":
			c = Restrictions.lt(searchField, searchString);
			break;
		case "le":
			c = Restrictions.le(searchField, searchString);
			break;
		case "gt":
			c = Restrictions.gt(searchField, searchString);
			break;
		case "ge":
			c = Restrictions.ge(searchField, searchString);
			break;
		case "bw":
			//c = Restrictions.between(propertyName, lo, hi)(searchField, searchString);
			break;
		case "bn":
			c = Restrictions.eq(searchField, searchString);
			break;
		case "in":
			c = Restrictions.eq(searchField, searchString);
			break;
		case "ni":
			c = Restrictions.eq(searchField, searchString);
			break;
		case "ew":
			c = Restrictions.eq(searchField, searchString);
			break;
		case "en":
			c = Restrictions.eq(searchField, searchString);
			break;
		case "cn":
			c = Restrictions.eq(searchField, searchString);
			break;
		case "nc":
			c = Restrictions.(searchField, searchString);
			break;

		default:
			break;
		}
		*/
		
		Order order;
		if ("asc".equals(orderby)) {
			order = Order.asc(orderCol);
		} else {
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

	@Override
	@Transactional("txManager")
	public boolean updateById(ItemInfo itemInfo) {
		ItemInfo example = super.get(ItemInfo.class, itemInfo.getId());
		if (example == null) {
			return false;
		} else {
			BeanUtils.copyProperties(itemInfo, example, new String[] { "id",
					"oldId", "lastOptTime", "uploadFileName", "uploadTime",
					"uploadPeople", "newFileName", "newFilePath", "oldFolder",
					"loadType" });
			example.setLastOptTime(new Date());
			super.saveOrUpdate(example);
			return true;
		}
	}
}
