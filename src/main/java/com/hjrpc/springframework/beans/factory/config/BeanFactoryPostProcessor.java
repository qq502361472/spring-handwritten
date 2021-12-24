package com.hjrpc.springframework.beans.factory.config;

import com.hjrpc.springframework.beans.BeansException;
import com.hjrpc.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
