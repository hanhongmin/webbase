package com.inmyshow.webbase.dao;

import java.util.List;

import com.inmyshow.webbase.entity.ItemInfo;


public interface IItemInfoDao extends IBaseDao<ItemInfo,Long> {
	public List<ItemInfo> getList(int firstResult,int maxResults,String orderCol,String orderby);
	public long countAll();
	public boolean updateById(ItemInfo itemInfo);
	public List<ItemInfo> searchList(int firstResult, int maxResults,
			String orderCol, String orderby,String searchField,String searchString,String searchOper);
}
