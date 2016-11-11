/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring.samples.bootdemo.web
 * @file WebConfig.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-24
 */
package com.stepbystep.spring.samples.bootdemo.web;

import com.stepbystep.spring.samples.bootdemo.BootDemoApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * <code>WebConfig</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-24
 */
public class WebConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return super.configure(builder);
        builder.sources(BootDemoApplication.class);
        return builder;
    }

}
