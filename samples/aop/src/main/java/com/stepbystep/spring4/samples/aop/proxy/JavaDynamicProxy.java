/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.aop
 * @file HelloHandler.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package com.stepbystep.spring4.samples.aop.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <code>HelloHandler</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
public class JavaDynamicProxy implements InvocationHandler {
    private static final Logger LOG = LoggerFactory
            .getLogger(JavaDynamicProxy.class);
    private Object proxied;

    public JavaDynamicProxy(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOG.info("=======before {}",method.getName());
        Object invoke = method.invoke(proxied, args);
        LOG.info("=======after {}",method.getName());
        return invoke;
    }
}
