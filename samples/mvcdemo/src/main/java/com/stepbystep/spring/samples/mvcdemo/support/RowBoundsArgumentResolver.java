/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo.support
 * @file RowBoundsArgumentResolver.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-12-02
 */
package com.stepbystep.spring.samples.mvcdemo.support;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * <code>RowBoundsArgumentResolver</code>
 *
 * RowBounds 解析为RowBounds对象
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-12-02
 */
public class RowBoundsArgumentResolver implements HandlerMethodArgumentResolver,InitializingBean {
    private static final Logger LOG = LoggerFactory
            .getLogger(RowBoundsArgumentResolver.class);
    private ObjectMapper objectMapper =new ObjectMapper();

    //参数名称
    private String rowboundsParam = "rowbounds";
    private String limitParam = "limit";
    private String offsetParam = "offset";

    private static LoadingCache<String,RowBounds> loadingCache = CacheBuilder.newBuilder()
            .maximumSize(500).initialCapacity(10)
            .build(new CacheLoader<String,RowBounds>() {
        public RowBounds load(String key) throws RuntimeException {
            return keyPraseRowBound(key);
        }
    });
    private static RowBounds keyPraseRowBound(String key) {
        String[] keys = org.springframework.util.StringUtils.tokenizeToStringArray(key,"_");
        int offset = Integer.parseInt(keys[0]);
        int limit = Integer.parseInt(keys[1]);
        return new RowBounds(offset,limit);
    }
    public static RowBounds getRowBounds(int offset,int limit){
        RowBounds rowBounds = null;
        try {
            rowBounds = loadingCache.get(getKey(offset, limit));
        } catch (ExecutionException e) {
            LOG.error(e.getMessage(),e);
        }

        return rowBounds;
    }

    private static String getKey(int offset, int limit) {
        return offset + "_" + limit;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getRowboundsParam() {
        return rowboundsParam;
    }

    public void setRowboundsParam(String rowboundsParam) {
        this.rowboundsParam = rowboundsParam;
    }

    public String getOffsetParam() {
        return offsetParam;
    }

    public void setOffsetParam(String offsetParam) {
        this.offsetParam = offsetParam;
    }

    public String getLimitParam() {
        return limitParam;
    }

    public void setLimitParam(String limitParam) {
        this.limitParam = limitParam;
    }


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> paramType = parameter.getParameterType();
        return RowBounds.class.isAssignableFrom(paramType);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String rowboundsValue =webRequest.getParameter(this.getRowboundsParam());
        RowBounds rowBounds = null;
        try {
            if(StringUtils.isNotBlank(rowboundsValue)){
                rowBounds = getRowBounds(rowboundsValue);
            }else{
                rowBounds =getRowbounds(webRequest);
            }
        } catch (Exception e) {
            LOG.info(e.getMessage(),e);
        }
        if(rowBounds==null){
            rowBounds= new RowBounds(0,30);
        }
        return  rowBounds;
    }

    /**
     * <code>getRowbounds</code>
     *
     * by offset and limit
     * @param webRequest the web request
     * @return the rowbounds
     * @author junming.wang
     * @since 1.0 2014-12-05
     */
    private RowBounds getRowbounds(NativeWebRequest webRequest) {
        Integer offset = readAsInt(webRequest.getParameter(this.getOffsetParam()));
        Integer limit = readAsInt(webRequest.getParameter(this.getLimitParam()));
        return getRowBounds(offset==null?RowBounds.NO_ROW_OFFSET:offset.intValue(),limit==null?RowBounds.NO_ROW_LIMIT:limit.intValue());
    }

    /**
     * <code>getRowBounds</code>
     *
     * by {"offset",0,"limit":20}
     * @param rowbounds the rowbounds
     * @return the row bounds
     * @throws IOException the iO exception
     * @author junming.wang
     * @since 1.0 2014-12-05
     */
    private RowBounds getRowBounds(String rowbounds) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(rowbounds);
        JsonNode offset1 = jsonNode.get(this.getOffsetParam());
        JsonNode limit1 = jsonNode.get(this.getLimitParam());
        return getRowBounds(offset1!=null&&offset1.isInt()?offset1.intValue():0,limit1!=null&&limit1.isInt()?limit1.intValue():100);
    }

    private Integer readAsInt(String text){
        if(StringUtils.isNotBlank(text)){

            try {
                Integer v = NumberUtils.createInteger(text);
                return  v;
            } catch (Exception e) {
                LOG.warn(e.getMessage(),e);
            }
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(this.objectMapper==null){
            this.objectMapper = new ObjectMapper();
        }
    }
}
