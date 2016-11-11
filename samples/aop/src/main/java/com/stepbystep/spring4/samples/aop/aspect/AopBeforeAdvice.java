/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.aop.aspect
 * @file AopBeforeAdvice.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package com.stepbystep.spring4.samples.aop.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * <code>AopBeforeAdvice</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
public class AopBeforeAdvice implements MethodBeforeAdvice {
    private static final Logger LOG = LoggerFactory
            .getLogger(AopBeforeAdvice.class);
    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
//        System.out.println("run my before advice");
        LOG.info("========before  {}",method.getName());
    }

}
