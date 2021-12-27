package com.hjrpc.springframework.context;

import com.hjrpc.springframework.beans.BeansException;
import com.hjrpc.springframework.beans.factory.aware.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}