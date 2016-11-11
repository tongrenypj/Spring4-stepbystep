/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.datasource
 * @file DataSourceDbcpXmlTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-13
 */
package com.stepbystep.spring4.samples.datasource;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;

/**
 * <code>DataSourceDbcpXmlTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-13
 *
 * mvn test -Dtest=DataSourceDbcpXmlTest
 */
@SpringApplicationConfiguration( locations = {"classpath:spring/dataSource-dbcp.xml"})
@ActiveProfiles("dbcp-xml")
public class DataSourceDbcpXmlTest extends AbstractDataSourceTest {

}
