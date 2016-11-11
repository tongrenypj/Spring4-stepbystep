/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring.samples.bootdemo
 * @file BootDemoApplication.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-23
 */
package com.stepbystep.spring.samples.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <code>BootDemoApplication</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-23
 */
@SpringBootApplication
public class BootDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BootDemoApplication.class,args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(BootDemoApplication.class);
//        builder.profiles("")
        builder.run(args);
    }
}
