package com.stepbystep.spring.samples.mvcdemo.web;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * <code>WelcomeControllerTest</code>
 *
 * @author junming.wang
 * @since 1.0 2014-12-04
 */
@ContextConfiguration(locations = {
        "classpath:spring/mockito_service.xml",
        "classpath:spring/mvc/mvc.xml"})
@WebAppConfiguration
public class WelcomeControllerTest extends AbstractJUnit4SpringContextTests {
    private static final Logger LOG = LoggerFactory
            .getLogger(RawOldControllerTest.class);

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testWelcome() throws Exception {
        LOG.info("run");
        ResultActions ac = mockMvc.perform(MockMvcRequestBuilders.get("/welcome").accept(MediaType.ALL));
        ac.andDo(MockMvcResultHandlers.print());
        ac.andExpect(MockMvcResultMatchers.status().isOk());
        LOG.info("end");
    }
}