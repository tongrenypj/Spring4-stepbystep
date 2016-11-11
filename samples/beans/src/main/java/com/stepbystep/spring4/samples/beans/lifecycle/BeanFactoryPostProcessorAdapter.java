/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.beans
 * @file BeanFactoryPostProcessorAdapter.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-17
 */
package com.stepbystep.spring4.samples.beans.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * <code>BeanFactoryPostProcessorAdapter</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-17
 */
public class BeanFactoryPostProcessorAdapter implements BeanFactoryPostProcessor {
    private static final Logger LOG = LoggerFactory
            .getLogger(BeanFactoryPostProcessorAdapter.class);
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LOG.info("==[{}] ==",beanFactory);
    }
}
