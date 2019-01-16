package com.mtc.app.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class AppConfig {

	
	@Bean(name="dataSource")	
	public BasicDataSource getDataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/test");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("Reva@1995");
		basicDataSource.setInitialSize(5);
		basicDataSource.setMaxTotal(10);
		
		return basicDataSource;
		
	} 
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate geJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean(name="namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(getDataSource());
	}
	
}
