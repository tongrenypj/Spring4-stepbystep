/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.beans
 * @file BeanPostProcessorAdapter.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-17
 */
package com.stepbystep.spring4.samples.beans.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.*;

import java.beans.PropertyDescriptor;

/**
 * <code>BeanPostProcessorAdapter</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-17
 */
public class BeanPostProcessorAdapter implements BeanPostProcessor,
        InstantiationAwareBeanPostProcessor,DestructionAwareBeanPostProcessor {
    private static final Logger LOG = LoggerFactory
            .getLogger(BeanPostProcessorAdapter.class);


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LOG.info("== 初始化 前处理 beanName : [{}] bean : [{}] ==",beanName,bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        LOG.info("== 初始化 后处理 beanName : [{}] bean : [{}] ==",beanName,bean);
        return bean;
    }

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        LOG.info("== 销毁 前处理 beanName : [{}] bean : [{}] ==",beanName,bean);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        LOG.info("== 实例化 前处理 beanName : [{}] bean : [{}] ==",beanName,beanClass);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        LOG.info("== 实例化 后处理 beanName : [{}] bean : [{}] ==",beanName,bean);
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        LOG.info("== 实例化 处理属性 beanName : [{}] bean : [{}] ==",beanName,bean);
        return pvs;
    }
}
