package com.hjrpc.springframework.beans.factory.config;

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
