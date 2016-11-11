package org.springframework.samples.petclinic.service;

import com.stepbystep.spring4.samples.datasource.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.samples.petclinic.SpringDataJpaApplication;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

/**
 * <p> Integration test using the 'Spring Data' profile.
 *
 * @author Michael Isvy
 * @see AbstractClinicServiceTests AbstractClinicServiceTests for more details. </p>
 */

//@ContextConfiguration(locations = {"classpath:spring/dataSource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(
        locations = {"classpath:spring/dataSource.xml"},
        classes = {SpringDataJpaApplication.class})
@ActiveProfiles(value = {"hsql","springdatajpa"})
public class ClinicServiceSpringDataJpaTests extends AbstractClinicServiceTests {
//public class ClinicServiceSpringDataJpaTests {
    private static final Logger LOG = LoggerFactory
            .getLogger(ClinicServiceSpringDataJpaTests.class);
    @Autowired
    private ClinicService clinicService;
    @Test
    public void test1(){
        Collection<PetType> petTypes = clinicService.findPetTypes();
        LOG.info("petTypes = {}",petTypes);
    }
}
