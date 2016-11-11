/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring.samples.whydemo
 * @file SubwayType.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-31
 */
package com.stepbystep.spring.samples.whydemo;

/**
 * <code>GoToWorkSubway</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-31
 */
public class SubwayType implements TrafficType {
    @Override
    public String trafficType() {
        return "乘地铁";
    }
}
