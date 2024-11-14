package com.dev9.board.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DBConfig {


	@Bean
//	@Primary
	@Qualifier(value = "maria")
	@ConfigurationProperties(prefix = "spring.datasource.maria")
	DataSource dataSourceMaria() {
		return DataSourceBuilder.create().build();
	}

	@Bean
//	@Primary
	@Qualifier(value = "mysql")
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	DataSource dataSourceMysql() {
		return DataSourceBuilder.create().build();
	}

	@Bean
//	@Primary
	@Qualifier(value = "oracle")
	@ConfigurationProperties(prefix = "spring.datasource.oracle")
	DataSource dataSourceOracle() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	@Qualifier(value = "postgres")
	@ConfigurationProperties(prefix = "spring.datasource.postgres")
	DataSource dataSourcePostgres() {
		return DataSourceBuilder.create().build();
	}

	@Bean
//	@Primary
	@Qualifier(value = "sqlserver")
	@ConfigurationProperties(prefix = "spring.datasource.sqlserver")
	DataSource dataSourceSqlserver() {
		return DataSourceBuilder.create().build();
	}

}
