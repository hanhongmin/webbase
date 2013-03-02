package com.inmyshow.webbase.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inmyshow.webbase.dao.IItemInfoDao;
import com.inmyshow.webbase.entity.ItemInfo;

@Controller
public class ResourceManagerAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceManagerAction.class);
	@Resource(name="itemInfoDao")
	private IItemInfoDao itemDao;
	@RequestMapping("/manager")
	public String managerView(Model model,int firstResult,int maxResults) throws IOException {
		List<ItemInfo> list =  itemDao.getList(firstResult, maxResults);
		LOGGER.debug("List<ItemInfo> size:"+list.size());
		model.addAttribute("dataList", list);
		return "manager";
	}
}
