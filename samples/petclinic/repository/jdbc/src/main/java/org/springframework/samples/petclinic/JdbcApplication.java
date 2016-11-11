/*
 * @project spring4-stepbystep
 * @package org.springframework.samples.petclinic
 * @file JdbcApplication.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-07-20
 */
package org.springframework.samples.petclinic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

/**
 * <code>JdbcApplication</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-07-20
 */
@SpringBootApplication(scanBasePackages={"org.springframework.samples.petclinic.repository.jdbc"}
,exclude = {HibernateJpaAutoConfiguration.class})
@Profile("jdbc")
public class JdbcApplication {

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean(name = "namedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
