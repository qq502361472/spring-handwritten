import bean.UserDao;
import bean.UserService;
import com.hjrpc.springframework.beans.PropertyValue;
import com.hjrpc.springframework.beans.PropertyValues;
import com.hjrpc.springframework.beans.factory.config.BeanDefinition;
import com.hjrpc.springframework.beans.factory.config.BeanReference;
import com.hjrpc.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {

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
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class,propertyValues);

        // 注册
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUser();

    }
}
