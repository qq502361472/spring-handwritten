package com.hjrpc.springframework.beans.factory;

import com.hjrpc.springframework.beans.factory.aware.Aware;

public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}