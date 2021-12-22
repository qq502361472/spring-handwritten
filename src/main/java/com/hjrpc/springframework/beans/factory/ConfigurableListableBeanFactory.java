package com.hjrpc.springframework.beans.factory;

import com.hjrpc.springframework.beans.BeansException;
import com.hjrpc.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.hjrpc.springframework.beans.factory.config.BeanDefinition;
import com.hjrpc.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
