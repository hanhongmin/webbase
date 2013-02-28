package com.inmyshow.webbase.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.inmyshow.*.action"})
public class DispatcherConfig extends WebMvcConfigurerAdapter {
	private final static Logger LOGGER = LoggerFactory.getLogger(DispatcherConfig.class);
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		LOGGER.info("******************configureMessageConverters");
		MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
		List<MediaType> mediatypes = new ArrayList<MediaType>();
		mediatypes.add(MediaType.APPLICATION_JSON);
		converter.setSupportedMediaTypes(mediatypes);
		converters.add(converter);
	}
	
	@Bean
	public InternalResourceViewResolver configureInternalResourceViewResolver() {
		LOGGER.info("******************configureInternalResourceViewResolver");
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	}
	@Bean(name="multipartResolver")
	public StandardServletMultipartResolver configureStandardServletMultipartResolver() {
		StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
	    return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		LOGGER.info("******************addResourceHandlers");
		registry.addResourceHandler("/static/**").addResourceLocations(
				"/js/");
	}

}