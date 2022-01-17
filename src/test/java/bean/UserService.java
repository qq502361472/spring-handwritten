package bean;

import com.hjrpc.springframework.beans.BeansException;
import com.hjrpc.springframework.beans.factory.*;
import com.hjrpc.springframework.context.ApplicationContext;
import com.hjrpc.springframework.context.ApplicationContextAware;

public class UserService implements InitializingBean, DisposableBean, ApplicationContextAware, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware {
    private String userId;
    private String company;
    private String location;
    private IUserDao userDao;

    public void queryUserInfo() {
        String userName = userDao.queryUserName(userId);
        System.out.println("username:" + userName);
        System.out.println("userId:" + userId);
        System.out.println("company:" + company);
        System.out.println("location:" + location);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("UserService destroy....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserService afterPropertiesSet....");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("classLoader:" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory:" + beanFactory);
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("beanName:" + beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext:" + applicationContext);
    }
}
