/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.web
 * @file DemoModel2ControllerTest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-11-23
 */
package com.stepbystep.spring.samples.mvcdemo.web;

import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import com.stepbystep.spring.samples.mvcdemo.service.DemoModelService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * <code>DemoModel2ControllerTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-11-23
 */
public class DemoModelControllerStandalOneTest {
    private static final Logger LOG = LoggerFactory
            .getLogger(DemoModelControllerStandalOneTest.class);

    private MockMvc mockMvc;

    private DemoModelController demoModelController;

    @Mock
    private DemoModelService demoModelService;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.demoModelController = new DemoModelController();
        this.demoModelController.setDemoModelService(this.demoModelService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.demoModelController).build();
    }

    @Test
    public void testShow() throws Exception {
        LOG.info("run");
        DemoModel demoModel = new DemoModel();
        demoModel.setId(1l);
        demoModel.setName("mockTest");
        Mockito.when(demoModelService.findById(1l)).thenReturn(demoModel);
        ResultActions ac = mockMvc.perform(MockMvcRequestBuilders.get("/demo/show?id=1").accept(MediaType.ALL));
        ac.andExpect(MockMvcResultMatchers.status().isOk());
        ac.andDo(MockMvcResultHandlers.print());
        LOG.info("end");
    }

}
