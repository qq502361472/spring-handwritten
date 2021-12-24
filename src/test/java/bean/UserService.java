package bean;

public class UserService {
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
}
