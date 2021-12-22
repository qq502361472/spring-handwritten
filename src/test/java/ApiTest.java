import bean.UserService;
import cn.hutool.core.io.IoUtil;
import com.hjrpc.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.hjrpc.springframework.beans.factory.xml.XmlBeanDefinitionReader;
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
    public void testUrl() throws IOException {
        Resource resource = defaultResourceLoader.getResource("https://gitee.com/HuJianMonn/web-test");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testBeanFactory() {
        // 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUser();

    }
}
