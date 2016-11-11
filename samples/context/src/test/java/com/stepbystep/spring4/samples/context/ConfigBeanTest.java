package com.stepbystep.spring4.samples.context;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by guoyu on 28/7/2016.
 */
public class ConfigBeanTest {

    private static Logger logger = LoggerFactory.getLogger(ConfigBeanTest.class);

    @Test
    public void testConfig() throws IOException {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("spring/properties.xml");
        logger.info("applicationContext = {}",applicationContext );
        Properties bean = applicationContext.getBean("placeHolderProperties",Properties.class);
        logger.info("get properties:{}", bean.getProperty("desc"));
    }
}
