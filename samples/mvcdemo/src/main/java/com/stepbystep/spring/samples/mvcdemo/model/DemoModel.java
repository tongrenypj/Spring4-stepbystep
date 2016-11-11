/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.model
 * @file DemoModel.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-11-22
 */
package com.stepbystep.spring.samples.mvcdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * <code>DemoModel</code>
 *
 * 演示模型对象
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-11-22
 */
@Entity
@Table(name = "t_demo_model")
public class DemoModel  implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Integer status;
    private String name;
    private String note;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date lastModifiedTime;

    public DemoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
