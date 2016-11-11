package org.springframework.samples.petclinic.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * <code>HelloControllerTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/business-config.xml", "classpath:spring/tools-config.xml", "classpath:spring/mvc-core-config.xml"})
@WebAppConfiguration
@ActiveProfiles("spring-data-jpa")
public class HelloControllerTest {
    @Autowired
    private SimpleMappingExceptionResolver simpleMappingExceptionResolver;
    @Autowired
    private HelloController helloController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
            .standaloneSetup(helloController)
            .setHandlerExceptionResolvers(simpleMappingExceptionResolver)
//            .standaloneSetup(new HelloController())
//            .setHandlerExceptionResolvers(new SimpleMappingExceptionResolver())
            .build();
    }
    @Test
    public void testJson() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/hello/json"))
            .andExpect(status().isOk());
        resultActions.andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testJson2() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/hello/json2").param("description","description"))
            .andExpect(status().isOk());
        resultActions.andDo(MockMvcResultHandlers.print());
    }
   @Test
    public void testJson2Error() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/hello/json2"))
            .andExpect(status().isOk());
        resultActions.andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void testView2() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/hello/view2").param("description","description"))
            .andExpect(status().isOk());
        resultActions.andDo(MockMvcResultHandlers.print());
    }
   @Test
    public void testView2Error() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/hello/view2"))
            .andExpect(status().isOk());
        resultActions.andDo(MockMvcResultHandlers.print());
    }
}
