package IOStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
    一次序列化多个对象呢？
        可以，可以将对象放到集合当中，序列化集合

    提示：
        参与序列化的ArrayList集合以及集合中的元素User都需要实现java.io.Serializable接口

 */
public class ObjectOutputStreamTest02 {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User(1,"zhangsan"));
        users.add(new User(2,"lisi"));
        users.add(new User(3,"wangwu"));

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("javase_advance/src/IOStream/File/users"));
            //序列化一个集合，这个集合包含多个对象
            oos.writeObject(users);

            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
