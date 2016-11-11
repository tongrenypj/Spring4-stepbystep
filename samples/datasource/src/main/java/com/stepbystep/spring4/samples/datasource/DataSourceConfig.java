/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.datasource
 * @file DataSourceConfig.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-13
 */
package com.stepbystep.spring4.samples.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * <code>DataSourceConfig</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-13
 */
@Configuration
@EnableConfigurationProperties
public class DataSourceConfig {

    @Bean(name ="dataSource")
    @Qualifier("dataSource")
    @Profile("druid")
    @ConfigurationProperties(locations = {"classpath:/config/jdbc.properties"},prefix = DataSourceProperties.PREFIX+".h2")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    public ResourceTransactionManager transactionManager(DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager){
        return new TransactionTemplate(transactionManager);
    }

}
