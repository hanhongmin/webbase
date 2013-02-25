package com.inmyshow.webbase.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { 
		"com.inmyshow.*.dao.impl", "com.inmyshow.*.entity" })
// ����ʹ��*��
@Import(DataSourceConfig.class)
@EnableTransactionManagement
public class DefaultAppConfig {

}
