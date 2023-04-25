package com.demo.grpcdemo.config;

import com.demo.grpcdemo.iris.repository.ExtendedRepositoryImpl;
import org.springframework.beans.factory.annotation.Qualifier;
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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "irisEntityManagerFactory", basePackages = {"com.demo.grpcdemo.iris.repository"}, repositoryBaseClass = ExtendedRepositoryImpl.class, transactionManagerRef = "irisTransactionManager")
public class IrisDbConfig {

    @Primary
    @Bean(name = "irisDataSource")
    @ConfigurationProperties(prefix = "spring.iris.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "irisEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier("irisDataSource") DataSource dataSource){

        Map<String,Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL55Dialect");

        return builder.dataSource(dataSource).properties(properties).packages("com.demo.grpcdemo.iris.model").persistenceUnit("iris").build();
    }

    @Primary
    @Bean(name = "irisTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("irisEntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

}