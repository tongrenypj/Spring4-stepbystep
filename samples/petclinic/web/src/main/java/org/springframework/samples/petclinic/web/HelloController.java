/*
 * @project spring-petclinic
 * @package org.springframework.samples.petclinic.web
 * @file HelloController.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-19
 */
package org.springframework.samples.petclinic.web;

import com.google.common.collect.ImmutableMap;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * <code>HelloController</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @ResponseBody
    @RequestMapping("/json")
    public Object json(){
        return ImmutableMap.of("ref",true,"message","success");
    }

    @ResponseBody
    @RequestMapping("/json2")
    public Object json2(@Valid Visit visit){
        return ImmutableMap.of("ref",true,"message","success");
    }

    @RequestMapping("/view2")
    public Object view2(@Valid Visit visit){
        return ImmutableMap.of("ref",true,"message","success");
    }
}
