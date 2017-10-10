package com.hibernateConfig;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@EnableTransactionManagement
@ComponentScan("com")

public class hiberConfig 
{
	@Autowired
	@Bean(name="datasource")
	public DataSource getH2()
	{
		System.out.println("Hibernate initiated...");
		DriverManagerDataSource dt = new DriverManagerDataSource();
		dt.setDriverClassName("org.h2.Driver");
		dt.setUrl("jdbc:h2:tcp://localhost/~/mt");
		dt.setUsername("sa");
		dt.setPassword("");
		System.out.println("Connection Established...");
		return dt;
		
	}
	
	public SessionFactory getSessionFactory()
	{
		 Properties hibernateProperties = new Properties();
		 hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
		 hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		
	}
	
}
