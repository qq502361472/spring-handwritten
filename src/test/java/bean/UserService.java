package bean;

import com.hjrpc.springframework.beans.factory.DisposableBean;
import com.hjrpc.springframework.beans.factory.InitializingBean;

public class UserService implements InitializingBean, DisposableBean {
    private String userId;
    private String company;
    private String location;
    private UserDao userDao;

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

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
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
}
