package com.stepbystep.spring.samples.whydemo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <code>EngineerTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-31
 */
public class EngineerTest {

    @Test
    public void testEngineerZhang(){
        //原始硬编码代码

        Engineer engineer = new EngineerZhang();
        engineer.goToWork();
    }


    @Test
    public void testEngineerAny(){
        String name = "土豪攻城狮";
        TrafficType trafficType = new TrafficTypeImpl("自驾特斯拉");

        Engineer engineer = new EngineerAny(name,trafficType);
        engineer.goToWork();
    }
    @Test
    public void testEngineerAny1(){
        String name = "逗比攻城狮";
        TrafficType trafficType = new SubwayType();

        Engineer engineer = new EngineerAny(name,trafficType);
        engineer.goToWork();
    }
    @Test
    public void testEngineerAny2(){
        //原始硬编码代码
        String name = "逗比攻城狮";
        TrafficType trafficType = new BusType();

        Engineer engineer = new EngineerAny(name,trafficType);
        engineer.goToWork();
    }

    @Test
    public void testEngineerAnyBySpringXml(){
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring/beans.xml");

        Engineer engineerAny = applicationContext.getBean("engineerAny", Engineer.class);
        engineerAny.goToWork();
    }

}