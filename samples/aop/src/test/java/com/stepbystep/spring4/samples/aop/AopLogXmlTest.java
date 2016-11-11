/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.aop
 * @file AopLogXmlTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package com.stepbystep.spring4.samples.aop;

import com.stepbystep.spring4.samples.aop.aspect.AopLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <code>AopLogXmlTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(locations =  {"classpath:/spring/aop.xml"})
public class AopLogXmlTest {
    private static final Logger LOG = LoggerFactory
            .getLogger(AopLogTest.class);
    @Autowired
    private HelloProvider helloService;
    @Test
    public void testHello(){
        LOG.info("=======start");
        helloService.sayHello("tom");
        LOG.info("=======end");
    }
    @Test
    public void testchatting(){
        LOG.info("=======start");
        helloService.chatting("tom");
        LOG.info("=======end");
    }

}
