package com.stepbystep.spring4.samples.aop;

import com.stepbystep.spring4.samples.aop.proxy.CglibProxy;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>HelloServiceImplTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
public class CglibProxyTest {

    private static final Logger LOG = LoggerFactory
            .getLogger(CglibProxyTest.class);
    @Test
    public void testSayHello(){
        LOG.info("=======start");
        HelloServiceImpl helloServiceImpl = getHelloServiceProxy();
        helloServiceImpl.sayHello("tom");
        LOG.info("=======end");
    }
    @Test
    public void testChatting(){
        LOG.info("=======start");
        HelloServiceImpl helloServiceImpl = getHelloServiceProxy();
        helloServiceImpl.chatting("tom");
        LOG.info("=======end");
    }

    private static HelloServiceImpl getHelloServiceProxy() {
        return CglibProxy.createProxy(new HelloServiceImpl());
    }
}