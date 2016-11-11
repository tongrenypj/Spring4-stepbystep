package com.stepbystep.spring.samples.mvcdemo.model;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

/**
 * <code>DemoModelTest</code>
 *
 * @author junming.wang
 * @since 1.0 2014-12-04
 */
public class DemoModelTest {
    private static final Logger LOG = LoggerFactory
            .getLogger(DemoModelTest.class);

    private String text = "中文";

    @Test
    public void testprint() {
        System.out.println("text = " + text);
        LOG.info("text = {}", text);
    }
    @Test
    public void testType() {
        MediaType mediaType = MediaType.parseMediaType("text/plain;charset=UTF-8");

        System.out.println("text = " + mediaType);
        LOG.info("text = {}", mediaType);
    }
}