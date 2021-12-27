package com.hjrpc.springframework.context.support;

import com.hjrpc.springframework.beans.BeansException;
import com.hjrpc.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.hjrpc.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.hjrpc.springframework.beans.factory.config.BeanPostProcessor;
import com.hjrpc.springframework.context.ConfigurableApplicationContext;
import com.hjrpc.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {


    @Override
    public void refresh() throws BeansException {
        // 创建 BeanFactory，并加载 BeanDefinition
        refreshBeanFactory();

        // 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 手动添加 ApplicationContextAwareProcessor
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 在 Bean 实例化之前执行 BeanFactoryPostProcessor 增强
        invokeBeanFactoryPostProcessors(beanFactory);

        // BeanPostProcessor 注册操作
        registerBeanPostProcessor(beanFactory);

        // 提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();

    }

    private void registerBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beansOfType.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beansOfType.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    protected abstract void refreshBeanFactory();

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) {
        return getBeanFactory().getBean(beanName, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
