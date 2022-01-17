package com.hjrpc.springframework.beans.factory.support;

import com.hjrpc.springframework.beans.BeansException;
import com.hjrpc.springframework.beans.factory.DisposableBean;
import com.hjrpc.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    protected static final Object NULL_OBJECT = new Object();
    Map<String, Object> singletonObjects = new HashMap<>();
    Map<String, DisposableBean> disposableBeanMap = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    protected void registerDisposableBean(String beanName, DisposableBeanAdapter disposableBeanAdapter) {
        disposableBeanMap.put(beanName, disposableBeanAdapter);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeanMap.keySet();
        Object[] disposableBeanName = keySet.toArray();

        for (int i = disposableBeanName.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanName[i];
            DisposableBean disposableBean = disposableBeanMap.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
