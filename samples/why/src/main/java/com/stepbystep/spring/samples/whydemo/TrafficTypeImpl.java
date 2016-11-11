/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring.samples.whydemo
 * @file TrafficTypeImpl.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-31
 */
package com.stepbystep.spring.samples.whydemo;

/**
 * <code>TrafficTypeImpl</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-31
 */
public class TrafficTypeImpl implements TrafficType {

    private String trafficType = "步行";

    public TrafficTypeImpl() {
    }

    public TrafficTypeImpl(String trafficType) {
        this.trafficType = trafficType;
    }

    @Override
    public String trafficType() {
        return trafficType;
    }
}
