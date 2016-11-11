/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring4.samples.beans
 * @file HelloService.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package com.stepbystep.spring4.samples.beans;

/**
 * <code>HelloService</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
public interface HelloService {

    public String sayHello(String user);
    public String saySomething(String user);
    public String chatting(String user);
    public String sayBye(String user);
}
