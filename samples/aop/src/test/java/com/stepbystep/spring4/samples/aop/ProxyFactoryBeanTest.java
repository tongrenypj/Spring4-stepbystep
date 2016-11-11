/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.aop
 * @file ProxyFactoryBeanTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package com.stepbystep.spring4.samples.aop;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * <code>ProxyFactoryBeanTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
public class ProxyFactoryBeanTest {
    private static final Logger LOG = LoggerFactory
            .getLogger(ProxyFactoryBeanTest.class);

    @Test
    public void testProxy(){
//        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("spring/proxy.xml");
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        ClassPathResource resource = new ClassPathResource("spring/proxy.xml");
        beanDefinitionReader.loadBeanDefinitions(resource);

        HelloService helloService = beanFactory.getBean("helloService", HelloService.class);
        helloService.chatting("tom");
    }
}
