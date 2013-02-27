package com.inmyshow.webbase.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileUploadAction{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FileUploadAction.class);

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void handleFormUpload(String filename,
			@RequestParam("filedata") Part file,HttpServletResponse response,HttpServletRequest request) throws IOException{
		long filesize = file.getSize();
		LOGGER.debug("上传的文件大小为：" + filesize);
		try {
			LOGGER.debug("filename:"+request.getParameter("filename"));
			LOGGER.debug("filename:"+new String(filename.getBytes("iso-8859-1"),"utf-8"));
			LOGGER.debug("filename:"+filename);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			file.write("a.txt");// 保存文件
		} catch (IOException e) {
			LOGGER.error("保存文件发生错误", e);
		}
		
		//return "testviews/uploadsuccess";
			response.getWriter().write(filename);
	}
}
