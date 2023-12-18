package com.springboot.crud2.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManagerFactory",

		basePackages = { "com.springboot.crud2.user.repository" }, transactionManagerRef = "userTransactionManager")
public class UserDBConfig {

	// datasource

	@Value("${spring.user.datasource.url}")
	String url;

	@Value("${spring.user.datasource.driver-class-name}")
	String driverClassName;

	@Value("${spring.user.datasource.password}")
	String password;

	@Value("${spring.user.datasource.username}")
	String userName;

	@Bean(name = "userDatasource")
	@Primary
	@ConfigurationProperties(prefix = "spring.user.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().url(url).username(userName).password(password)
				.driverClassName(driverClassName).build();
	}

	// entity manager factory
	@Primary
	@Bean(name = "userEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("userDatasource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		return builder.dataSource(dataSource).properties(properties).packages("com.springboot.crud2.model.user")
				.persistenceUnit("User").build();
	}

	@Primary
	@Bean(name = "userTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("userEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
