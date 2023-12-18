package com.example.crudwithmultipledatabase.postgres;


import org.hibernate.dialect.MySQL8Dialect;
import org.hibernate.dialect.PostgreSQLDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.example.crudwithmultipledatabase.postgres"},
        entityManagerFactoryRef="secondEntityManagerFactory",
        transactionManagerRef = "secondTransactioManager"
)
public class postgresConfig {

    @Bean("secondDatasource")
    @Primary
    public DataSource dataSource(){

        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/multiple_db2");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        return dataSource;
    }


    @Bean(name = "secondEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityContainerEntityManagerFactoryBean (){
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();

        bean.setDataSource(dataSource());

        JpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adapter);

        Map<String , String> props=new HashMap<>();
        props.put("hibernate.dialect", MySQL8Dialect.class.getName());
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","update");
        bean.setJpaPropertyMap(props);

        bean.setPackagesToScan("com.example.crudwithmultipledatabase.postgres");

        return bean;
    }


    @Bean("secondTransactioManager")
    @Primary
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager=new JpaTransactionManager();
        manager.setEntityManagerFactory(entityContainerEntityManagerFactoryBean().getObject());

        return manager;
    }
}
