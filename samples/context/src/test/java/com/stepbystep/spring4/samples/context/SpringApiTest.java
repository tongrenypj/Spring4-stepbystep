package com.stepbystep.spring4.samples.context;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * <code>SpringApiTest</code>
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-7-7
 */
public class SpringApiTest {




	public void aboutProperties(){
		//属性配置文件加载方式
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer;


		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer;
		PropertyOverrideConfigurer propertyOverrideConfigurer;
		PropertiesFactoryBean propertiesFactoryBean;

	}
	public void aboutXml(){
		XmlBeanDefinitionReader xmlBeanDefinitionReader;
		DefaultBeanDefinitionDocumentReader defaultBeanDefinitionDocumentReader;
		BeanDefinitionParserDelegate beanDefinitionParserDelegate;

		//xml namespace
		NamespaceHandler namespaceHandler;
		PluggableSchemaResolver pluggableSchemaResolver;
		DefaultNamespaceHandlerResolver defaultNamespaceHandlerResolver;
		DefaultBeanDefinitionDocumentReader beanDefinitionDocumentReader;
		ClassPathXmlApplicationContext classPathXmlApplicationContext;
	}

	public void aboutAnnotation(){
//		ConfigurationClass
//		ConfigurationClassParser
//		ConfigurationClassBeanDefinitionReader
		Configuration configuration;
		ComponentScan componentScan;
		ImportResource importResource;
		ConfigurationClassPostProcessor configurationClassPostProcessor;

		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor;
		RequiredAnnotationBeanPostProcessor requiredAnnotationBeanPostProcessor;
		CommonAnnotationBeanPostProcessor commonAnnotationBeanPostProcessor;

//		BeanAnnotationHelper beanAnnotationHelper;
//		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext;
	}
}
