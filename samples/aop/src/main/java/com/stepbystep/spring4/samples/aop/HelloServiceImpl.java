/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.aop
 * @file HelloServiceImpl.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package com.stepbystep.spring4.samples.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * <code>HelloServiceImpl</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
@Component
public class HelloServiceImpl implements HelloService {
    private static final Logger LOG = LoggerFactory
            .getLogger(HelloServiceImpl.class);

    @Override
    public String sayHello(String user) {
        LOG.info("sayHello {}",user);
        return user;
    }

    @Override
    public String saySomething(String user) {
        LOG.info("saySomething {}",user);
        return user;
    }

    @Override
    public String chatting(String user) {
        sayHello(user);
        LOG.info("chatting {}",user);
        sayBye(user);
        return user;
    }

    @Override
    public String sayBye(String user) {
        LOG.info("sayBye {}",user);
        return user;
    }
}
