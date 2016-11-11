/*
 * @project showcase
 * @package com.stepbystep.spring.samples.mvcdemo
 * @file SpringMvcAPITest.java
 * @version  1.0
 * @author  junming.wang
 * @time 2014-11-23
 */
package com.stepbystep.spring.samples.mvcdemo;

import org.springframework.beans.factory.xml.DefaultNamespaceHandlerResolver;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.MvcNamespaceHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.*;
import org.springframework.web.servlet.mvc.support.ControllerBeanNameHandlerMapping;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


/**
 * <code>SpringMvcAPITest</code>
 *
 * @author junming.wang
 * @version 1.0
 * @since 1.0 2014-11-23
 */
public class SpringMvcAPITest {
    class MvcSupport {

        DispatcherServlet dispatcherServlet;
        WebApplicationContext webApplicationContext;
        XmlWebApplicationContext xmlWebApplicationContext;
        WebMvcConfigurationSupport webMvcConfigurationSupport;

        ModelAttributeMethodProcessor modelAttributeMethodProcessor;

        MvcNamespaceHandler mvcNamespaceHandler;

        // 直接选择相应的视图
        ParameterizableViewController parameterizableViewController;

        WebMvcConfigurationSupport webMvcConfigurationSupport2;

        //命名空间加载流程
        DefaultNamespaceHandlerResolver defaultNamespaceHandlerResolver;
    }

    class MvcHttp {
        //messageConverter
        HttpMessageConverter<String> httpMessageConverter;
        StringHttpMessageConverter stringHttpMessageConverter;
        ObjectToStringHttpMessageConverter objectToStringHttpMessageConverter;
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;


        ConversionService conversionService;
        DefaultFormattingConversionService defaultFormattingConversionService;

    }
    class MvcForTest{
        WebAppConfiguration webAppConfiguration;

        MockMvc mockMvc;
        MockMvcBuilders mockMvcBuilders;
        MockMvcRequestBuilders mockMvcRequestBuilders;
        MockMvcResultHandlers mockMvcResultHandlers;
        MockMvcResultMatchers mockMvcResultMatchers;

    }

    class MvcAnnotation {

        // since 2.5
        // @Controller：用于标识是处理器类；
        // @RequestMapping：请求到处理器功能方法的映射规则；
        // @RequestParam：请求参数到处理器功能处理方法的方法参数上的绑定；
        // @ModelAttribute：请求参数到命令对象的绑定；
        // @SessionAttributes：用于声明session级别存储的属性，放置在处理器类上，通常列出模型属性（如@ModelAttribute）对应的名称，则这些属性会透明的保存到session中；
        // @InitBinder：自定义数据绑定注册支持，用于将请求参数转换到命令对象属性的对应类型；

        // since 3.0
        // @CookieValue：cookie数据到处理器功能处理方法的方法参数上的绑定；
        // @RequestHeader：请求头（header）数据到处理器功能处理方法的方法参数上的绑定；
        // @RequestBody：请求的body体的绑定（通过HttpMessageConverter进行类型转换）；
        // @ResponseBody：处理器功能处理方法的返回值作为响应体（通过HttpMessageConverter进行类型转换）；
        // @ResponseStatus：定义处理器功能处理方法/异常处理器返回的状态码和原因；
        // @ExceptionHandler：注解式声明异常处理器；
        // @PathVariable：请求URI中的模板变量部分到处理器功能处理方法的方法参数上的绑定，从而支持RESTful架构风格的URI；

        // since 3.1
        // @EnableWebMvc
        // @Validated
        // @RequestPart
        EnableWebMvc enableWebMvc;
    }

    /**
     * <code>mvcMapping</code>
     *
     * Mapping相关API
     *
     * @version 1.0
     * @author wangjunming
     * @since 1.0 2014年10月17日
     */
    class MvcMapping {



        HandlerMapping handlerMapping;
        HandlerAdapter handlerAdapter;

        SimpleUrlHandlerMapping simpleUrlHandlerMapping;
        BeanNameUrlHandlerMapping beanNameUrlHandlerMapping;
        ControllerClassNameHandlerMapping controllerClassNameHandlerMapping;
        ControllerBeanNameHandlerMapping controllerBeanNameHandlerMapping;

        DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping;
        RequestMappingHandlerMapping requestMappingHandlerMapping;

    }

    /**
     * <code>MvcAdapter</code>
     *
     * Adapter相关API
     *
     * @version 1.0
     * @author wangjunming
     * @since 1.0 2014年10月17日
     */
    class MvcAdapter {
        HandlerAdapter handlerAdapter;
        // 扩展custom resolver 并自定义
        RequestMappingHandlerAdapter requestMappingHandlerAdapter;
        // private List<HandlerMethodArgumentResolver>
        // getDefaultArgumentResolvers()
        // DefaultServletHttpRequestHandler defaultServletHttpRequestHandler;
        AnnotationMethodHandlerAdapter methodHandlerAdapter;
        ServletInvocableHandlerMethod servletInvocableHandlerMethod;

        // 根据返回值获取相应的 ReturnValueHandler
        HandlerMethodReturnValueHandler handlerMethodReturnValueHandler;

        HandlerMethodReturnValueHandlerComposite handlerMethodReturnValueHandlerComposite;
        // 处理包含@ResponseBody 的返回值 Bean默认序列化为json渲染到前端
        RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor;
        // AnnotationMethodHandlerAdapter.ServletHandlerMethodInvoker.getModelAndView
        // 根据returnValue判断View
    }

    /**
     * <code>MvcModelAndView</code>
     *
     * @author junming.wang
     * @since 1.0 2014-11-30
     */
    class MvcModelAndView{
        ModelAndView modelAndView
                ;
        ModelAndViewContainer modelAndViewContainer;
        ModelAndViewResolverMethodReturnValueHandler modelAndViewResolverMethodReturnValueHandler;
        View view;
        MappingJackson2JsonView mappingJackson2JsonView;
        ViewResolver viewResolver;
        InternalResourceViewResolver internalResourceViewResolver;

        PathExtensionContentNegotiationStrategy pathExtensionContentNegotiationStrategy;
    }

    /**
     * <code>MvcException</code>
     *
     * 异常处理相关的类
     *
     * @version 1.0
     * @author wangjunming
     * @since 1.0 2014年10月22日
     */
    class MvcException {
        HandlerExceptionResolver exceptionResolver;
        ResponseStatusExceptionResolver responseStatusExceptionResolver;

        AnnotationMethodHandlerExceptionResolver annotationMethodHandlerExceptionResolver;
        ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver;

        DefaultHandlerExceptionResolver defaultHandlerExceptionResolver;
        SimpleMappingExceptionResolver simpleMappingExceptionResolver;
    }



}
