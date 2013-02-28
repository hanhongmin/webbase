package com.inmyshow.webbase.action;

import java.io.IOException;

import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inmyshow.webbase.entity.ItemInfo;

@Controller
public class FileUploadAction{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileUploadAction.class);

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload(String name,String info,Integer type,
			@RequestParam("filedata") Part file) throws IOException{
		String itemName = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		String itemInfo = new String(info.getBytes("ISO-8859-1"),"UTF-8");
		ItemInfo item = new ItemInfo();
		item.setItemComment(itemInfo);
		item.setItemName(itemName);
		item.setItemType(type);
		file.write("a.txt");
		LOGGER.debug(item.toString());
		return "testviews/uploadsuccess";

	}
}
