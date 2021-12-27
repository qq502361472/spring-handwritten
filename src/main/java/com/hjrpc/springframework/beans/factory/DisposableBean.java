package com.hjrpc.springframework.beans.factory;

public interface DisposableBean {

    void destroy() throws Exception;

}