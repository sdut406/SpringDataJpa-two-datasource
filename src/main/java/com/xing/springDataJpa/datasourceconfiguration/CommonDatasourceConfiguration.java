package com.xing.springDataJpa.datasourceconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 功能描述
 *
 * @since 2020-07-09
 */
@Configuration
public class CommonDatasourceConfiguration {

    public CommonDatasourceConfiguration() {
    }
    
    @Bean(name = "firstDbDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDbDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "twoDbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource twoDbDataSource() {
       return DataSourceBuilder.create().build();
    }
}
