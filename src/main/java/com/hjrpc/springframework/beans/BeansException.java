package com.hjrpc.springframework.beans;

public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
