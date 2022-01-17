package com.hjrpc.springframework.context.event;

import com.hjrpc.springframework.beans.factory.BeanFactory;
import com.hjrpc.springframework.context.ApplicationEvent;
import com.hjrpc.springframework.context.ApplicationListener;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
