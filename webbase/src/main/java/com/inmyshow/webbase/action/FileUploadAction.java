package com.inmyshow.webbase.action;

import java.io.IOException;

import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class FileUploadAction extends MultiActionController{
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadAction.class);
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFormUpload(@RequestParam("filename") String filename,
			@RequestParam("filedata") Part file) {
		long filesize = file.getSize();
		LOGGER.error("*************************************文件大小为："+filesize);
		if(filesize>1024*1024*2){//单个文件2M
			return null;
		}else{
			try {
				file.write("a.txt");//保存文件
			} catch (IOException e) {
				LOGGER.error("保存文件发生错误", e);
			}
			return "uploadsuccess";
		}
	}
}
