package com.hjrpc.springframework.beans.factory;

import com.hjrpc.springframework.beans.factory.aware.Aware;

public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);

}