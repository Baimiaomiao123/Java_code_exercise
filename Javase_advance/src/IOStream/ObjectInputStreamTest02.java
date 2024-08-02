package IOStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInputStreamTest02 {
    public static void main(String[] args) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("javase_advance/src/IOStream/File/users"));
//            Object obj = ois.readObject();
//            System.out.println(obj instanceof List);
            //向下转型
            List<User> userList = (List<User>)ois.readObject();
            for (User user:
                 userList) {
                System.out.println(user);
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
