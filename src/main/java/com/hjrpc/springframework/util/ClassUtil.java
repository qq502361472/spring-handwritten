package com.hjrpc.springframework.util;

public class ClassUtil {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }

        if (cl == null) {
            cl = ClassUtil.class.getClassLoader();
        }
        return cl;
    }
}
