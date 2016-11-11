/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.support
 * @file DurationHandlerInterceptor.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-12-07
 */
package com.stepbystep.spring.samples.mvcdemo.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <code>DurationHandlerInterceptor</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-12-07
 */
//implements HandlerInterceptor
public class DurationHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOG = LoggerFactory
            .getLogger(DurationHandlerInterceptor.class);
    private NamedThreadLocal<Long> durationTimeThreadLocal =
            new NamedThreadLocal<Long>(DurationHandlerInterceptor.class.getName());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();
        durationTimeThreadLocal.set(beginTime);
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        long beginTime = durationTimeThreadLocal.get();
        long durationTime = endTime - beginTime;
        //根据执行时长选择不同的日志级别输出
        if(durationTime>1000){
            LOG.error("the request : {} duration time : {} millis",request.getRequestURI(),durationTime);
        }else  if(durationTime>500){
            LOG.warn("the request : {} duration time : {} millis",request.getRequestURI(),durationTime);
        }else  if(durationTime>200){
            LOG.info("the request : {} duration time : {} millis",request.getRequestURI(),durationTime);
        }else {
            LOG.debug("the request : {} duration time : {} millis",request.getRequestURI(),durationTime);
        }

    }
}
