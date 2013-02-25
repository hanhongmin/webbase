package com.inmyshow.webbase.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:/jdbc.properties")
public class DataSourceConfig {
	private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);
	@Resource
    Environment env;

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		LOGGER.info("**********dataSource");
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(env.getProperty("jdbc.driverClass"));
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory()
			throws PropertyVetoException {
		LOGGER.info("**********sessionFactory");
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		sessionFactoryBean.setHibernateProperties(hibernateProperties);
		sessionFactoryBean.setPackagesToScan("com.inmyshow.*.entity");
		return sessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager txManager() throws PropertyVetoException {
		LOGGER.info("**********txManager");
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
	}
}
