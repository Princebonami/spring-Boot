package com.example.crudwithmultipledatabase.mysql;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
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
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.example.crudwithmultipledatabase.mysql"},
        entityManagerFactoryRef="FirstEntityManagerFactory",
        transactionManagerRef = "transactioManager"
)
public class MysqlConfig {


    @Bean
    @Primary
    public DataSource dataSource(){

        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/multiple_db1");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        return dataSource;
    }


    @Bean(name = "FirstEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityContainerEntityManagerFactoryBean (){
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();

        bean.setDataSource(dataSource());

        JpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adapter);

        Map<String , String> props=new HashMap<>();
        props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","update");
        bean.setJpaPropertyMap(props);
        
        bean.setPackagesToScan("com.example.crudwithmultipledatabase.mysql");

        return bean;
    }


    @Bean("transactioManager")
    @Primary
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager=new JpaTransactionManager();
        manager.setEntityManagerFactory(entityContainerEntityManagerFactoryBean().getObject());

        return manager;
    }

}
