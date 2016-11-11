/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.mapper
 * @file DemoModelMapper.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-11-22
 */
package com.stepbystep.spring.samples.mvcdemo.mapper;

import org.apache.ibatis.session.RowBounds;
import com.stepbystep.spring.samples.mvcdemo.model.DemoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <code>DemoModelMapper</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-11-22
 */
@Repository
public interface DemoModelMapper {

    int deleteByPrimaryKey(Long id);

    DemoModel selectByPrimaryKey(Long id);

    List<DemoModel> findAll();

    List<DemoModel> findAll(RowBounds rowBounds);

    int insert(DemoModel record);

    int updateByPrimaryKey(DemoModel record);
}
