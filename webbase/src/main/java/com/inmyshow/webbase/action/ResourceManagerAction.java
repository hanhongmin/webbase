package com.inmyshow.webbase.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inmyshow.webbase.action.utils.GirdJsonObject;
import com.inmyshow.webbase.dao.IItemInfoDao;
import com.inmyshow.webbase.entity.ItemInfo;

@Controller
public class ResourceManagerAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceManagerAction.class);
	@Resource(name="itemInfoDao")
	private IItemInfoDao itemDao;
	@RequestMapping("/manager")
	public @ResponseBody GirdJsonObject managerData( int rows,int page,String sidx,String sord) throws IOException {
		List<ItemInfo> list =  itemDao.getList(rows*(page-1), rows,sidx,sord);
		long total = itemDao.countAll();
		GirdJsonObject json = new GirdJsonObject();
		json.setRows(list);
		json.setPage(String.valueOf(page));
		long totalPage = total%rows==0?total/rows:total/rows+1;
		json.setRecords(String.valueOf(total));
		json.setTotal(totalPage);
		return json;
	}
	
	@RequestMapping("/updateresource")
	public String updateData(ItemInfo info,String oper) throws IOException {
		if("del".equalsIgnoreCase(oper)){
			itemDao.delete(info);
		}else{
			boolean result = itemDao.updateById(info);
		}
		
		return "testviews/updatesuccess";
	}
}
