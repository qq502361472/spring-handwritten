package bean;

public class UserService {
    UserDao userDao;
    String name;
    String userId;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUser() {
        String userName = userDao.queryUserName(userId);
        System.out.println("查询用户信息:" + userName);
    }
}
