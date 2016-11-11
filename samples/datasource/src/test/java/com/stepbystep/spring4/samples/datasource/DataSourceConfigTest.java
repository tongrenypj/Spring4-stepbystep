package com.stepbystep.spring4.samples.datasource;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;

/**
 * <code>DataSourceConfigTest</code>
 *
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-13
 */
@SpringApplicationConfiguration( classes = {DataSourceConfig.class})
@ActiveProfiles("druid")
public class DataSourceConfigTest extends AbstractDataSourceTest {



}