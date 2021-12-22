import bean.UserDao;
import bean.UserService;
import cn.hutool.core.io.IoUtil;
import com.hjrpc.springframework.beans.PropertyValue;
import com.hjrpc.springframework.beans.PropertyValues;
import com.hjrpc.springframework.beans.factory.config.BeanDefinition;
import com.hjrpc.springframework.beans.factory.config.BeanReference;
import com.hjrpc.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.hjrpc.springframework.core.io.DefaultResourceLoader;
import com.hjrpc.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {
    private DefaultResourceLoader defaultResourceLoader;

    @Before
    public void init() {
        defaultResourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClasspath() throws IOException {
        Resource resource = defaultResourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testFile() throws IOException {
        Resource resource = defaultResourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testBeanFactory() {
        // 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        String beanName = "userDao";
        beanFactory.registerBeanDefinition(beanName, new BeanDefinition(UserDao.class));

        // 封装 userService bean定义信息
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", "10002"));
        propertyValues.addPropertyValue(new PropertyValue(beanName, new BeanReference(beanName)));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);

        // 注册
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUser();

    }
}
