/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.datasource
 * @file AbstractDataSourceTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-13
 */
package com.stepbystep.spring4.samples.datasource;

import com.alibaba.druid.util.JdbcUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <code>AbstractDataSourceTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-13
 */
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractDataSourceTest {

    private static final Logger LOG = LoggerFactory
            .getLogger(DataSourceConfigTest.class);
    @Autowired
    protected DataSource dataSource;

    @Test
    public void test1() throws SQLException {
        Assert.notNull(dataSource,"dataSource not null");
        LOG.info("dataSource = {}",dataSource);
        List<Map<String, Object>> maps = JdbcUtils.executeQuery(dataSource, "select 1");
        LOG.info("maps = {}",maps);
    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select 1");

        LOG.info("maps = {}",maps);
    }
}
