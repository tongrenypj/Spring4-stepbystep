/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring.samples.whydemo
 * @file BusType.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-31
 */
package com.stepbystep.spring.samples.whydemo;

/**
 * <code>BusType</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-31
 */
public class BusType implements TrafficType {
    @Override
    public String trafficType() {
        return "乘公交车";
    }
}
