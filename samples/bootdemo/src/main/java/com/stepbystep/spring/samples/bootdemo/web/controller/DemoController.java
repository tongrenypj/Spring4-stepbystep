/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring.samples.bootdemo.web.controller
 * @file DemoController.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-24
 */
package com.stepbystep.spring.samples.bootdemo.web.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <code>DemoController</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-24
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/")
    public String index(){
        return "Hello Spring boot";
    }
    @RequestMapping("/list")
    public List<? extends Map<String,String>> list(){
        return Lists.newArrayList(ImmutableMap.of("name","test"));
    }
}
