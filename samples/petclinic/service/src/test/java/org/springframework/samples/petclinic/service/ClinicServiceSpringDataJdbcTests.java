/*
 * @project spring4-stepbystep
 * @package org.springframework.samples.petclinic.service
 * @file ClinicServiceSpringDataJdbcTests.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-07-20
 */
package org.springframework.samples.petclinic.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.samples.petclinic.JdbcApplication;
import org.springframework.samples.petclinic.SpringDataJpaApplication;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

/**
 * <code>ClinicServiceSpringDataJdbcTests</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-07-20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(
        locations = {"classpath:spring/dataSource.xml"},
        classes = {JdbcApplication.class})
@ActiveProfiles(value = {"hsql","jdbc"})
public class ClinicServiceSpringDataJdbcTests extends AbstractClinicServiceTests {
    private static final Logger LOG = LoggerFactory
            .getLogger(ClinicServiceSpringDataJdbcTests.class);
    @Autowired
    private ClinicService clinicService;
    @Test
    public void test1(){
        Collection<PetType> petTypes = clinicService.findPetTypes();
        LOG.info("petTypes = {}",petTypes);
    }
}
