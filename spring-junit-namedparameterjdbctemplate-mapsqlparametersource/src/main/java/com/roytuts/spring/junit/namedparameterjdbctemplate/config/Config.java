package com.roytuts.spring.junit.namedparameterjdbctemplate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
		ds.setUrl(environment.getRequiredProperty("spring.datasource.url"));
		ds.setUsername(environment.getRequiredProperty("spring.datasource.username"));
		ds.setPassword(environment.getRequiredProperty("spring.datasource.password"));
		return ds;
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

		return jdbcTemplate;

	}

}
