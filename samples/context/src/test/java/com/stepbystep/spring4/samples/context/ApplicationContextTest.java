/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.beans
 * @file ApplicationContextTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-16
 */
package com.stepbystep.spring4.samples.context;

import com.stepbystep.spring4.samples.context.HelloContext;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>ApplicationContextTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-16
 */
public class ApplicationContextTest {

    private static final Logger LOG = LoggerFactory
            .getLogger(ApplicationContextTest.class);

    /**
     * 测试 bean生命周期
     */
    @Test
    public void testApplicationContextXml(){
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("spring/hello-context.xml");
        LOG.info("applicationContext = {}",applicationContext );
        HelloContext bean = applicationContext.getBean("helloContext",HelloContext.class);
        bean.sayHello();
        applicationContext.destroy();
//        printBeans(applicationContext);
    }

    @Test
    public void testBeanFactoryAnnotation(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        annotatedBeanDefinitionReader.registerBean(HelloContext.class);
        LOG.info("beanFactory = {}",beanFactory );

        HelloContext bean = beanFactory.getBean(HelloContext.class);
        Assert.notNull(bean);
        bean.sayHello();
        printBeans(beanFactory);
    }



    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testApplicationContextProfile(){
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        StandardEnvironment environment = new StandardEnvironment();
        //profile
        environment.setActiveProfiles("framework");
        applicationContext.setEnvironment(environment);
        applicationContext.load("spring/hello-context.xml","spring/properties.xml");
        //在refresh之前设置 activeProfiles
        applicationContext.refresh();

        HelloContext bean = applicationContext.getBean("helloContext",HelloContext.class);
        bean.sayHello();
        bean = applicationContext.getBean("helloContext2",HelloContext.class);
        bean.sayHello();
        LOG.info("run here");
        bean = applicationContext.getBean("helloContext3",HelloContext.class);
        bean.sayHello();
        LOG.info("bean = {}",bean);
    }

    @Test
    public void testApplicationContextProperties(){
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        StandardEnvironment environment = new StandardEnvironment();
        environment.setActiveProfiles("framework","boot");
        applicationContext.setEnvironment(environment);
        applicationContext.load("spring/hello-context.xml","spring/properties.xml");
        //在refresh之前设置 activeProfiles
        applicationContext.refresh();

        HelloContext bean = applicationContext.getBean("helloContext",HelloContext.class);
        bean.sayHello();
        HelloContext bean2 = applicationContext.getBean("helloContext2",HelloContext.class);
        bean2.sayHello();
        HelloContext bean3 = applicationContext.getBean("helloContext3",HelloContext.class);
        bean3.sayHello();
        printBeans(applicationContext);
    }

    @Test
    public void testAnnotation(){
        String packageName = HelloContext.class.getPackage().getName();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(packageName);
        HelloContext bean = applicationContext.getBean(HelloContext.class);
        bean.sayHello();
        LOG.info("applicationContext = {}",applicationContext );
        printBeans(applicationContext);
    }

    private void printBeans(ListableBeanFactory beanFactory) {
        StringBuilder sb =new StringBuilder("\n");
        for (String s : beanFactory.getBeanDefinitionNames()) {
            sb.append(s).append("\n");
        }
        LOG.info("beanNames = {}",sb.toString());
        LOG.info("beanNames.size = {}",beanFactory.getBeanDefinitionCount());
    }
}
