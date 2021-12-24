package com.hjrpc.springframework.context;

import com.hjrpc.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;
}
