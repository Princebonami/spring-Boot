package com.springboot.crud2.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",

		basePackages = { "com.springboot.crud2.product.repository" }, transactionManagerRef = "transactionManager")

public class ProductDBConfig {

	// datasource
//
	@Value("${spring.product.datasource.url}")
	String url;

	@Value("${spring.product.datasource.driver-class-name}")
	String driverClassName;

	@Value("${spring.product.datasource.password}")
	String password;

	@Value("${spring.product.datasource.username}")
	String userName;

	@Bean(name = "datasource")
	@Primary
	@ConfigurationProperties(prefix = "spring.product.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().url(url).username(userName).password(password)
				.driverClassName(driverClassName).build();
	}

	// entity manager factory
	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("datasource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");

		return builder.dataSource(dataSource).properties(properties).packages("com.springboot.crud2.model.product")
				.persistenceUnit("Product").build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	// platformTransactionFactory

	@Bean
	@ConditionalOnMissingBean
	public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
		return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	}

}
