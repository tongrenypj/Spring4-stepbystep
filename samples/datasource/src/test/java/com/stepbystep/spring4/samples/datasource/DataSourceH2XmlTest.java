/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.datasource
 * @file DataSourceH2XmlTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-06-07
 */
package com.stepbystep.spring4.samples.datasource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * <code>DataSourceH2XmlTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-06-07
 */
public class DataSourceH2XmlTest {

    private static final Logger LOG = LoggerFactory
            .getLogger(DataSourceH2XmlTest.class);

    @Test
    public void testDataSource(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/dataSource-h2.xml");

        DataSource dataSource = applicationContext.getBean("h2DataSource", DataSource.class);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select id,name,age,create_time from t_user");
        for (Map<String, Object> user : list) {
            LOG.info("user = {}",user);
        }

    }
}
