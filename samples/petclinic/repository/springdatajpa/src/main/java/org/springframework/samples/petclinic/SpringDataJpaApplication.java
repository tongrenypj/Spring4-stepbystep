/*
 * @project spring4-stepbystep
 * @package org.springframework.samples.petclinic.repository.springdatajpa
 * @file SpringDataJpaApplication.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-14
 */
package org.springframework.samples.petclinic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

/**
 * <code>SpringDataJpaApplication</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-14
 */
//@Configuration
//@EnableJpaRepositories
@SpringBootApplication
@Profile("springdatajpa")
public class SpringDataJpaApplication {

}
