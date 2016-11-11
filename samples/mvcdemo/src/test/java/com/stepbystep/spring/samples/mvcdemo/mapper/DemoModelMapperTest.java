package com.stepbystep.spring.samples.mvcdemo.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.RowBounds;
import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;

@ContextConfiguration(locations = {"classpath:spring/mybatis.xml","classpath:spring/property.xml",
        "classpath:spring/druid.xml"})
public class DemoModelMapperTest extends AbstractJUnit4SpringContextTests {
    private static final Logger LOG = LoggerFactory
            .getLogger(DemoModelMapperTest.class);

    @Autowired
    DemoModelMapper demoModelMapper;

    ObjectMapper objectMapper = new ObjectMapper();
    @org.junit.Test
    public void testDeleteByPrimaryKey() throws Exception {
        LOG.info("run");
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {

    }

    @Test
    public void testfindAll() throws Exception {
        RowBounds rowBounds = new RowBounds(0,5);
        List<DemoModel> list =demoModelMapper.findAll(rowBounds);
        for (int i = 0; i < list.size(); i++) {
            DemoModel demoModel = list.get(i);
            LOG.info("demoModel {} = {}",i, objectMapper.writeValueAsString(demoModel));
        }

//        objectMapper.writeValueAsString(demoModel)
        LOG.info("list.size = {}",list.size());
    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }
}