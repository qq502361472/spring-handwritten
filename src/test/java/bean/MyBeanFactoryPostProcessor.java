package bean;

import com.hjrpc.springframework.beans.BeansException;
import com.hjrpc.springframework.beans.PropertyValue;
import com.hjrpc.springframework.beans.PropertyValues;
import com.hjrpc.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.hjrpc.springframework.beans.factory.config.BeanDefinition;
import com.hjrpc.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "招银云创"));
    }
}
