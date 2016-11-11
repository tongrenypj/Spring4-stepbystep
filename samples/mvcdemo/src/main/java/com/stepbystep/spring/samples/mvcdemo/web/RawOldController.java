/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.web
 * @file RawOldController.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-11-27
 */
package com.stepbystep.spring.samples.mvcdemo.web;

import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * <code>RawOldController</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-11-27
 */
@org.springframework.stereotype.Controller("/rawOld")
public class RawOldController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        DemoModel model = new DemoModel();
        model.setName("testName");
        model.setId(1l);
        model.setCreateTime(new Date());
        model.setLastModifiedTime(new Date());
        modelAndView.addObject("model",model);
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrefixJson(false);
        view.setPrettyPrint(true);
        modelAndView.setView(view);
        return modelAndView;
    }
}
