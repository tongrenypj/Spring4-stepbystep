/*
 * @project spring4-stepbystep
 * @package com.stepbystep.spring.samples.mvcdemo.repository.springdatajpa
 * @file DemoModelRepository.java
 * @version  1.0
 * @author  junming.wang
 * @time 2016-05-23
 */
package com.stepbystep.spring.samples.mvcdemo.repository.springdatajpa;


import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * <code>DemoModelRepository</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2016-05-23
 */
public interface DemoModelRepository extends JpaRepository<DemoModel,Long> {

}
