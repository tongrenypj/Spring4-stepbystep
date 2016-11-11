/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.service
 * @file DemoModelService.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-11-22
 */
package com.stepbystep.spring.samples.mvcdemo.service;

import org.apache.ibatis.session.RowBounds;
import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;

import java.util.List;

/**
 * <code>DemoModelService</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-11-22
 */
public interface DemoModelService {

//    @Autowired
//    private DemoModelMapper demoModelMapper;
//
//    public void setDemoModelMapper(DemoModelMapper demoModelMapper) {
//        this.demoModelMapper = demoModelMapper;
//    }

    /**
     * <code>findAll</code>
     *
     * @return the list
     *
     * @author junming.wang
     * @since 1.0 2014-11-22
     */
    public List<DemoModel> findAll();

    /**
     * <code>findAll</code>
     *
     * @param rowBounds the row bounds
     * @return the list
     * @author junming.wang
     * @since 1.0 2014-12-05
     */
    public List<DemoModel> findAll(RowBounds rowBounds);

    /**
     * <code>findById</code>
     *
     * @param id
     *         the id
     *
     * @return the demo model
     *
     * @author junming.wang
     * @since 1.0 2014-11-22
     */
    public DemoModel findById(Long id);

    /**
     * <code>save</code>
     *
     * @param model the model
     * @return the demo model
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    public DemoModel save(DemoModel model);

    /**
     * <code>update</code>
     *
     * @param model the model
     * @return the demo model
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    public DemoModel update(DemoModel model) ;
}
