package com.inmyshow.webbase.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inmyshow.webbase.dao.IItemInfoDao;
import com.inmyshow.webbase.entity.ItemInfo;

@Controller
@PropertySource("classpath:/upload.properties")
public class FileUploadAction{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileUploadAction.class);
	@Resource
    Environment env;
	@Resource(name="itemInfoDao")
	private IItemInfoDao itemDao;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload(String name,String info,Integer type,
			@RequestParam("filedata") Part file) throws IOException{
		String itemName = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		String itemInfo = new String(info.getBytes("ISO-8859-1"),"UTF-8");
		ItemInfo item = new ItemInfo();
		item.setItemComment(itemInfo);
		item.setItemName(itemName);
		item.setItemType(type);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String month = sdf.format(new Date());
		long mill = System.currentTimeMillis();
		Random r = new Random();
		int rr = 100+r.nextInt(900);//三位随机数[100-999]
		String fileName = String.valueOf(mill)+String.valueOf(rr)+".txt";
		File f = new File(env.getProperty("upload.dir")+month);
		if(!f.exists()){
			f.mkdirs();
		}
		file.write(env.getProperty("upload.dir")+month+File.separator+fileName);
		String uploadFileName = parseFileName(file.getHeader("content-disposition"));
		Date now = new Date();
		item.setLastOptTime(now);
		item.setUploadTime(now);
		item.setNewFileName(fileName);
		item.setNewFilePath(env.getProperty("upload.dir")+month);
		item.setUploadFileName(uploadFileName);
		item.setUploadPeople("upload");
		LOGGER.debug(item.toString());
		itemDao.saveOrUpdate(item);
		
		return "redirect:upload.jsp";

	}
	
	private String parseFileName(String header) {
        return header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
    }
}
