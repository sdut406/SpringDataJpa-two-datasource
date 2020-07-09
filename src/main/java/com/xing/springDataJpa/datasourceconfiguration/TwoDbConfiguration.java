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
        entityManagerFactoryRef = "twoDbEntityManagerFactory",
        transactionManagerRef = "twoDbPlatformTransactionManager",
        basePackages = {"com.xing.springDataJpa.two"}
)
public class TwoDbConfiguration {
    

    @Value("${spring.datasource.two.entity.path}")
    private String packagesToScan;
   
    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;
    public TwoDbConfiguration() {
    }

    private Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }
    @Bean(name = "twoDbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean twoDbEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("twoDbDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder.dataSource(dataSource).
                properties(getVendorProperties()).packages(packagesToScan.split(",",-1)).persistenceUnit("TwoDB").build();
        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "twoDbPlatformTransactionManager")
    public PlatformTransactionManager twoDbPlatformTransactionManager(@Qualifier("twoDbEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
