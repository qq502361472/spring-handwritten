package bean;

public class UserService {
    String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUser() {
        System.out.println("查询用户信息:" + name);
    }
}
