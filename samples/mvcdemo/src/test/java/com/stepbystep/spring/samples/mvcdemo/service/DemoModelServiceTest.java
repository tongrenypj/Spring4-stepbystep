package com.stepbystep.spring.samples.mvcdemo.service;

import com.stepbystep.spring.samples.mvcdemo.mapper.DemoModelMapperTest;
import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <code>DemoModelServiceTest</code>
 *
 * @author junming.wang
 * @since 1.0 2014-11-22
 */
//@ContextConfiguration(locations = {"classpath:spring/mybatis.xml",
//        "classpath:spring/property.xml",
//        "classpath:spring/druid.xml"})
//public class DemoModelServiceTest extends AbstractJUnit4SpringContextTests {
public class DemoModelServiceTest {
    private static final Logger LOG = LoggerFactory
            .getLogger(DemoModelMapperTest.class);

    @Mock
    protected DemoModelService demoModelService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
//    @Test
//    public void testFindAll() throws Exception {
//        List<DemoModel> all = demoModelService.findAll();
//    }
    @Test
    public void testFindById() throws Exception {
        DemoModel demoModel = new DemoModel();
        demoModel.setId(1l);
        demoModel.setName("mockTest");
        //设置mock 对象行为
        Mockito.when(demoModelService.findById(1l)).thenReturn(demoModel);

        //执行findById
        DemoModel demoModel1 = demoModelService.findById(1l);

        //执行结果的校验
        Assert.assertEquals(demoModel,demoModel1);
        Mockito.verify(demoModelService).findById(1l);
        Mockito.verifyZeroInteractions(demoModelService);
        Mockito.verifyNoMoreInteractions(demoModelService);
    }
}