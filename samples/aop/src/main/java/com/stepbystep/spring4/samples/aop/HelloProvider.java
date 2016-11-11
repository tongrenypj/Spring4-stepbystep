/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.aop
 * @file HelloProvider.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package com.stepbystep.spring4.samples.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;

/**
 * <code>HelloProvider</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
public class HelloProvider {
    private static final Logger LOG = LoggerFactory
            .getLogger(HelloProvider.class);

    public String sayHello(String user) {
        LOG.info("sayHello {}",user);
        return user;
    }

    public String saySomething(String user) {
        LOG.info("saySomething {}",user);
        return user;
    }

    public String chatting(String user) {
        sayHello(user);
        LOG.info("chatting {}",user);
        if(null!= AopContext.currentProxy()){
            ((HelloProvider)AopContext.currentProxy()).sayBye(user);
        }else{
            sayBye(user);

        }
        return user;
    }

    public String sayBye(String user) {
        LOG.info("sayBye {}",user);
        return user;
    }
}
