/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.beans
 * @file BeansConfig.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-16
 */
package com.stepbystep.spring4.samples.context;

import com.stepbystep.spring4.samples.beans.HelloBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * <code>BeansConfig</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-16
 */
@Configuration
@PropertySource(name = "application",value = "classpath:/config/placeholder.properties")
@ImportResource("spring/properties.xml")
public class BeansConfig implements InitializingBean{
    private static final Logger LOG = LoggerFactory
            .getLogger(BeansConfig.class);

    @Value("${name}")
    private String name;
    @Bean
    public HelloBean helloBean(){
        return new HelloBean();
    }
    @Bean
    public HelloBean helloBeanTom(){
        return new HelloBean("Tom");
    }
    @Bean
    public HelloBean helloBeanJim(){
        return new HelloBean("Jim");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("BeansConfig name = {}",name);
    }
}
