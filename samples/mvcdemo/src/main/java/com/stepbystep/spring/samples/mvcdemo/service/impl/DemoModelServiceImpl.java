/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.service.impl
 * @file DemoModelServiceImpl.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-12-04
 */
package com.stepbystep.spring.samples.mvcdemo.service.impl;

import org.apache.ibatis.session.RowBounds;
import com.stepbystep.spring.samples.mvcdemo.mapper.DemoModelMapper;
import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import com.stepbystep.spring.samples.mvcdemo.service.DemoModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * <code>DemoModelServiceImpl</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-12-04
 */
@Service("demModelService")
public class DemoModelServiceImpl implements DemoModelService{
    @Autowired
    private DemoModelMapper demoModelMapper;

    public void setDemoModelMapper(DemoModelMapper demoModelMapper) {
        this.demoModelMapper = demoModelMapper;
    }

    /**
     * <code>findAll</code>
     *
     * @return the list
     *
     * @author junming.wang
     * @since 1.0 2014-11-22
     */
    public List<DemoModel> findAll() {
        return demoModelMapper.findAll();
    }

    @Override
    public List<DemoModel> findAll(RowBounds rowBounds) {
        return this.demoModelMapper.findAll(rowBounds);
    }

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
    public DemoModel findById(Long id) {
        return demoModelMapper.selectByPrimaryKey(id);
    }

    /**
     * <code>save</code>
     *
     * @param model the model
     * @return the demo model
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    public DemoModel save(DemoModel model){
        this.demoModelMapper.insert(model);
        return model;
    }

    /**
     * <code>update</code>
     *
     * @param model the model
     * @return the demo model
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    public DemoModel update(DemoModel model) {
        this.demoModelMapper.updateByPrimaryKey(model);
        return model;
    }
}
