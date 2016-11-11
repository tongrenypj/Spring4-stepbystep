/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.beans
 * @file HelloRoom.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-22
 */
package com.stepbystep.spring4.samples.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * <code>HelloRoom</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-22
 */
public class HelloRoom {
//    private static final Logger LOG = LoggerFactory
//            .getLogger(HelloRoom.class);

    public HelloRoom() {
    }

    public HelloRoom(HelloService helloService) {
        this.helloService = helloService;
    }

    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public String sayHello(String user) {
        Assert.notNull(helloService,"helloService is null");
        return helloService.sayHello(user);
    }
}
