package com.xing.springDataJpa.datasourceconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * 功能描述
 *
 * @since 2020-07-09
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "firstDbEntityManagerFactory",
        transactionManagerRef = "firstDbPlatformTransactionManager",
        basePackages = {"com.xing.springDataJpa.first"}
)
public class FirstDbConfiguration {

    public FirstDbConfiguration() {
    }
    @Value("${spring.datasource.first.entity.path}")
    private String packagesToScan;

    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    private Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }
    
    @Bean(name = "firstDbEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean firstDbEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("firstDbDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder.dataSource(dataSource).
                properties(getVendorProperties()).packages(packagesToScan.split(",",-1)).persistenceUnit("FirstDB").build();
        return localContainerEntityManagerFactoryBean;
    }
    
    @Bean(name = "firstDbPlatformTransactionManager")
    @Primary
    public PlatformTransactionManager firstDbPlatformTransactionManager(@Qualifier("firstDbEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
