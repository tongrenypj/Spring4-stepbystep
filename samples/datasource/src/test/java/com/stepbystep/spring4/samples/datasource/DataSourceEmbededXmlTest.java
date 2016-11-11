/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.datasource
 * @file DataSourceEmbededXmlTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-13
 */
package com.stepbystep.spring4.samples.datasource;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;

/**
 * <code>DataSourceEmbededXmlTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-13
 */
@SpringApplicationConfiguration( locations = {"classpath:/spring/dataSource-embeded-h2.xml"})
@ActiveProfiles("embeded")
public class DataSourceEmbededXmlTest extends AbstractDataSourceTest {

}
