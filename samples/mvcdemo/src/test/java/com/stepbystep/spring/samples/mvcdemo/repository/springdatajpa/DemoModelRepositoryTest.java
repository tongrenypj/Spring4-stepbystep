package com.stepbystep.spring.samples.mvcdemo.repository.springdatajpa;

import com.stepbystep.spring.samples.mvcdemo.DemoModelApplication;
import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * <code>DemoModelRepositoryTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DemoModelApplication.class})
public class DemoModelRepositoryTest {

    @Resource
    private DemoModelRepository demoModelRepository;

    @Test
    public void testSelect(){
        demoModelRepository.findAll();
    }
    @Test
    public void testSave(){
        DemoModel demoModel = new DemoModel();
        demoModel.setName("test");
        demoModel.setDescription("test");
        demoModel.setCreateTime(new Date());
        demoModel.setLastModifiedTime(new Date());
        demoModelRepository.save(demoModel);
    }
}