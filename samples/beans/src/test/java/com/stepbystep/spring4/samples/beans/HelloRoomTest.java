package com.stepbystep.spring4.samples.beans;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.*;

/**
 * <code>HelloRoomTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-22
 */
public class HelloRoomTest {

    @Test
    public void testSayHello() throws Exception {

        HelloRoom helloRoom = new HelloRoom();
        HelloServiceImpl helloService = new HelloServiceImpl();
        helloRoom.setHelloService(helloService);

        helloRoom.sayHello("Tom");
    }

    @Test
    public void testSpringIoC(){
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        ClassPathResource resource = new ClassPathResource("spring/hello-ioc.xml");
        beanDefinitionReader.loadBeanDefinitions(resource);

        HelloRoom helloRoom = beanFactory.getBean("helloRoom",HelloRoom.class);
        org.junit.Assert.assertNotNull(helloRoom);
        helloRoom.sayHello("Tom");

    }
}