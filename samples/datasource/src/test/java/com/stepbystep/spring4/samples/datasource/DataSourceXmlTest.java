/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.datasource
 * @file DataSourceXmlTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-13
 */
package com.stepbystep.spring4.samples.datasource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Map;

/**
 * <code>DataSourceXmlTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-13
 */
@SpringApplicationConfiguration( locations = {"classpath:/spring/dataSource-druid.xml"})
@ActiveProfiles("druid-xml")
public class DataSourceXmlTest extends AbstractDataSourceTest {
    private static final Logger LOG = LoggerFactory
            .getLogger(DataSourceXmlTest.class);

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select 1");

        LOG.info("maps = {}",maps);
    }
}
