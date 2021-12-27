package com.hjrpc.springframework.beans.factory;

import com.hjrpc.springframework.beans.BeansException;
import com.hjrpc.springframework.beans.factory.aware.Aware;

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}