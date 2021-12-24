package com.hjrpc.springframework.beans.factory.support;

import com.hjrpc.springframework.beans.BeansException;
import com.hjrpc.springframework.core.io.Resource;
import com.hjrpc.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    /**
     * 获取资源加载器
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 获取bean定义的注册器
     * @return
     */
    BeanDefinitionRegistry getBeanDefinitionRegistry();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... configLocations);
}
