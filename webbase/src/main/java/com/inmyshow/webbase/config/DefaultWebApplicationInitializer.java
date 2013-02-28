package com.inmyshow.webbase.config;

import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class DefaultWebApplicationInitializer implements
		WebApplicationInitializer {
	private final static Logger LOGGER = LoggerFactory
			.getLogger(DefaultWebApplicationInitializer.class);

	private static final long MAX_FILE_UPLOAD_SIZE = 1024 * 1024 * 5;
	private static final int FILE_SIZE_THRESHOLD = 1024 * 1024;
	private static final long MAX_REQUEST_SIZE = -1L;

	@Override
	public void onStartup(ServletContext appContext) throws ServletException {
		LOGGER.info("********************onStartup");
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(DefaultAppConfig.class);
		appContext.addListener(new ContextLoaderListener(rootContext));
		
		FilterRegistration charEncodingfilterReg = appContext.addFilter(
				"characterEncodingFilter", CharacterEncodingFilter.class);
		charEncodingfilterReg.setInitParameter("encoding", "UTF-8");
		charEncodingfilterReg.setInitParameter("forceEncoding", "true");
		charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/*");
		// appContext.addFilter("sessionFilter",SessionFilter.class);//登录过滤器
		
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(DispatcherConfig.class);

		ServletRegistration.Dynamic dispatcher = appContext.addServlet(
				"dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		dispatcher.setMultipartConfig(new MultipartConfigElement(null,
				MAX_FILE_UPLOAD_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD));// 设置以便处理multipartRequest。文件上传

	}
}