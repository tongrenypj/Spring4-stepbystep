package org.springframework.samples.petclinic.repository.mybatis;

import com.stepbystep.spring4.samples.datasource.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.samples.petclinic.MybatisApplication;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * <code>MybatisApplicationTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration( classes = {MybatisApplication.class, DataSourceConfig.class})
@ActiveProfiles(value = {"druid","mybatis"})
public class MybatisApplicationTest {

    @Autowired
    private OwnerMapper ownerMapper;
    @Test
    public void test1(){
        Owner owner = new Owner();
        Collection<Owner> t = ownerMapper.findByLastName("T");

    }
}