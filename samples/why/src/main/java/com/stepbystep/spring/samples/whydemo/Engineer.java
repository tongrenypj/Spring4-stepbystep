/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring.samples.whydemo
 * @file Engineer.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-31
 */
package com.stepbystep.spring.samples.whydemo;

/**
 * <code>Engineer</code>
 *
 * 攻城狮
 * @version 1.0
 * @since 1.0 2016-05-31
 */
public interface  Engineer {
    /**
     *
     * @return 姓名
     */
    String getName();
    /**
     *去上班
     *
     * 攻城狮具有去上班的功能
     */
    void goToWork();
}
