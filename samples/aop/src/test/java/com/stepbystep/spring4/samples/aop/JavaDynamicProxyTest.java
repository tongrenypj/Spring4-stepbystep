package com.stepbystep.spring4.samples.aop;

import com.stepbystep.spring4.samples.aop.proxy.JavaDynamicProxy;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * <code>HelloHandlerTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
public class JavaDynamicProxyTest {
    private static final Logger LOG = LoggerFactory
            .getLogger(JavaDynamicProxyTest.class);
    @Test
    public void testSayHello(){
        HelloService helloServiceProxy = getHelloServiceProxy();

        LOG.info("=======start");
        helloServiceProxy.sayHello("tom");
        helloServiceProxy.saySomething("tom");
        helloServiceProxy.sayBye("tom");
        LOG.info("=======end");
    }
    @Test
    public void testChatting(){
        HelloService helloServiceProxy = getHelloServiceProxy();
        LOG.info("=======start");
        helloServiceProxy.chatting("tom");
        LOG.info("=======end");
    }

    private static HelloService getHelloServiceProxy() {
        HelloService helloService = new HelloServiceImpl();
        InvocationHandler handler = new JavaDynamicProxy(helloService);

        return (HelloService) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(), handler);
    }
}