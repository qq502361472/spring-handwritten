package com.hjrpc.springframework.context.event;

import com.hjrpc.springframework.context.ApplicationEvent;
import com.hjrpc.springframework.context.ApplicationListener;

public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);


    void removeApplicationListener(ApplicationListener<?> listener);


    void multicastEvent(ApplicationEvent event);
}
