package com.dev9.board.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DBConfig {

//	@Bean
////	@Primary
//	@Qualifier(value = "maria")
//	@ConfigurationProperties(prefix = "spring.datasource.maria")
//	DataSource dataSourceMaria() {
//		return DataSourceBuilder.create().build();
//	}

//	@Bean
////	@Primary
//	@Qualifier(value = "mysql")
//	@ConfigurationProperties(prefix = "spring.datasource.mysql")
//	DataSource dataSourceMysql() {
//		return DataSourceBuilder.create().build();
//	}

//	@Bean
////	@Primary
//	@Qualifier(value = "oracle")
//	@ConfigurationProperties(prefix = "spring.datasource.oracle")
//	DataSource dataSourceOracle() {
//		return DataSourceBuilder.create().build();
//	}

//	@Bean
//	@Primary
//	@Qualifier(value = "postgres")
//	@ConfigurationProperties(prefix = "spring.datasource.postgres")
//	DataSource dataSourcePostgres() {
//		return DataSourceBuilder.create().build();
//	}

//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sessionFactory  = new RefreshableSqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		Resource[] resource = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml");
//		sessionFactory.setMapperLocations(resource);
//		((RefreshableSqlSessionFactoryBean) sessionFactory).setInterval(1000);
//		return sessionFactory.getObject();
//	}


//	@Bean
////	@Primary
//	@Qualifier(value = "sqlserver")
//	@ConfigurationProperties(prefix = "spring.datasource.sqlserver")
//	DataSource dataSourceSqlserver() {
//		return DataSourceBuilder.create().build();
//	}

}
