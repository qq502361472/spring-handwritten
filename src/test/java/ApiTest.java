import bean.UserService;
import com.hjrpc.springframework.beans.factory.config.BeanDefinition;
import com.hjrpc.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBeanFactory(){
        // 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 构建 BeanDefinition 信息
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        // 注册 BeanDefinition 信息
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        // 第一次获取单例bean
        UserService userService = (UserService) beanFactory.getBean("userService","张三");
        userService.queryUser();

        // 第二次获取单例bean
        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService2.queryUser();
        System.out.println("end");
    }
}
