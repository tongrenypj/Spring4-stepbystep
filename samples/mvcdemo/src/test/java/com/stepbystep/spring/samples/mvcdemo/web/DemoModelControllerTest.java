package com.stepbystep.spring.samples.mvcdemo.web;

import com.google.common.collect.Lists;
import org.apache.ibatis.session.RowBounds;
import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import com.stepbystep.spring.samples.mvcdemo.service.DemoModelService;
import com.stepbystep.spring.samples.mvcdemo.support.RowBoundsArgumentResolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//"classpath:spring/mvc/mvc-ftl.xml",
//        "classpath:spring/mvc/controller.xml",
@ContextConfiguration(locations = {
        "classpath:spring/mockito_service.xml",
        "classpath:spring/mvc/mvc-th.xml",
//        "classpath:spring/mvc/mvc-ftl.xml",
//        "classpath:spring/mvc/mvc-vm.xml",
        "classpath:spring/mvc/mvc.xml"})
@WebAppConfiguration
public class DemoModelControllerTest extends AbstractJUnit4SpringContextTests {
    private static final Logger LOG = LoggerFactory
            .getLogger(DemoModelControllerTest.class);
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private DemoModelService demoModelService;
    private MockMvc mockMvc;
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void testList1() throws Exception {
        //Mock service服务
        List<DemoModel> list = getDemoModels();
        RowBounds rowBounds = RowBoundsArgumentResolver.getRowBounds(0,5);
        Mockito.when(demoModelService.findAll(rowBounds)).thenReturn(list);
        //Mock request请求
        MockHttpServletRequestBuilder builder = get("/demo/list");
        builder.param("name","Qunar");
        builder.param("offset","0");
        builder.param("limit","5");
        builder.accept(MediaType.TEXT_HTML);
        ResultActions ac = mockMvc.perform(builder);
        //输出测试信息
        ac.andDo(print());
        //断言校验
        ac.andExpect(status().isOk());
        ac.andExpect(MockMvcResultMatchers.view().name("demo/list"));
        ac.andExpect(MockMvcResultMatchers.model().attributeExists("list"));
    }

    /**
     * <code>testget</code>
     *
     * @throws Exception
     *         the exception
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    @Test
    public void testGet() throws Exception {
        LOG.info("run");
        DemoModel demoModel = new DemoModel();
        demoModel.setId(1l);
        demoModel.setName("testName");
        Mockito.when(demoModelService.findById(1l)).thenReturn(demoModel);
        ResultActions ac = mockMvc.perform(get("/demo/1").accept(MediaType.ALL));
        ac.andExpect(status().isOk());
        ac.andDo(print());
        LOG.info("end");
    }

    @Test
    public void testList() throws Exception {
        LOG.info("run");
        List<DemoModel> list = getDemoModels();
        Mockito.when(demoModelService.findAll()).thenReturn(list);
        ResultActions ac = mockMvc.perform(get("/demo/").accept(MediaType.APPLICATION_JSON));
        ac.andDo(print());
        ac.andExpect(status().isOk());
        LOG.info("end");
    }
   @Test
    public void testList2() throws Exception {
        LOG.info("run");
       List<DemoModel> list = getDemoModels();
        Mockito.when(demoModelService.findAll()).thenReturn(list);
        ResultActions ac = mockMvc.perform(get("/demo/?offset=0&limit=100").accept(MediaType.APPLICATION_JSON));
        ac.andDo(print());
        ac.andExpect(status().isOk());
        LOG.info("end");
    }

    private List<DemoModel> getDemoModels() {
        DemoModel demoModel = new DemoModel();
        demoModel.setId(1l);
        demoModel.setName("test世界");
        return getDemoModels(demoModel);
    }

    private List<DemoModel> getDemoModels(DemoModel demoModel) {
        List<DemoModel> list = Lists.newArrayList();
        list.add(demoModel);
        list.add(demoModel);
        list.add(demoModel);
        list.add(demoModel);
        list.add(demoModel);
        return list;
    }

    @Test
    public void testError() throws Exception {
        LOG.info("run");
        ResultActions ac = mockMvc.perform(get("/demo/error").accept(MediaType.TEXT_HTML));
        ac.andDo(print());
        //417
        ac.andExpect(status().is(HttpStatus.EXPECTATION_FAILED.value()));
        LOG.info("end");
    }
    @Test
    public void testShow() throws Exception {
        LOG.info("run");
        DemoModel demoModel = new DemoModel();
        demoModel.setId(1l);
        demoModel.setName("testName");
        Mockito.when(demoModelService.findById(1l)).thenReturn(demoModel);
        ResultActions ac = mockMvc.perform(get("/demo/show?id=1").accept(MediaType.ALL));
        ac.andExpect(status().isOk());
        ac.andDo(print());
        LOG.info("end");
    }

    @Test
    public void testShowStatus() throws Exception {
        LOG.info("run");
        ResultActions ac = mockMvc.perform(get("/demo/show_status").accept(MediaType.ALL));
        ac.andExpect(status().isOk());
        ac.andDo(print());
        LOG.info("end");

    }

    @Test
    public void testSave() throws Exception {
        LOG.info("run");
        ResultActions ac = mockMvc.perform(get("/demo/save?flag=").accept(MediaType.ALL));
        ac.andDo(print());
        ac.andExpect(status().isOk());
        LOG.info("end");
    }

    @Test
    public void testSave1() throws Exception {
        LOG.info("run");
        ResultActions ac = mockMvc.perform(get("/demo/save")
                .param("name","test")
                .param("lastModifiedTime","2016-08-01")
                .param("createTime","2016-08-12").accept(MediaType.ALL));
        ac.andDo(print());
        ac.andExpect(status().isOk());
        LOG.info("end");
    }
}