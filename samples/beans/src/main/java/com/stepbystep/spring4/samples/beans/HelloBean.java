/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.beans.model
 * @file HelloBean.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-16
 */
package com.stepbystep.spring4.samples.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <code>HelloBean</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-16
 */
public class HelloBean implements InitializingBean,DisposableBean,BeanNameAware{

    private static final Logger LOG = LoggerFactory
            .getLogger(HelloBean.class);


    private String name;

    private Integer age;
    protected String beanName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        LOG.info("== 注入Bean属性 [{}] ==",name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public HelloBean() {
        LOG.info("== 构造方法 [{}] ==",beanName);
    }

    public HelloBean(String name) {
        this();
        this.name = name;
    }

    public void sayHello(){
        LOG.info("== 业务操作 [{}] ==hello my name = {} and age = {}",beanName,name,age);
    }

    @PreDestroy
    public void preDestroy(){
        LOG.info("== [{}] ==",beanName);
    }
    @PostConstruct
    public void postConstruct(){
        LOG.info("== [{}] ==",beanName);
    }
    @Override
    public void destroy() throws Exception {
        LOG.info("== 销毁 接口回调[{}] ==",beanName);
    }

    public void initMethod() throws Exception {
        LOG.info("== 初始化 配置回调 [{}] ==",beanName);
    }

    public void destroyMethod() throws Exception {
        LOG.info("== 销毁 配置回调 [{}] ==",beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("== 初始化 接口回调 [{}] ==",beanName);
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
        LOG.info("== 执行Aware操作 [{}] ==",beanName);
    }
}
