package org.springframework.samples.petclinic.repository.springdatajpa;

import com.stepbystep.spring4.samples.datasource.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.SpringDataJpaApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * <code>SpringDataJpaApplicationTest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration( classes = {SpringDataJpaApplication.class, DataSourceConfig.class})
@ActiveProfiles(value = {"druid","springdatajpa"})
public class SpringDataJpaApplicationTest {

    private static final Logger LOG = LoggerFactory
            .getLogger(SpringDataJpaApplicationTest.class);
    @Autowired
    private SpringDataPetRepository springDataPetRepository;

    @Test
    public  void test1(){
        List<PetType> petTypes = springDataPetRepository.findPetTypes();
        LOG.info("petTypes = {}",petTypes );
    }
}