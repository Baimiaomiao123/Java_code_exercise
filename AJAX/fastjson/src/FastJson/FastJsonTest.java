package FastJson;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;

public class FastJsonTest {
    public static void main(String[] args) {
        User user1 = new User("111","zhangsan",20);
        //将以上的User对象转换成json格式的字符串
        //使用阿里巴巴的fastjson组件中的JSON类即可
        //fastjson有一个类，叫做JSON，JSON类中的方法都是静态方法，可以直接调用
        String jsonStr = JSON.toJSONString(user1);

        System.out.println(jsonStr);

        //尝试List集合是否能转换成数组
        User user2 = new User("120","lisi",21);
        User user3 = new User("130","wangwu",22);

        //将User对象放到List集合中
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        //转换成JSON格式字符串
        String JsonUserStr = JSON.toJSONString(userList);
        System.out.println(JsonUserStr);


    }
}
