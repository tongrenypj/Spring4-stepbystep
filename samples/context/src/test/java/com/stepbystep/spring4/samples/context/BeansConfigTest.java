package com.stepbystep.spring4.samples.context;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

/**
 * <code>BeansConfigTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-08-09
 */
public class BeansConfigTest {

    private static final Logger LOG = LoggerFactory
            .getLogger(BeansConfigTest.class);
    @Test
    public void testBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfig.class);
        Assert.notNull(applicationContext.getAliases("helloBeanTom"));
        Assert.notNull(applicationContext.getAliases("helloBeanJim"));
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
                LOG.info("bean = {}",beanDefinitionName);
        }
    }
}