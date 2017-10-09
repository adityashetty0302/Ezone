package com.hibernateConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.*;
import com.DaoImpl.*;

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
	
	
}
