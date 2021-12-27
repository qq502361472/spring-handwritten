package com.hjrpc.springframework.beans.factory;

public interface InitializingBean {

    void afterPropertiesSet() throws Exception;

}