package bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initUserDao() {
        System.out.println("initUserDao...");
        hashMap.put("10001", "张三");
        hashMap.put("10002", "李四");
        hashMap.put("10003", "王五");
    }

    public void destroyUserDao(){
        hashMap.clear();
        System.out.println("destroyUserDao...");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}