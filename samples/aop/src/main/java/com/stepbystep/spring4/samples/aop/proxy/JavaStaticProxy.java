/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.aop
 * @file JavaStaticProxy.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package com.stepbystep.spring4.samples.aop.proxy;

import com.stepbystep.spring4.samples.aop.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>JavaStaticProxy</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
public class JavaStaticProxy implements HelloService {
    private static final Logger LOG = LoggerFactory
            .getLogger(JavaStaticProxy.class);
    private HelloService helloService;

    public JavaStaticProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String user) {
        LOG.info("=======before sayHello");
        return helloService.sayHello(user);
    }

    @Override
    public String saySomething(String user) {
        LOG.info("=======before saySomething");
        return helloService.saySomething(user);
    }

    @Override
    public String chatting(String user) {
        LOG.info("=======before chatting");
        return helloService.chatting(user);
    }

    @Override
    public String sayBye(String user) {
        LOG.info("=======before sayBye");
        return helloService.sayBye(user);
    }
}
