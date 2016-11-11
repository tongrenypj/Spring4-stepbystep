package org.springframework.samples.petclinic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * <code>JdbcApplicationTest</code>
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
public class JdbcApplicationTest {
    private static final Logger LOG = LoggerFactory
            .getLogger(JdbcApplicationTest.class);
    @Autowired
    private PetRepository petRepository;

    @Test
    public  void test1(){
        List<PetType> petTypes = petRepository.findPetTypes();
        LOG.info("petTypes = {}",petTypes );
    }
}