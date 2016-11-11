package com.stepbystep.spring4.samples.beans;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.*;

/**
 * <code>HelloServiceTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-22
 */
public class HelloServiceTest {
    @Test
    public void testIoCXml(){
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        ClassPathResource resource = new ClassPathResource("spring/hello-ioc.xml");
        beanDefinitionReader.loadBeanDefinitions(resource);

        HelloService bean = beanFactory.getBean("helloService",HelloService.class);
        org.junit.Assert.assertNotNull(bean);
        bean.chatting("Tom");

    }
}