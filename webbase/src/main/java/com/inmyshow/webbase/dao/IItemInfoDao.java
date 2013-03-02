package com.inmyshow.webbase.dao;

import java.util.List;

import com.inmyshow.webbase.entity.ItemInfo;


public interface IItemInfoDao extends IBaseDao<ItemInfo,Long> {
	public List<ItemInfo> getList(int firstResult,int maxResults);
}
