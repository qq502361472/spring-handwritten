package com.hjrpc.springframework.context;

import com.hjrpc.springframework.beans.factory.HierarchicalBeanFactory;
import com.hjrpc.springframework.beans.factory.ListableBeanFactory;
import com.hjrpc.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
