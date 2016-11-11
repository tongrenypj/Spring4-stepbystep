/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring.samples.mvcdemo
 * @file DemoModelApplication.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-23
 */
package com.stepbystep.spring.samples.mvcdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * <code>DemoModelApplication</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-23
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:/spring/app.xml"})
public class DemoModelApplication {

}
