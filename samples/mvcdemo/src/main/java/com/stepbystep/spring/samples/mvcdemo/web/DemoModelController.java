/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.web
 * @file DemoModelController.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-11-22
 */
package com.stepbystep.spring.samples.mvcdemo.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.ibatis.session.RowBounds;
import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import com.stepbystep.spring.samples.mvcdemo.service.DemoModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <code>DemoModelController</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-11-22
 */
@Controller
@RequestMapping("/demo")
public class DemoModelController {

    private static final Logger LOG = LoggerFactory
            .getLogger(DemoModelController.class);

    @Autowired
    private DemoModelService demoModelService;

    public void setDemoModelService(DemoModelService demoModelService) {
        this.demoModelService = demoModelService;
    }
    /**
     * <code>listView</code>
     *
     * 列表查询
     * @param map the map
     * @param rowBounds the row bounds
     * @return the list
     * @author junming.wang
     * @since 1.0 2014-12-05
     */
    @RequestMapping(value = "/list",
            method = {RequestMethod.GET},
            consumes = {MediaType.ALL_VALUE},
            produces = {MediaType.TEXT_HTML_VALUE})
    @ModelAttribute("list")
    public List<DemoModel> listView(@RequestParam Map<String,String> map,
                                    RowBounds rowBounds) {
        if(rowBounds!=null){
            LOG.info("rowbunds.offset = {}",rowBounds.getOffset());
            LOG.info("rowbunds.limit = {}",rowBounds.getLimit());
        }
        if(map!=null){
            LOG.info("map = {}",map);
        }
        return demoModelService.findAll(rowBounds);
    }


    /**
     * <code>save</code>
     *
     * @param model the model
     * @return the demo model
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    @RequestMapping(value = "/", method = {RequestMethod.POST})
    @ResponseBody
    public DemoModel save(@ModelAttribute("demo")DemoModel model) {
        return demoModelService.save(model);
    }
    /**
     * <code>list</code>
     *
     * @return the list
     *
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET},produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<DemoModel> list(RowBounds rowBounds) {
        if(rowBounds!=null){
            LOG.info("rowbunds.offset = {}",rowBounds.getOffset());
            LOG.info("rowbunds.limit = {}",rowBounds.getLimit());
        }
        return demoModelService.findAll();
    }
    /**
     * <code>get</code>
     *
     * @param id
     *         the id
     *
     * @return the demo model
     *
     * @author junming.wang
     * @since 1.0 2014-11-22
     */
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public DemoModel get(@PathVariable(value = "id") Long id) {
        return demoModelService.findById(id);
    }
    /**
     * <code>pudate</code>
     *
     * @param model the model
     * @return the demo model
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    @ResponseBody
    public DemoModel udate(@PathVariable(value = "id") Long id, @ModelAttribute("demo")DemoModel model) {
        LOG.info("pudate id = {}",id);
        model.setId(id);
        return demoModelService.update(model);
    }
    /**
     * <code>delete</code>
     *
     * @param id the id
     * @return the int
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    @ResponseBody
    public int delete(@PathVariable(value = "id") Long id) {
        LOG.info("pudate id = {}", id);
//        return demoModelService..update(model);
        return 1;
    }


    /**
     * <code>show</code>
     * demo model *
     *
     * @param id
     *         the id
     *
     * @return the demo model
     *
     * @author junming.wang
     * @since 1.0 2014-11-22
     */
    @RequestMapping(value = "/show")
    @ResponseBody
    public DemoModel show(@RequestParam(value = "id", required = false) Long id) {
        return demoModelService.findById(id);
    }

    /**
     * <code>showStatus</code>
     * <p/>
     * 纯文本输出
     *
     * @param id
     *         the id
     *
     * @return the string
     *
     * @author junming.wang
     * @since 1.0 2014-11-27
     */
    @RequestMapping(value = "/show_status", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String showStatus(@RequestParam(value = "id", required = false) Long id) {
        return "SUCESS";
    }


    /**
     * <code>save</code>
     *
     * @param model
     *         the model
     *
     * @return the demo model
     *
     * @author junming.wang
     * @since 1.0 2014-11-27
     */
    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public DemoModel save(@ModelAttribute(value = "model") DemoModel model, @RequestParam(value = "flag", required = false, defaultValue = "1") int flag) {
        LOG.info("flag = {}", flag);
        LOG.info("model = {}", ToStringBuilder.reflectionToString(model));
        return model;
    }
    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public DemoModel error(@ModelAttribute(value = "model") DemoModel model) {
        if(true){
            throw new RuntimeException("only exception test");
        }
        return model;
    }

    /**
     * <code>handlerRuntimeException</code>
     *
     * 自定义异常处理
     * @param e the e
     * @return the response entity
     * @author junming.wang
     * @since 1.0 2014-12-03
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRuntimeException(RuntimeException e){
    ResponseEntity<String> responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        LOG.info(e.getMessage(),e);
    return   responseEntity;
    }

    /**
     * <code>initBinder</code>
     *
     * 自定义数据绑定
     * @param binder the binder
     * @author junming.wang
     * @since 1.0 2014-12-03
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

//    /**
//     * <code>exceptionHandler</code>
//     *
//     * @param e the e
//     * @return the string
//     * @author junming.wang
//     * @since 1.0 2014-12-07
//     */
//    @ExceptionHandler({ Exception.class, RuntimeException.class })
//    @ResponseBody
//    public ResponseEntity<String> exceptionHandler(Exception e) {
//        LOG.warn(e.getMessage(), e);
//        ResponseEntity<String> entity = new ResponseEntity<String>("some error", HttpStatus.OK);
//        return entity;
//    }

}
