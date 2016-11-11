/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.support
 * @file PlaintStringView.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-12-04
 */
package com.stepbystep.spring.samples.mvcdemo.support;

import com.google.common.base.Charsets;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * <code>PlaintStringView</code>
 *
 * 输出 纯文本 字符串
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-12-04
 */
public class PlaintStringView extends AbstractView {
    private String plaint;
    private StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
    public PlaintStringView(String plaint) {
        this.plaint = plaint;
        this.setContentType("text/plain;charset=UTF-8");
    }
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
     // byResponse(response);
        byConverter(response);
    }
    private void byConverter(HttpServletResponse response) throws IOException {
        ServletServerHttpResponse servletServerHttpResponse = new ServletServerHttpResponse(response);
        converter.setWriteAcceptCharset(false);
        converter.write(plaint, MediaType.parseMediaType(getContentType()),servletServerHttpResponse);
    }

    private void byResponse(HttpServletResponse response) throws IOException {
        response.setContentType(this.getContentType());
        response.setCharacterEncoding(Charsets.UTF_8.name());
        response.getWriter().println(plaint);
        response.getWriter().flush();
    }

}
