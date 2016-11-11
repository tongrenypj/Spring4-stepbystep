/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.aop
 * @file CglibMethodInterceptor.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package com.stepbystep.spring4.samples.aop.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * <code>CglibMethodInterceptor</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
public class CglibProxy implements MethodInterceptor {
    private static final Logger LOG = LoggerFactory
            .getLogger(CglibProxy.class);
    private Object target;

    /**
     * <code>createProxy</code>
     *
     * 创建cglb代理对象
     *
     * @param <T>    the type parameter
     * @param target the target
     * @return the t
     * @author junming.wang
     * @since 1.0 2016-05-19
     */
    public static <T>T createProxy(Object target){
        CglibProxy interceptor = new CglibProxy(target);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(interceptor.target.getClass());
        enhancer.setCallback(interceptor);
        return (T) enhancer.create();
    }
    public CglibProxy(Object target) {
        this.target = target;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        LOG.info("=======before {}",method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        LOG.info("=======after {}",method.getName());
        return object;
    }
}
